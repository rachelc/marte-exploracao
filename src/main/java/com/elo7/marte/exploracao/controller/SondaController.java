package com.elo7.marte.exploracao.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elo7.marte.exploracao.model.Nasa;
import com.elo7.marte.exploracao.model.Sonda;

@Controller
@RequestMapping("/sondas")
public class SondaController {
	
	@Autowired
	private Nasa nasa;

	@RequestMapping(value = "{sondaId}", method = RequestMethod.GET)	
	public @ResponseBody 
	Sonda getSonda(@PathVariable Integer sondaId){				
		
		return nasa.getSonda(sondaId);		
	}

	@RequestMapping(value = "{sondaId}", method = RequestMethod.PUT)	
	public @ResponseBody 
	Sonda addSonda(@PathVariable Integer sondaId, @RequestBody Sonda sonda){
		
		sonda.setSondaId(sondaId);
		nasa.addSonda(sondaId, sonda);
		
		return sonda;
	}
	
	@RequestMapping(method = RequestMethod.POST)	
	public @ResponseBody 
	Collection<Sonda> processarSondas(){				
		
		nasa.enviarSondas();	
		
		return nasa.getSondas();		
	}

	@RequestMapping(method = RequestMethod.GET)	
	public @ResponseBody 
	Collection<Sonda> getSondas(){				
		
		return nasa.getSondas();		
	}
	
}