package com.elo7.marte.exploracao;

public class Sonda {
	
	private Coordenada coordenada;
	private Direcao direcao;
	private Planalto planalto;
	
	public Sonda(Coordenada coordenada, Direcao direcao, Planalto planalto){
		this.coordenada = coordenada;
		this.direcao = direcao;
		this.planalto = planalto;
	}


	public void executar(String instrucoes){
		
		char[] acoes = instrucoes.toCharArray();
		for(char acao : acoes){
			this.executar(Acao.getAcao(acao));
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
