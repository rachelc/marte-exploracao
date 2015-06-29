package com.elo7.marte.exploracao.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elo7.marte.exploracao.model.rest.SondaREST;

@Controller
@RequestMapping("/sondas")
public class SondaController {

	@RequestMapping(value = "{sondaId}", method = GET)	
	public @ResponseBody SondaREST getSonda (@PathVariable Integer sondaId){
		
		
		SondaREST sonda = new SondaREST(5, 1);
		
		
		return sonda;
	}
	
}