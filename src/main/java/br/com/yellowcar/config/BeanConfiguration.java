package br.com.yellowcar.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.yellowcar.domain.restriction.RestrictionChain;
import br.com.yellowcar.usecase.PickBestCabToPassenger;
import br.com.yellowcar.usecase.selector.Selector;

@Configuration
public class BeanConfiguration {

	@Bean
	public PickBestCabToPassenger pickBestCabToPassenger(@Value("${cab.selector}") Selector.Type type, @Value("${cab.restriction}") RestrictionChain restrictionChain ) {
		return new PickBestCabToPassenger(type, restrictionChain);
	}

}
