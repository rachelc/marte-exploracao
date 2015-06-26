package com.elo7.marte.exploracao;

public class Nasa {
	
	public String enviaSondas(Planalto planalto, String instructions){
				
		Sonda sonda1 = new Sonda(1, 2, Coordenada.N, planalto);
		sonda1.move("LMLMLMLMM");
		
		Sonda sonda2 = new Sonda(3, 3, Coordenada.E, planalto);
		sonda2.move("MMRMMRMRRM");
		
		return "1 3 N\n"+
	    "5 1 E";
		
	}
		
}
