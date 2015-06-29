package com.elo7.marte.exploracao.configuracao;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Spring Configuration
 */
@Configuration
@ImportResource(value = { "classpath:marte-exploracao-context.xml" })
public class MarteExploracaoSpringTestConfiguration {

}
