package com.elo7.marte.exploracao.model;

public class Planalto {

	private Coordenada coordenadaMaxima;
	
	public Planalto(){
		this.coordenadaMaxima = new Coordenada(0, 0);
	}
	
	public Planalto(Coordenada coordenada){
		this.coordenadaMaxima = coordenada;
	}

	/*
	public Coordenada getCoordenadaMaxima(){
		return this.coordenadaMaxima;
	}*/
	
	public Integer getX(){
		return coordenadaMaxima.getX();
	}
	
	public Integer getY(){
		return coordenadaMaxima.getY();
	}
	
	public void setX(Integer x){
		this.coordenadaMaxima.setX(x);
	}

	public void setY(Integer y){
		this.coordenadaMaxima.setY(y);
	}
	
}
