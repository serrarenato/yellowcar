package br.com.yellowcar.usecase.selector;

import java.util.Optional;
import java.util.Set;

import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.Passenger;



/**
 * Interface utiliza algum critério para determinar qual
 * é o melhor par de {@link Cab} e {@link Passenger} a ser efetivado.
 * 
 */
public interface Selector {
	Optional<Cab> findTheBest(Set<Cab> cabs, Passenger passenger);
	public static <E extends Selector> Selector instaceOf(Selector.Type type){
		switch(type){
			case MinorDistance:
				return new FindMinorDistance();				
			default:
				return null;
		}		
	}
	public enum Type{
		MinorDistance,
		BestCabs;
	}
}
