package br.com.yellowcar.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.yellowcar.domain.mobile.Passenger;
import br.com.yellowcar.domain.mobile.PassengersWorld;
import br.com.yellowcar.usecase.passenger.CreateRandomPassenger;

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
	private static final int MAX_PASSENGER = 1;

	@Async("passengersExecutor")
	public void execute() {

		do {
			if (PassengersWorld.getPassengersInWorld().size() < MAX_PASSENGER)
				createRandomPassenger.execute();
			for (Passenger passenger : PassengersWorld.getPassengersInWorld())
				if ((passenger == null) || (passenger.getState() == Passenger.State.ARRIVE_DESTINATION)) {
					try {
						Thread.sleep(INTERVAL_BETWEEN_PASSENGER_ADD);
						if (passenger != null)
							PassengersWorld.removePassenger(passenger);
						// PassengersWorld.getPassengersInWorld()

					} catch (InterruptedException e) {
						System.out.println("Problemas ao inserir outro passeiro na Simulação" + e.getMessage());
						throw new RuntimeException("Problemas ao inserir outro passeiro na Simulação");
					}
				}
		} while (true);

	}
}
