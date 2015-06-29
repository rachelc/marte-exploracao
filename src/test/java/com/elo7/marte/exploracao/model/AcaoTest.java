package com.elo7.marte.exploracao.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.elo7.marte.exploracao.model.Acao;

public class AcaoTest {

	@Test
	public void testGetAcao() {
		Acao acao = Acao.getAcao('M');
		assertEquals(Acao.M, acao);
		
		acao = Acao.getAcao('L');
		assertEquals(Acao.L, acao);

		acao = Acao.getAcao('R');
		assertEquals(Acao.R, acao);
		
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetAcaoInvalida() {
		Acao.getAcao('X');
	}
	
}
