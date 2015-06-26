package com.elo7.marte.exploracao;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NasaTest {

	 @Test
	 public void testEnviaDuasSondas() {
		 
		 String retornoEsperado = "1 3 N\n"+
				    			  "5 1 E";
		 
		Nasa nasa = new Nasa();
			
		Planalto planalto = new Planalto(5, 5);
			
		String instructions = "5 5\n"+
					  "1 2 N\n"+
					  "LMLMLMLMM\n"+
					  "3 3 E\n"+
					  "MMRMMRMRRM\n";
		 
	 	 assertEquals(retornoEsperado, nasa.enviaSondas(planalto, instructions));
	 }
	 
}
