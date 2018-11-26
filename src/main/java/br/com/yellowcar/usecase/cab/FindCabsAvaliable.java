package br.com.yellowcar.usecase.cab;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.CabsWorld;
import br.com.yellowcar.domain.mobile.Passenger;
import br.com.yellowcar.domain.restriction.RestrictionChain;

/**
 * Busca na lista de {@link Cab}, com as retrições estabalecidas quais são os
 * Cabs disponiveis para aquele {@link Passenger}
 * 
 * @author renato
 *
 */
@Service
public final class FindCabsAvaliable {

	public Set<Cab> execute(Passenger passenger) {
		Set<Cab> cabsAvaliable = new HashSet<>();
		for (Cab cab : CabsWorld.getCabsInWorld())
			if (RestrictionChain.STATECAB_MAXDISTANCE.isPossible(cab, passenger))
				cabsAvaliable.add(cab);
		return cabsAvaliable;
	}
}
