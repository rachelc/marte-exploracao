package com.elo7.marte.exploracao.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elo7.marte.exploracao.leitura.LeitorDadosSonda;

@Component
public class Nasa {
	
	@Autowired
	private LeitorDadosSonda leitorDadosSonda;
	
	private List<Sonda> sondas;
	
	public void carregaSondas(String instrucoesGerais){
			
		this.sondas = leitorDadosSonda.getSondas(instrucoesGerais);		
	}

	public void enviarSondas(){
		
		for(Sonda sonda : sondas){
				
			sonda.executarAcoes();				
		}
	}

	
	public String relatorioSondas(){

		StringBuffer resultado = new StringBuffer();
		for(Sonda sonda : sondas){
			
			resultado.append(sonda.toString());
			resultado.append("\n");
		}
		
		return resultado.toString();
	}
}
