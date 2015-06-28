package com.elo7.marte.exploracao;

public class Coordenada {

	private Integer x;
	private Integer y;
	
	public Coordenada(Integer x, Integer y){
		this.x = x;
		this.y = y;
	}

	public Integer getX() {
		return this.x;
	}

	public Integer getY() {
		return this.y;
	}
	
	public void setX(Integer x) {
		this.x = x;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Integer addX(Integer n) {
		return this.x = this.x+n;
	}

	public Integer addY(Integer n) {
		return this.y = this.y+n;
	}
	
}
