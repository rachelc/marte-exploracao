package com.elo7.marte.exploracao;

import java.util.HashMap;
import java.util.Map;

public enum Direcao {
	
	N, E, S, W;
	
	private static Map<Integer, Direcao> mapDirecoes = new HashMap<Integer, Direcao>();
	
	static{
		Direcao[] direcoes = Direcao.values();
		for(Direcao direcao:direcoes){
			mapDirecoes.put(direcao.ordinal(), direcao);
		}
	}
					
	
	public Direcao viraDireita(){
		
		Integer novaDirecao = ordinal()+1;
		if(novaDirecao > 3){
			novaDirecao = 0;
		}
		
		return mapDirecoes.get(novaDirecao);
	}
	
	
	public Direcao viraEsquerda(){

		Integer novaDirecao = this.ordinal()-1;
		if(novaDirecao < 0){
			novaDirecao = 3;
		}
		
		return mapDirecoes.get(novaDirecao);
		
	}
		
}
