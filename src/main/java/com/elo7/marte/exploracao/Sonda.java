package com.elo7.marte.exploracao;

public class Sonda {
	
	private Integer idSonda;
	private Coordenada coordenada;
	private Direcao direcao;
	private Planalto planalto;
	
	public Sonda(Integer idSonda, Coordenada coordenada, Direcao direcao, Planalto planalto){
		this.idSonda = idSonda;
		this.coordenada = coordenada;
		this.direcao = direcao;
		this.planalto = planalto;
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

	public Integer getIdSonda() {
		return idSonda;
	}


	public void setIdSonda(Integer idSonda) {
		this.idSonda = idSonda;
	}


	@Override
	public String toString() {
		return coordenada.getX()+" "+coordenada.getY()+" "+direcao;
	}
	
	
	
}
