package com.elo7.marte.exploracao;

import java.util.StringTokenizer;

public class Nasa {
	
	public String enviaSondas(Planalto planalto, String instrucoes){
			
		StringBuffer resultado = new StringBuffer();

		StringTokenizer st = new StringTokenizer(instrucoes, "\n");
		 
		while(st.hasMoreTokens()){			
		   resultado.append(nextSonda(planalto, st.nextToken(), st.nextToken()));
		   resultado.append("\n");
		}
		
		return resultado.toString();
		
	}
	
	
	private String nextSonda(Planalto planalto, String coordenadas, String instrucoes){
		Sonda sonda = new Sonda(1, 2, Coordenada.N, planalto);
		return sonda.move(instrucoes);
	}
		
}
