package com.elo7.marte.exploracao.leitura;

import java.util.List;

import com.elo7.marte.exploracao.model.Sonda;

public interface LeitorDadosSonda {
	
	public List<Sonda> getSondas(String instrucoes);

}
