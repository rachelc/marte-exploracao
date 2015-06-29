package com.elo7.marte.exploracao.leitura;

import java.util.Hashtable;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.elo7.marte.exploracao.model.Coordenada;
import com.elo7.marte.exploracao.model.Direcao;
import com.elo7.marte.exploracao.model.Planalto;
import com.elo7.marte.exploracao.model.Sonda;

@Component
public class LeitorDadosSondaTexto implements LeitorDadosSonda{
	
	public Map<Integer, Sonda> getSondas(String instrucoesGerais){
		Map<Integer, Sonda> sondas = new Hashtable<Integer, Sonda>();

		if(instrucoesGerais == null){
			throw new IllegalArgumentException("instru��es inv�lidas, linhas insuficientes");
		}

		String[] instrucoes = instrucoesGerais.split("\n");
		
		if(instrucoes.length < 3|| (instrucoes.length % 2 != 1 )){
			throw new IllegalArgumentException("instru��es inv�lidas, linhas insuficientes");
		}		
		
		Planalto planalto = getPlanalto(instrucoes[0]);		
		
		Integer sondaId = 0;
		for(int i=1; i<instrucoes.length; i=i+2){			
		   sondas.put(new Integer(sondaId), getSonda(sondaId, planalto, instrucoes[i], instrucoes[i+1]));
		   sondaId++;
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
			throw new IllegalArgumentException(identificador+" coordenadas inv�lidas: "+stX+" "+stY);
		}
	  
		return coordenada; 
	}
	
	private Planalto getPlanalto(String posicaoPlanalto){
		
		String[] dadosPosicaoPlanalto = posicaoPlanalto.split(" ");
		
		if(dadosPosicaoPlanalto.length < 2){
			throw new IllegalArgumentException("planalto coordenadas inv�lidas: "+posicaoPlanalto);
		}
		
		
		Coordenada coordenada = getCoodernada("planalto",dadosPosicaoPlanalto[0], dadosPosicaoPlanalto[1]);
		
		Planalto planalto = new Planalto(coordenada);
		
		return planalto;
	}
	
	
	private Sonda getSonda(Integer sondaId, Planalto planalto, String posicaoSonda, String instrucoes){
		
		String[] dadosPosicaoSonda = posicaoSonda.split(" ");
		
		if(dadosPosicaoSonda.length < 3){
			throw new IllegalArgumentException("sonda."+sondaId+" coordenadas inv�lidas: "+posicaoSonda);
		}
		
		Coordenada coordenada = getCoodernada("sonda."+sondaId, dadosPosicaoSonda[0], dadosPosicaoSonda[1]);
		
		Direcao direcao = Direcao.valueOf(dadosPosicaoSonda[2]);
		
		if(direcao == null){
			throw new IllegalArgumentException("sonda."+sondaId+" direcao inv�lida: "+direcao);
		}
				
		Sonda sonda = new Sonda(sondaId, coordenada, direcao, planalto);
		
		try{
			sonda.carregarAcoes(instrucoes);
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("sonda."+sondaId+" a��o inv�lida: "+instrucoes);
		}
		
		return sonda;
	}
	
		
}
