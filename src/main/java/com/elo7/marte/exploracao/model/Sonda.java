package com.elo7.marte.exploracao.model;

import java.util.ArrayList;
import java.util.List;

public class Sonda {
	
	private Coordenada coordenada;
	private Direcao direcao;
	private Planalto planalto;
	
	private List<Acao> acoes;
	
	public Sonda(Coordenada coordenada, Direcao direcao, Planalto planalto){
		this.coordenada = coordenada;
		this.direcao = direcao;
		this.planalto = planalto;
		this.acoes = new ArrayList<Acao>();
	}


	public void carregarAcoes(String instrucoes){
		
		char[] comandos = instrucoes.toCharArray();
		for(char acao : comandos){
			acoes.add(Acao.getAcao(acao));
		}
		
	}

	public void executarAcoes(){
		
		for(Acao acao : acoes){
			executar(acao);
		}
		
	}
	
	public void executar(Acao acao){
		
		if(acao.equals(Acao.MOVER)){
				mover();
		}else{
			girar(acao);
		}
	}
	
	private void girar(Acao acao){
		if(acao.equals(Acao.ESQUERDA)){
			direcao = direcao.virarEsquerda();
		}
		
		if(acao.equals(Acao.DIREITA)){
			direcao = direcao.virarDireita();
		}
	}
	
	private void mover(){
		
		if(direcao.equals(Direcao.N) &&
		   this.coordenada.getY() < planalto.getCoordenadaMaxima().getY()){
		   this.coordenada.addY(1);
		}
		
		if(direcao.equals(Direcao.S) &&
		   this.coordenada.getY() > 0){
			this.coordenada.addY(-1);
		}

		if(direcao.equals(Direcao.E) &&
		   this.coordenada.getX() < planalto.getCoordenadaMaxima().getX()){
			this.coordenada.addX(1);
		}

		if(direcao.equals(Direcao.W) &&
			this.coordenada.getX() > 0){
			this.coordenada.addX(-1);
		}
						
	}

	@Override
	public String toString() {
		return coordenada.getX()+" "+coordenada.getY()+" "+direcao;
	}
	
	
	
}
