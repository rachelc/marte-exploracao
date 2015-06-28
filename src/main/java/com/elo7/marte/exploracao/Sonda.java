package com.elo7.marte.exploracao;

public class Sonda {
	
	private Integer x;
	private Integer y;
	private Direcao direcao;
	private Planalto planalto;
	
	public Sonda(Integer x, Integer y, Direcao direcao, Planalto planalto){
		this.x = x;
		this.y = y;
		this.direcao = direcao;
		this.planalto = planalto;
	}

	
	public void execute(Acao acao){
		
		if(acao.equals(Acao.MOVER)){
				move();
		}else{
			gira(acao);
		}
	}
	
	private void gira(Acao acao){
		if(acao.equals(Acao.ESQUERDA)){
			direcao = direcao.virarEsquerda();
		}
		
		if(acao.equals(Acao.DIREITA)){
			direcao = direcao.virarDireita();
		}
	}
	
	private void move(){
		
		if(direcao.equals(Direcao.N)){
			y++;
		}
		
		if(direcao.equals(Direcao.S)){
			y--;
		}

		if(direcao.equals(Direcao.E)){
			x++;
		}

		if(direcao.equals(Direcao.W)){
			x--;
		}
		
		if(y > planalto.getY()){
			y = planalto.getY();
		}

		if(x > planalto.getX()){
			x = planalto.getX();
		}
		
		if(y < 0){
			y = 0;
		}

		if(x < 0){
			x = 0;
		}		
		
	}


	@Override
	public String toString() {
		return x+" "+y+" "+direcao;
	}
	
	
	
}
