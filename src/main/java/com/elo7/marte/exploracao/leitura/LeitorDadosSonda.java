package com.elo7.marte.exploracao.leitura;

import java.util.Map;

import com.elo7.marte.exploracao.model.Sonda;

public interface LeitorDadosSonda {
	
	public Map<Integer, Sonda> getSondas(String instrucoes);

}
