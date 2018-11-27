package br.com.yellowcar;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import br.com.yellowcar.usecase.CreateSimulation;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableAsync
public class YellowCarApplication {

	public static void main(String[] args) {
		// SpringApplication.run(YellowCarApplication.class, args);
		ConfigurableApplicationContext context = new SpringApplicationBuilder(YellowCarApplication.class)
				.headless(false).run(args);
		CreateSimulation createSimulation = (CreateSimulation) context.getBean(CreateSimulation.class);
		createSimulation.execute();
	}
}
