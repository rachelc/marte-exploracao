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
		 expectedEx.expectMessage("instruções inválidas, linhas insuficientes");
		 
		 leitor.getSondas(null);

	 }
	 


	 @Test
	 public void testSemIntrucoes() {
		 
		 expectedEx.expect(IllegalArgumentException.class);
		 expectedEx.expectMessage("instruções inválidas, linhas insuficientes");
		 
		 leitor.getSondas("");	 	
	 }

	 @Test
	 public void testIntrucoesInsuficientes() {
		 
		 expectedEx.expect(IllegalArgumentException.class);
		 expectedEx.expectMessage("instruções inválidas, linhas insuficientes");

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
		 expectedEx.expectMessage("planalto coordenadas inválidas: d e");		 
		 leitor.getSondas(instrucoes);
		 
		 
		// Envia somente um número
		 instrucoes = "1\n"+
		              "1 1 N\n"+
				      "MRMLM";
		 expectedEx.expect(IllegalArgumentException.class);
		 expectedEx.expectMessage("planalto coordenadas inválidas: 1");		 
		 leitor.getSondas(instrucoes);		 		 
	 }

	 
	 @Test()
	 public void testSondaCoordenadaInvalida() {

		 // Envia somente um número e algumas informações da sonda
		 String instrucoes = "3 3\n"+
				 		     "1 1\n"+
				 		     "MRMLM";
		 expectedEx.expect(IllegalArgumentException.class);
		 expectedEx.expectMessage("sonda.0 coordenadas inválidas: 1 1");		 
		 leitor.getSondas(instrucoes);		 		 
	 }

	 @Test()
	 public void testSondaComandoInvalido() {

		 // Envia somente um número e algumas informações da sonda
		 String instrucoes = "3 3\n"+
				 		     "1 1 N\n"+
				 		     "MRMXLM";
		 
		 expectedEx.expect(IllegalArgumentException.class);
		 expectedEx.expectMessage("sonda.0 ação inválida: MRMXLM");
		 
		 leitor.getSondas(instrucoes);		 		 
	 }
	 
}
