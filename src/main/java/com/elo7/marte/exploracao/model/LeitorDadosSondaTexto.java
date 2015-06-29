package com.elo7.marte.exploracao.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class LeitorDadosSondaTexto implements LeitorDadosSonda{
	
	public List<Sonda> getSondas(String instrucoesGerais){
		List<Sonda> sondas = new ArrayList<Sonda>();

		if(instrucoesGerais == null){
			throw new IllegalArgumentException("instruções inválidas, linhas insuficientes");
		}

		String[] instrucoes = instrucoesGerais.split("\n");
		
		if(instrucoes.length < 3|| (instrucoes.length % 2 != 1 )){
			throw new IllegalArgumentException("instruções inválidas, linhas insuficientes");
		}		
		
		Planalto planalto = getPlanalto(instrucoes[0]);		
		
		Integer idSonda = 0;
		for(int i=1; i<instrucoes.length; i=i+2){			
		   sondas.add(getSonda(idSonda++, planalto, instrucoes[i], instrucoes[i+1]));
		}
		
		return sondas;
	}
	

	private Coordenada getCoodernada(String identificador, String stX, String stY){
		
		Coordenada coordenada;
		
		try{
			Integer x = Integer.parseInt(stX);
			Integer y = Integer.parseInt(stY);
			
			coordenada = new Coordenada(x, y);
		}catch(NumberFormatException e){
			throw new IllegalArgumentException(identificador+" coordenadas inválidas: "+stX+" "+stY);
		}
	  
		return coordenada; 
	}
	
	private Planalto getPlanalto(String posicaoPlanalto){
		
		String[] dadosPosicaoPlanalto = posicaoPlanalto.split(" ");
		
		if(dadosPosicaoPlanalto.length < 2){
			throw new IllegalArgumentException("planalto coordenadas inválidas: "+posicaoPlanalto);
		}
		
		
		Coordenada coordenada = getCoodernada("planalto",dadosPosicaoPlanalto[0], dadosPosicaoPlanalto[1]);
		
		Planalto planalto = new Planalto(coordenada);
		
		return planalto;
	}
	
	
	private Sonda getSonda(Integer idSonda, Planalto planalto, String posicaoSonda, String instrucoes){
		
		String[] dadosPosicaoSonda = posicaoSonda.split(" ");
		
		if(dadosPosicaoSonda.length < 3){
			throw new IllegalArgumentException("sonda."+idSonda+" coordenadas inválidas: "+posicaoSonda);
		}
		
		Coordenada coordenada = getCoodernada("sonda."+idSonda, dadosPosicaoSonda[0], dadosPosicaoSonda[1]);
		
		Direcao direcao = Direcao.valueOf(dadosPosicaoSonda[2]);
		
		if(direcao == null){
			throw new IllegalArgumentException("sonda."+idSonda+" direcao inválida: "+direcao);
		}
				
		Sonda sonda = new Sonda(coordenada, direcao, planalto);
		
		try{
			sonda.carregarAcoes(instrucoes);
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("sonda."+idSonda+" ação inválida: "+instrucoes);
		}
		
		return sonda;
	}
	
		
}
