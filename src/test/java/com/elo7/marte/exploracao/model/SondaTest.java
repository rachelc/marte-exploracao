package com.elo7.marte.exploracao.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.elo7.marte.exploracao.model.Acao;
import com.elo7.marte.exploracao.model.Coordenada;
import com.elo7.marte.exploracao.model.Direcao;
import com.elo7.marte.exploracao.model.Planalto;
import com.elo7.marte.exploracao.model.Sonda;

public class SondaTest {
	
	Coordenada coordenadaSonda;
	Planalto planalto;
	Integer sondaId = 0;
	
	@Before
	public void setUp() throws Exception {
		
		coordenadaSonda = new Coordenada(1, 1);
		
		Coordenada coordenada = new Coordenada(2, 2);
		planalto = new Planalto(coordenada);			
	}	
	
	@Test
	public void testMoverNorte() {
		
		Sonda sonda = new Sonda(sondaId, coordenadaSonda, Direcao.N, planalto);
		
		sonda.executar(Acao.M);		
		assertEquals("1 2 N", sonda.toString());
		
		// Sonda deve parar na borda
		sonda.executar(Acao.M);				
		assertEquals("1 2 N", sonda.toString());				
	}

	@Test
	public void testMoverLeste() {
		
		Sonda sonda = new Sonda(sondaId, coordenadaSonda, Direcao.E, planalto);
		
		sonda.executar(Acao.M);		
		assertEquals("2 1 E", sonda.toString());
		
		// Sonda deve parar na borda
		sonda.executar(Acao.M);				
		assertEquals("2 1 E", sonda.toString());				
	}

	@Test
	public void testMoverOeste() {
		
		Sonda sonda = new Sonda(sondaId, coordenadaSonda, Direcao.W, planalto);
		
		sonda.executar(Acao.M);		
		assertEquals("0 1 W", sonda.toString());
		
		// Sonda deve parar na borda
		sonda.executar(Acao.M);				
		assertEquals("0 1 W", sonda.toString());				
	}

	@Test
	public void testMoverSul() {
		
		Sonda sonda = new Sonda(sondaId, coordenadaSonda, Direcao.S, planalto);
		
		sonda.executar(Acao.M);		
		assertEquals("1 0 S", sonda.toString());
		
		// Sonda deve parar na borda
		sonda.executar(Acao.M);				
		assertEquals("1 0 S", sonda.toString());				
	}

	@Test
	public void testGirarDireita() {
		
		Sonda sonda = new Sonda(sondaId, coordenadaSonda, Direcao.N, planalto);
		
		sonda.executar(Acao.R);
		assertEquals("1 1 E", sonda.toString());
	}

	@Test
	public void testGirarEsquerda() {
		
		Sonda sonda = new Sonda(sondaId, coordenadaSonda, Direcao.N, planalto);
		
		sonda.executar(Acao.L);
		assertEquals("1 1 W", sonda.toString());
	}
	
}
