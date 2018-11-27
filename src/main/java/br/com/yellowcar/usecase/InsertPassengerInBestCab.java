package br.com.yellowcar.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.Passenger;

/**
 * Put the {@Link passenger} in best {@link cab} found.
 * 
 * @author renato
 */
@Service
public class InsertPassengerInBestCab {
	@Autowired
	PickBestCabToPassenger pickBestCabToPassenger;

	public Cab execute(Passenger passenger) {
		Cab cab = pickBestCabToPassenger.execute(passenger);
		cab.setPassenger(passenger);
		cab.next();
		return cab;
	}
}
