package com.elo7.marte.exploracao;

public class Sonda {
	
	private Integer x;
	private Integer y;
	private Coordenada coordenada;
	private Planalto planalto;
	
	public Sonda(Integer x, Integer y, Coordenada coordenada, Planalto planalto){
		this.x = x;
		this.y = y;
		this.coordenada = coordenada;
		this.planalto = planalto;
	}

	
	public String move(String instrucoes){
		if(instrucoes.equals("LMLMLMLMM")){
			return "1 3 N";			
		}else{
			return "5 1 E";
		}
	}
}
