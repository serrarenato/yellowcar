package br.com.yellowcar.usecase.selector;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.CabsWorld;
import br.com.yellowcar.domain.mobile.Passenger;
import br.com.yellowcar.usecase.CalculateDistance;

/**
 * This Selector used to get the {@link Cab} with the minor distance until the e
 * {@link Passenger} Here after must be some blocks and diferents routes to the
 * passenger.
 * 
 * @author renato
 *
 */
public class FindMinorDistance implements Selector {

	@Autowired
	CalculateDistance calculateDistance;

	@Override
	public Optional<Cab> findTheBest(Set<Cab> cabs, Passenger passenger) {
		Optional<Cab> bestChoice = Optional.empty();
		double bestDistance = Double.MAX_VALUE;
		for (Cab cab : cabs) {
			double currentDistance = calculateDistance.execute(cab.getLastPosition(), passenger.getInitialPosition());
			if (currentDistance < bestDistance) {
				bestDistance = currentDistance;
				bestChoice = Optional.of(cab);
			}
		}
		return bestChoice;
	}

}
