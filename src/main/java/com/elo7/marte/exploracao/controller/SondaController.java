package com.elo7.marte.exploracao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elo7.marte.exploracao.model.rest.SondaREST;

@Controller
@RequestMapping("/sondas")
public class SondaController {

	@RequestMapping(value = "{sondaId}", method = RequestMethod.GET)	
	public @ResponseBody 
	SondaREST getSondaInJSON (@PathVariable Integer sondaId){
		
		
		SondaREST sonda = new SondaREST();
		sonda.setSondaId(sondaId);
		sonda.setX(2);
		sonda.setY(2);
		
		
		return sonda;
	}
	
}