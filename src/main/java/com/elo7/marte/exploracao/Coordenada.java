package com.elo7.marte.exploracao;

public enum Coordenada {
	
	N("N"), E("E"), S("S"), W("W");
	
	private String coordenada;
	
	private Coordenada(String coordenada){
		this.coordenada = coordenada;
	}
	
	public String getCoordenada(){
		return this.coordenada;
	}

}
