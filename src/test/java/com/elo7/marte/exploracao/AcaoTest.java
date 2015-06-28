package com.elo7.marte.exploracao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AcaoTest {

	@Test
	public void testGetAcao() {
		Acao acao = Acao.getAcao('M');
		assertEquals(Acao.MOVER, acao);
		
		acao = Acao.getAcao('L');
		assertEquals(Acao.ESQUERDA, acao);

		acao = Acao.getAcao('R');
		assertEquals(Acao.DIREITA, acao);
		
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetAcaoInvalida() {
		Acao acao = Acao.getAcao('X');
	}
	
}
