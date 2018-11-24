package br.com.yellowcar.usecase.cab;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import br.com.yellowcar.domain.Position2D;
import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.Passenger;

@Service
public final class FindCabsAvaliable {
	
	public void execute(Passenger passenger) {
		//busca o carro e retorna a melhor opção
		// primeiro busca pelos que estao disponiveis depois pelo mais proximo fazer um chain
	}
}
