package com.elo7.marte.exploracao.model;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elo7.marte.exploracao.leitura.LeitorDadosSonda;

@Component
public class Nasa {
	
	@Autowired
	private LeitorDadosSonda leitorDadosSonda;
	
	private Map<Integer, Sonda> sondas = new Hashtable<Integer, Sonda>();	
	
	
	public void addSonda(Integer sondaId, Sonda sonda){		
		sondas.put(sondaId, sonda);
	}
	
	public Sonda getSonda(Integer sondaId){
		return sondas.get(sondaId);
	}
	
	public void addSondas(String instrucoesGerais){
			
		Map<Integer, Sonda> novasSondas = leitorDadosSonda.getSondas(instrucoesGerais);		
		if(novasSondas != null){
			sondas.putAll(novasSondas);
		}
	}

	public Collection<Sonda> getSondas(){
		return sondas.values();
	}
	
	public void enviarSondas(){
		
		Collection<Sonda> values = sondas.values();
		for(Sonda sonda : values){
				
			sonda.executarAcoes();				
		}
	}

	
	public String relatorioSondas(){

		StringBuffer resultado = new StringBuffer();
		Collection<Sonda> values = sondas.values();
		for(Sonda sonda : values){
			
			resultado.append(sonda.toString());
			resultado.append("\n");
		}
		
		return resultado.toString();
	}
}
