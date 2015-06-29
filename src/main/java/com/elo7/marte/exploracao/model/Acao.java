package com.elo7.marte.exploracao.model;

public enum Acao {

	L, R, M;
	
	public static Acao getAcao(char acao){
		if(acao == 'L'){
			return L;
		}
		
		if(acao == 'R'){
			return R;
		}

		if(acao == 'M'){
			return M;
		}		
		
		throw new IllegalArgumentException("A��o inv�lida "+acao);
	}
	
}
