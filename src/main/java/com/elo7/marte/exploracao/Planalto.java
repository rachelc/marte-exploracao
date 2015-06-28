package com.elo7.marte.exploracao;

public class Planalto {

	private Coordenada coordenadaMaxima;
	
	public Planalto(Coordenada coordenada){
		this.coordenadaMaxima = coordenada;
	}

	public Coordenada getCoordenadaMaxima(){
		return this.coordenadaMaxima;
	}

}
