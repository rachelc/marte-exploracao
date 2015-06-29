package com.elo7.marte.exploracao;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NasaTest {
	
	private Nasa nasa = new Nasa();
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();	

	 @Test
	 public void testEnviaDuasSondas() {
		 
		 String retornoEsperado = "1 3 N\n"+
				    			  "5 1 E\n";
		 
		String instrucoes =   "5 5 N\n"+
				              "1 2 N\n"+
					  		  "LMLMLMLMM\n"+
					  		  "3 3 E\n"+
					  		  "MMRMMRMRRM\n";
		 
	 	 assertEquals(retornoEsperado, nasa.enviarSondas(instrucoes));
	 }

	 @Test
	 public void testIntrucoesNull() {
		 
		 assertEquals("", nasa.enviarSondas(null));
	 }
	 
	 
	 @Test
	 public void testSemIntrucoes() {
		 
		 expectedEx.expect(IllegalArgumentException.class);
		 expectedEx.expectMessage("instruções inválidas, linhas insuficientes");
		 
		 nasa.enviarSondas("");	 	
	 }

	 @Test
	 public void testIntrucoesInsuficientes() {
		 
		 expectedEx.expect(IllegalArgumentException.class);
		 expectedEx.expectMessage("instruções inválidas, linhas insuficientes");

		 String instrucoes = "1 1\n"+
				 			 "1 1 N\n";
		 
		 nasa.enviarSondas(instrucoes);	 	
	 }
	 
	 @Test()
	 public void testPlanaltoInvalido() {

		 // Envia Letras
		 String instrucoes = "d e\n"+
	              			 "1 1 N\n"+
	              			 "MRMLM";
		 expectedEx.expect(IllegalArgumentException.class);
		 expectedEx.expectMessage("planalto coordenadas inválidas: d e");		 
		 nasa.enviarSondas(instrucoes);
		 
		 
		// Envia somente um número
		 instrucoes = "1\n"+
		              "1 1 N\n"+
				      "MRMLM";
		 expectedEx.expect(IllegalArgumentException.class);
		 expectedEx.expectMessage("planalto coordenadas inválidas: 1");		 
		 nasa.enviarSondas(instrucoes);		 		 
	 }

	 
	 @Test()
	 public void testSondaCoordenadaInvalida() {

		 // Envia somente um número e algumas informações da sonda
		 String instrucoes = "3 3\n"+
				 		     "1 1\n"+
				 		     "MRMLM";
		 expectedEx.expect(IllegalArgumentException.class);
		 expectedEx.expectMessage("sonda.0 coordenadas inválidas: 1 1");		 
		 nasa.enviarSondas(instrucoes);		 		 
	 }

	 @Test()
	 public void testSondaComandoInvalido() {

		 // Envia somente um número e algumas informações da sonda
		 String instrucoes = "3 3\n"+
				 		     "1 1 N\n"+
				 		     "MRMXLM";
		 
		 expectedEx.expect(IllegalArgumentException.class);
		 expectedEx.expectMessage("sonda.0 ação inválida: MRMXLM");
		 
		 nasa.enviarSondas(instrucoes);		 		 
	 }
	 
}
