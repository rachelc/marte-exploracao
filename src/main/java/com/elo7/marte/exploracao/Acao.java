package com.elo7.marte.exploracao;

public enum Acao {

	ESQUERDA, DIREITA, MOVER;
	
	public static Acao getAcao(char acao){
		if(acao == 'L'){
			return ESQUERDA;
		}
		
		if(acao == 'R'){
			return DIREITA;
		}

		if(acao == 'M'){
			return MOVER;
		}		
		
		throw new IllegalArgumentException("Ação inválida "+acao);
	}
	
}
