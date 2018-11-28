package br.com.yellowcar.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.yellowcar.domain.Position2D;
import br.com.yellowcar.domain.exception.PassengerInvalidStateException;
import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.Passenger;
import br.com.yellowcar.domain.mobile.PassengersWorld;
import br.com.yellowcar.domain.mobile.World;
import br.com.yellowcar.usecase.cab.CreateListRandomCabs;
import br.com.yellowcar.usecase.passenger.CreateRandomPassenger;
import br.com.yellowcar.usecase.passenger.PutRandomPositionPassenger;

/**
 * Create a new Passenger Always one Passenger arrive to destination
 * 
 * @author renato
 *
 */
@Service
public class CreatePassengerSimulation {

	@Autowired
	private CreateRandomPassenger createRandomPassenger;

	private static final int INTERVAL_BETWEEN_PASSENGER_ADD = 1000;

	@Async("passengersExecutor")
	public void execute() {
		Position2D position2D = new Position2D(World.SIZE_X+50, World.SIZE_Y+50);
		Passenger passenger = null;
		do {
			if ((passenger == null) || (passenger.getState() == Passenger.State.ARRIVE_DESTINATION)) {
				try {				
					Thread.sleep(INTERVAL_BETWEEN_PASSENGER_ADD);
					if (passenger!=null)
						PassengersWorld.removePassenger(passenger);
					//PassengersWorld.getPassengersInWorld()
					passenger = createRandomPassenger.execute(position2D);	
					
				} catch (InterruptedException e) {
					System.out.println("Problemas ao inserir outro passeiro na Simulação" + e.getMessage());
				}
			}
		} while (true);

	}
}
