package com.elo7.marte.exploracao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SondaTest {
	
	Planalto planalto;
	
	@Before
	public void setUp() throws Exception {
		planalto = new Planalto(2, 2);			
	}	
	
	@Test
	public void testMoverNorte() {
		
		Sonda sonda = new Sonda(1, 1, Direcao.N, planalto);
		
		sonda.executar(Acao.MOVER);		
		assertEquals("1 2 N", sonda.toString());
		
		// Sonda deve parar na borda
		sonda.executar(Acao.MOVER);				
		assertEquals("1 2 N", sonda.toString());				
	}

	@Test
	public void testMoverLeste() {
		
		Sonda sonda = new Sonda(1, 1, Direcao.E, planalto);
		
		sonda.executar(Acao.MOVER);		
		assertEquals("2 1 E", sonda.toString());
		
		// Sonda deve parar na borda
		sonda.executar(Acao.MOVER);				
		assertEquals("2 1 E", sonda.toString());				
	}

	@Test
	public void testMoverOeste() {
		
		Sonda sonda = new Sonda(1, 1, Direcao.W, planalto);
		
		sonda.executar(Acao.MOVER);		
		assertEquals("0 1 W", sonda.toString());
		
		// Sonda deve parar na borda
		sonda.executar(Acao.MOVER);				
		assertEquals("0 1 W", sonda.toString());				
	}

	@Test
	public void testMoverSul() {
		
		Sonda sonda = new Sonda(1, 1, Direcao.S, planalto);
		
		sonda.executar(Acao.MOVER);		
		assertEquals("1 0 S", sonda.toString());
		
		// Sonda deve parar na borda
		sonda.executar(Acao.MOVER);				
		assertEquals("1 0 S", sonda.toString());				
	}

	@Test
	public void testGirarDireita() {
		
		Sonda sonda = new Sonda(1, 1, Direcao.N, planalto);
		
		sonda.executar(Acao.DIREITA);
		assertEquals("1 1 E", sonda.toString());
	}

	@Test
	public void testGirarEsquerda() {
		
		Sonda sonda = new Sonda(1, 1, Direcao.N, planalto);
		
		sonda.executar(Acao.ESQUERDA);
		assertEquals("1 1 W", sonda.toString());
	}
	
}
