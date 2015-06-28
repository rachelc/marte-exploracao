package com.elo7.marte.exploracao;


public class Nasa {
	
	public String enviarSondas(String instrucoesGerais){
			
		if(instrucoesGerais == null){
			return "";
		}

		String[] instrucoes = instrucoesGerais.split("\n");		
		Planalto planalto = getPlanalto(instrucoes[0]);
		
		StringBuffer resultado = new StringBuffer();
		Integer idSonda = 0;
		for(int i=1; i<instrucoes.length; i=i+2){			
		   resultado.append(enviarSonda(idSonda++, planalto, instrucoes[i], instrucoes[i+1]));
		   resultado.append("\n");
		}
		
		return resultado.toString();
		
	}

	private String enviarSonda(Integer idSonda, Planalto planalto, String posicaoSonda, String instrucoes){
		
		Sonda sonda = getSonda(idSonda, planalto, posicaoSonda);
		
		char[] acoes = instrucoes.toCharArray();
		for(char acao : acoes){
			sonda.executar(Acao.getAcao(acao));
		}
		
		return sonda.toString();
	}

	private Coordenada getCoodernada(String stX, String stY){
		Integer x = Integer.parseInt(stX);
		Integer y = Integer.parseInt(stY);

		return new Coordenada(x, y);
	}
	
	private Planalto getPlanalto(String posicaoPlanalto){
		
		String[] dadosPosicaoPlanalto = posicaoPlanalto.split(" ");		
		
		Coordenada coordenada = getCoodernada(dadosPosicaoPlanalto[0], dadosPosicaoPlanalto[1]);
		
		Planalto planalto = new Planalto(coordenada);
		
		return planalto;
	}
	
	
	private Sonda getSonda(Integer idSonda, Planalto planalto, String posicaoSonda){
		
		String[] dadosPosicaoSonda = posicaoSonda.split(" ");		
		
		Coordenada coordenada = getCoodernada(dadosPosicaoSonda[0], dadosPosicaoSonda[1]);
		
		Direcao direcao = Direcao.valueOf(dadosPosicaoSonda[2]);
				
		Sonda sonda = new Sonda(idSonda, coordenada, direcao, planalto);
		
		return sonda;
	}
	
		
}
