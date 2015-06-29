package com.elo7.marte.exploracao.model;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.elo7.marte.exploracao.configuracao.MarteExploracaoSpringTestConfiguration;
import com.elo7.marte.exploracao.model.Nasa;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MarteExploracaoSpringTestConfiguration.class)
public class NasaTest {
	
	@Autowired
	private Nasa nasa;
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();	

	 @Test
	 public void testEnviaDuasSondas() {
		 
		String instrucoes =   "5 5 N\n"+
				              "1 2 N\n"+
					  		  "LMLMLMLMM\n"+
					  		  "3 3 E\n"+
					  		  "MMRMMRMRRM\n";

		nasa.carregaSondas(instrucoes);
		nasa.enviarSondas();
		
		
		 String retornoEsperado = "1 3 N\n"+
   			  					  "5 1 E\n";

		 assertEquals(retornoEsperado, nasa.relatorioSondas());
	 }
	 
}
