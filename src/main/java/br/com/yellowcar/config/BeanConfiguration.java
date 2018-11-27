package br.com.yellowcar.config;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import br.com.yellowcar.domain.restriction.RestrictionChain;
import br.com.yellowcar.usecase.PickBestCabToPassenger;
import br.com.yellowcar.usecase.selector.Selector;

@Configuration
public class BeanConfiguration {

	@Bean
	public PickBestCabToPassenger pickBestCabToPassenger(@Value("${cab.selector}") Selector.Type type,
			@Value("${cab.restriction}") RestrictionChain restrictionChain) {
		return new PickBestCabToPassenger(type, restrictionChain);
	}

	@Bean(name = "cabsExecutor")
	public Executor asyncExecutorCabs() {
		final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(1);
		executor.setMaxPoolSize(10); // Max threads to cabs
		executor.initialize();
		return executor;
	}

	@Bean(name = "passengersExecutor")
	public Executor asyncExecutorPassengers() {
		final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(1);
		executor.setMaxPoolSize(10); // Max threads to passengers
		executor.initialize();
		return executor;
	}

}
