package com.elo7.marte.exploracao;

public class Sonda {
	
	private Integer x;
	private Integer y;
	private Direcao direcao;
	private Planalto planalto;
	
	private static char ESQUERDA = 'L';
	private static char DIREITA = 'R';
	
	public Sonda(Integer x, Integer y, Direcao coordenada, Planalto planalto){
		this.x = x;
		this.y = y;
		this.direcao = coordenada;
		this.planalto = planalto;
	}

	
	public String execute(String instrucoes){
		
		char[] acoes = instrucoes.toCharArray();
		
		for(char acao: acoes){
			if(acao == 'M'){
				move();
			}else{
				gira(acao);
			}
		}
		
		return x+" "+y+" "+direcao;
	}
	
	private void gira(char acao){
		if(acao == ESQUERDA){
			direcao = direcao.viraEsquerda();
		}
		
		if(acao == DIREITA){
			direcao = direcao.viraDireita();
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
}
