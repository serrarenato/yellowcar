package br.com.yellowcar.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yellowcar.domain.Position2D;
import br.com.yellowcar.domain.exception.PassengerInvalidStateException;
import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.Passenger;
import br.com.yellowcar.domain.mobile.World;
import br.com.yellowcar.usecase.cab.CreateListRandomCabs;
import br.com.yellowcar.usecase.passenger.CreateRandomPassenger;
import br.com.yellowcar.usecase.passenger.PutRandomPositionPassenger;

@Service
public class CreateSimulation {

	@Autowired
	private CreateListRandomCabs createListRandomCabs;

	@Autowired
	private CreatePassengerSimulation createPassengerSimulation;

	public void execute() {

		Position2D position2D = new Position2D(World.SIZE_X-50, World.SIZE_Y-50);
		createListRandomCabs.execute(position2D);

		createPassengerSimulation.execute();	
			
		//Cab cab = insertPassengerInBestCab.execute(passenger);

	}
}
