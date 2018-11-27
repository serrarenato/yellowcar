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
	private PutRandomPositionPassenger putRandomPositionPassenger;
	@Autowired
	private CreateRandomPassenger createRandomPassenger;

	@Autowired
	private InsertPassengerInBestCab insertPassengerInBestCab;

	public void execute() {
		Position2D position2D = new Position2D(World.SIZE_X, World.SIZE_Y);
		createListRandomCabs.execute(World.SIZE_X, World.SIZE_Y);
		Passenger passenger = createRandomPassenger.execute(position2D);
		try {
			passenger = putRandomPositionPassenger.execute(passenger, position2D);
		} catch (PassengerInvalidStateException e) {	
			e.printStackTrace();
		}
		Cab cab = insertPassengerInBestCab.execute(passenger);

	}
}
