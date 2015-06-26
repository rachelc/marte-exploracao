package com.elo7.marte.exploracao;

import java.util.HashMap;
import java.util.Map;

public enum Direcao {
	
	N("N", 0), E("E", 1), S("S", 2), W("W", 3);
	
	private String direcao;
	private Integer valor;
	
	private static Map<Integer, Direcao> mapDirecoes = new HashMap<Integer, Direcao>();
	
	static{
		Direcao[] direcoes = Direcao.values();
		for(Direcao direcao:direcoes){
			mapDirecoes.put(direcao.valor, direcao);
		}
	}
	
				
	private Direcao(String coordenada, Integer valor){
		this.direcao = coordenada;
		this.valor = valor;
	}
	
	
	public Direcao viraDireita(){
		
		Integer novoValor = valor+1;
		if(novoValor > 3){
			novoValor = 0;
		}
		
		return mapDirecoes.get(novoValor);
	}
	
	
	public Direcao viraEsquerda(){

		Integer novoValor = valor-1;
		if(novoValor < 0){
			novoValor = 3;
		}
		
		return mapDirecoes.get(novoValor);
		
	}
		
}
