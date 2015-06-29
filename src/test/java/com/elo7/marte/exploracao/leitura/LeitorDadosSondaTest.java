package com.elo7.marte.exploracao.leitura;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.elo7.marte.exploracao.configuracao.MarteExploracaoSpringTestConfiguration;
import com.elo7.marte.exploracao.leitura.LeitorDadosSonda;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MarteExploracaoSpringTestConfiguration.class)
public class LeitorDadosSondaTest {
	
	@Autowired
	private LeitorDadosSonda leitor;
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();	

	
	 @Test
	 public void testIntrucoesNull() {

		 expectedEx.expect(IllegalArgumentException.class);
		 expectedEx.expectMessage("instru��es inv�lidas, linhas insuficientes");
		 
		 leitor.getSondas(null);

	 }
	 


	 @Test
	 public void testSemIntrucoes() {
		 
		 expectedEx.expect(IllegalArgumentException.class);
		 expectedEx.expectMessage("instru��es inv�lidas, linhas insuficientes");
		 
		 leitor.getSondas("");	 	
	 }

	 @Test
	 public void testIntrucoesInsuficientes() {
		 
		 expectedEx.expect(IllegalArgumentException.class);
		 expectedEx.expectMessage("instru��es inv�lidas, linhas insuficientes");

		 String instrucoes = "1 1\n"+
				 			 "1 1 N\n";
		 
		 leitor.getSondas(instrucoes);	 	
	 }
	 
	 @Test()
	 public void testPlanaltoInvalido() {

		 // Envia Letras
		 String instrucoes = "d e\n"+
	              			 "1 1 N\n"+
	              			 "MRMLM";
		 expectedEx.expect(IllegalArgumentException.class);
		 expectedEx.expectMessage("planalto coordenadas inv�lidas: d e");		 
		 leitor.getSondas(instrucoes);
		 
		 
		// Envia somente um n�mero
		 instrucoes = "1\n"+
		              "1 1 N\n"+
				      "MRMLM";
		 expectedEx.expect(IllegalArgumentException.class);
		 expectedEx.expectMessage("planalto coordenadas inv�lidas: 1");		 
		 leitor.getSondas(instrucoes);		 		 
	 }

	 
	 @Test()
	 public void testSondaCoordenadaInvalida() {

		 // Envia somente um n�mero e algumas informa��es da sonda
		 String instrucoes = "3 3\n"+
				 		     "1 1\n"+
				 		     "MRMLM";
		 expectedEx.expect(IllegalArgumentException.class);
		 expectedEx.expectMessage("sonda.0 coordenadas inv�lidas: 1 1");		 
		 leitor.getSondas(instrucoes);		 		 
	 }

	 @Test()
	 public void testSondaComandoInvalido() {

		 // Envia somente um n�mero e algumas informa��es da sonda
		 String instrucoes = "3 3\n"+
				 		     "1 1 N\n"+
				 		     "MRMXLM";
		 
		 expectedEx.expect(IllegalArgumentException.class);
		 expectedEx.expectMessage("sonda.0 a��o inv�lida: MRMXLM");
		 
		 leitor.getSondas(instrucoes);		 		 
	 }
	 
}
