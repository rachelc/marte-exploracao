package com.elo7.marte.exploracao.model;

import java.util.ArrayList;
import java.util.List;

public class Sonda {
	
	private Coordenada coordenada;
	private Direcao direcao;
	private Planalto planalto;
	private Integer sondaId;
	private Boolean processada = false;
	
	private List<Acao> acoes;
	
	public Sonda(){
		
	}
	
	public Sonda(Integer sondaId, Coordenada coordenada, Direcao direcao, Planalto planalto){
		this.sondaId = sondaId;
		this.coordenada = coordenada;
		this.direcao = direcao;
		this.planalto = planalto;
		this.acoes = new ArrayList<Acao>();
	}


	public void carregarAcoes(String instrucoes){
		
		if(instrucoes == null)
			return;
		
		char[] comandos = instrucoes.toCharArray();
		for(char acao : comandos){
			acoes.add(Acao.getAcao(acao));
		}
		
	}

	public void executarAcoes(){
		
		if(acoes == null || processada){
			return;
		}
		
		for(Acao acao : acoes){
			executar(acao);
		}
		
		this.processada = true;
		
	}
	
	public void executar(Acao acao){
		
		if(acao == null){
			return;
		}
		
		if(acao.equals(Acao.M)){
				mover();
		}else{
			girar(acao);
		}
	}
	
	private void girar(Acao acao){
		
		if(acao == null || direcao == null){
			return;
		}
		
		if(acao.equals(Acao.L)){
			direcao = direcao.virarEsquerda();
		}
		
		if(acao.equals(Acao.R)){
			direcao = direcao.virarDireita();
		}
	}
	
	private void mover(){
		
		if(direcao == null || coordenada == null){
			return;
		}
		
		if(direcao.equals(Direcao.N) &&
		   this.coordenada.getY() < planalto.getY()){
		   this.coordenada.addY(1);
		}
		
		if(direcao.equals(Direcao.S) &&
		   this.coordenada.getY() > 0){
			this.coordenada.addY(-1);
		}

		if(direcao.equals(Direcao.E) &&
		   this.coordenada.getX() < planalto.getX()){
			this.coordenada.addX(1);
		}

		if(direcao.equals(Direcao.W) &&
			this.coordenada.getX() > 0){
			this.coordenada.addX(-1);
		}
						
	}

	@Override
	public String toString() {
		if(coordenada == null || direcao == null){
			return "";
		}
		
		return coordenada.getX()+" "+coordenada.getY()+" "+direcao;
	}

	public Integer getSondaId() {
		return sondaId;
	}

	public void setSondaId(Integer sondaId) {
		this.sondaId = sondaId;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	public Direcao getDirecao() {
		return direcao;
	}

	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}

	public Planalto getPlanalto() {
		return planalto;
	}

	public void setPlanalto(Planalto planalto) {
		this.planalto = planalto;
	}

	public List<Acao> getAcoes() {
		return acoes;
	}

	public void setAcoes(List<Acao> acoes) {
		this.acoes = acoes;
	}
	
	
	
	
}
