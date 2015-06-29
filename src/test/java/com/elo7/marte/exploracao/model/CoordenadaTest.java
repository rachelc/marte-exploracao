package com.elo7.marte.exploracao.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.elo7.marte.exploracao.model.Coordenada;

public class CoordenadaTest {

   Coordenada coordenada;
	
	@Before
	public void setUp() throws Exception {
		this.coordenada = new Coordenada(1, 1);
	}

	@Test
	public void testAddX() {
		
		coordenada.addX(2);
		assertEquals(new Integer(3), coordenada.getX());
		
		coordenada.addX(-2);
		assertEquals(new Integer(1), coordenada.getX());
		
	}

	@Test
	public void testAddY() {
		
		coordenada.addY(2);
		assertEquals(new Integer(3), coordenada.getY());
		
		coordenada.addY(-2);
		assertEquals(new Integer(1), coordenada.getY());
		
	}
	
}
