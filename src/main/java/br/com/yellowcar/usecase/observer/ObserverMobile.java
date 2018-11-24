package br.com.yellowcar.usecase.observer;

import java.util.Observable;
import java.util.Observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.Mobile;
import br.com.yellowcar.domain.mobile.Passenger;
import br.com.yellowcar.usecase.cab.FindCabsAvaliable;

@Service
public class ObserverMobile implements Observer {
	
	@Autowired
	FindCabsAvaliable findCabsAvaliable;
	
	@Override
	public void update(Observable mobile, Object arg) {
		if (mobile instanceof Mobile) {
			if (mobile instanceof Passenger) {
				Passenger passenger = (Passenger) mobile;
				System.out.println("Objeto passenger foi alterado: " + passenger.getPositions().get(passenger.getPositions().size()-1) + " - " + passenger.getState());
				switch (passenger.getState()) {
				case NO_CAB:
					findCabsAvaliable.execute(passenger);
					break;
				}
			}
			if (mobile instanceof Cab) {
				Cab cab = (Cab) mobile;
				System.out.println("Objeto cab foi alterado: " + cab.getPositions().get(cab.getPositions().size()-1) + " - " + cab.getState());
			}
		}
	}

}
