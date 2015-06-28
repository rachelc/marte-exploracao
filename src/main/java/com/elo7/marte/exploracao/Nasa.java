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
		
		try{
			
			sonda.executar(instrucoes);
			
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("sonda."+idSonda+" ação inválida "+instrucoes);
		}
		
		return sonda.toString();
	}

	private Coordenada getCoodernada(String identificador, String stX, String stY){
		
		Coordenada coordenada;
		
		try{
			Integer x = Integer.parseInt(stX);
			Integer y = Integer.parseInt(stY);
			
			coordenada = new Coordenada(x, y);
		}catch(NumberFormatException e){
			throw new IllegalArgumentException(identificador+" coordenadas inválidas "+stX+" "+stY);
		}
	  
		return coordenada; 
	}
	
	private Planalto getPlanalto(String posicaoPlanalto){
		
		String[] dadosPosicaoPlanalto = posicaoPlanalto.split(" ");		
		
		Coordenada coordenada = getCoodernada("planalto ",dadosPosicaoPlanalto[0], dadosPosicaoPlanalto[1]);
		
		Planalto planalto = new Planalto(coordenada);
		
		return planalto;
	}
	
	
	private Sonda getSonda(Integer idSonda, Planalto planalto, String posicaoSonda){
		
		String[] dadosPosicaoSonda = posicaoSonda.split(" ");
		
		if(dadosPosicaoSonda.length < 3){
			throw new IllegalArgumentException("sonda."+idSonda+" coordenadas inválidas "+posicaoSonda);
		}
		
		Coordenada coordenada = getCoodernada("sonda."+idSonda, dadosPosicaoSonda[0], dadosPosicaoSonda[1]);
		
		Direcao direcao = Direcao.valueOf(dadosPosicaoSonda[2]);
		
		if(direcao == null){
			throw new IllegalArgumentException("sonda."+idSonda+" direcao inválida "+direcao);
		}
				
		Sonda sonda = new Sonda(coordenada, direcao, planalto);
		
		return sonda;
	}
	
		
}
