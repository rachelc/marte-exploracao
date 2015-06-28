package com.elo7.marte.exploracao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DirecaoTest {
	
	
	@Test
	public void testVirarDireita() {
		
		Direcao direcao = Direcao.N;
		
		direcao = direcao.virarDireita();
		assertEquals(Direcao.E, direcao);
		
		direcao = direcao.virarDireita();
		assertEquals(Direcao.S, direcao);
		
		direcao = direcao.virarDireita();
		assertEquals(Direcao.W, direcao);
		
		direcao = direcao.virarDireita();
		assertEquals(Direcao.N, direcao);		
	}

	
	@Test
	public void testVirarEsquerda() {
		
		Direcao direcao = Direcao.N;
		
		direcao = direcao.virarEsquerda();
		assertEquals(Direcao.W, direcao);
		
		direcao = direcao.virarEsquerda();
		assertEquals(Direcao.S, direcao);
		
		direcao = direcao.virarEsquerda();
		assertEquals(Direcao.E, direcao);
		
		direcao = direcao.virarEsquerda();
		assertEquals(Direcao.N, direcao);		
	}
	
}
