package br.com.yellowcar.domain.restriction;

import br.com.yellowcar.domain.exception.RestrictionException;
import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.Passenger;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Restriction {
	private Restriction next;
	public abstract void isPossible(Cab cab, Passenger passenger) throws RestrictionException;
}
