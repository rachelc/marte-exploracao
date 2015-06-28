package com.elo7.marte.exploracao;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NasaTest {

	 @Test
	 public void testEnviaDuasSondas() {
		 
		 String retornoEsperado = "1 3 N\n"+
				    			  "5 1 E\n";
		 
		Nasa nasa = new Nasa();
			
		
			
		String instrucoes =   "5 5 N\n"+
				              "1 2 N\n"+
					  		  "LMLMLMLMM\n"+
					  		  "3 3 E\n"+
					  		  "MMRMMRMRRM\n";
		 
	 	 assertEquals(retornoEsperado, nasa.enviarSondas(instrucoes));
	 }
	 
}
