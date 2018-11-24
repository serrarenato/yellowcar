package br.com.yellowcar.usecase.observer;

import java.util.Observable;
import java.util.Observer;

import org.springframework.stereotype.Service;

import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.Mobile;
import br.com.yellowcar.domain.mobile.Passenger;

@Service
public class ObserverMobile implements Observer {
	
	@Override
	public void update(Observable mobile, Object arg) {
		if (mobile instanceof Mobile) {
			if (mobile instanceof Passenger) {
				Passenger passenger = (Passenger) mobile;
			}
			if (mobile instanceof Cab) {
				Cab cab = (Cab) mobile;
				System.out.println("Objeto cab foi alterado: " + cab.getPositions().get(cab.getPositions().size()-1) + " - " + cab.getState());
			}
		}
	}

}
