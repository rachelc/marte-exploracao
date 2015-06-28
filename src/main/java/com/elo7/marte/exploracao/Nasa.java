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
		
		StringTokenizer st = new StringTokenizer(coordenadas, " ");
		
		Integer x = Integer.parseInt(st.nextToken());
		Integer y = Integer.parseInt(st.nextToken());
		String direcao = st.nextToken();
				
		Sonda sonda = new Sonda(x, y, Direcao.valueOf(direcao), planalto);
		
		char[] acoes = instrucoes.toCharArray();
		for(char acao : acoes){
			sonda.execute(Acao.getAcao(acao));
		}
		
		return sonda.toString();
	}
		
}
