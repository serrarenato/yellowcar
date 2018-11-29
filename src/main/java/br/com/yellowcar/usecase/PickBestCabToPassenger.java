package br.com.yellowcar.usecase;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.yellowcar.domain.exception.RestrictionException;
import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.CabsWorld;
import br.com.yellowcar.domain.mobile.Passenger;
import br.com.yellowcar.domain.restriction.RestrictionChain;
import br.com.yellowcar.domain.restriction.StateCabRestriction;
import br.com.yellowcar.usecase.selector.Selector;

/**
 * Pick the best cab in the world to the actual passenger Get the Selector
 * choice and the Restrictions
 * 
 * @author renato
 *
 */
@Service
public class PickBestCabToPassenger {
	Selector selector;
	RestrictionChain restrictionChain;

	public PickBestCabToPassenger(Selector.Type type, RestrictionChain restrictionChain) {
		this.selector = Selector.instaceOf(type);
		this.restrictionChain = restrictionChain;
	}

	public Cab execute(Passenger passenger) {
		Set<Cab> restrictCabs = new HashSet<>();
		for (Cab cab : CabsWorld.getCabsInWorld())
			if (restrictionChain.isPossible(cab, passenger))
				restrictCabs.add(cab);
		Optional<Cab> cab = selector.findTheBest(restrictCabs, passenger);
		// If didn't found any cabs, pick any one free.
		if (!cab.isPresent()) {
			for (Cab cabRenew : CabsWorld.getCabsInWorld()) {
				StateCabRestriction stateCabRestriction = new StateCabRestriction();
				try {
					stateCabRestriction.isPossible(cabRenew, passenger);
					cab = Optional.of(cabRenew);
				} catch (RestrictionException e) {
					// Do nothing
				}
			}
		}

		return cab.get();
	}
}
