package com.elo7.marte.exploracao;

import static org.junit.Assert.*;

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
		
		sonda.execute(Acao.MOVER);		
		assertEquals("1 2 N", sonda.toString());
		
		// Sonda deve parar na borda
		sonda.execute(Acao.MOVER);				
		assertEquals("1 2 N", sonda.toString());				
	}

	@Test
	public void testMoverLeste() {
		
		Sonda sonda = new Sonda(1, 1, Direcao.E, planalto);
		
		sonda.execute(Acao.MOVER);		
		assertEquals("2 1 E", sonda.toString());
		
		// Sonda deve parar na borda
		sonda.execute(Acao.MOVER);				
		assertEquals("2 1 E", sonda.toString());				
	}
	
}
