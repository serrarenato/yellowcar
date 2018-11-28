package br.com.yellowcar.usecase.observer;

import java.util.Observable;
import java.util.Observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yellowcar.domain.exception.PassengerInvalidStateException;
import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.Mobile;
import br.com.yellowcar.domain.mobile.Passenger;
import br.com.yellowcar.domain.mobile.PassengersWorld;
import br.com.yellowcar.usecase.InsertPassengerInBestCab;
import br.com.yellowcar.usecase.cab.StartMovingCab;
import br.com.yellowcar.usecase.passenger.PutRandomPositionPassenger;
import br.com.yellowcar.view.RefreshScreen;

@Service
public class ObserverMobile implements Observer {

	@Autowired
	private InsertPassengerInBestCab insertPassengerInBestCab;

	@Autowired
	RefreshScreen refreshScreen;

	@Autowired
	StartMovingCab startMovingCab;

	@Autowired
	PutRandomPositionPassenger putRandomPositionPassenger;

	@Override
	public void update(Observable mobile, Object arg) {
		if (mobile instanceof Mobile) {
			if (mobile instanceof Passenger) {
				refreshScreen.refreshScreen();
				Passenger passenger = (Passenger) mobile;
				if (passenger.getState() != null) {
			//		System.out.println("Objeto passenger foi alterado: "
			//				+ passenger.getPositions().get(passenger.getPositions().size() - 1) + " - "
			//				+ passenger.getState());
					switch (passenger.getState()) {
					
					case INITIAL:
						//PassengersWorld.getPassengersInWorld()
						try {
							putRandomPositionPassenger.execute(passenger);
						} catch (PassengerInvalidStateException e) {
							e.printStackTrace();
						}
						break;
					case NO_CAB:
						insertPassengerInBestCab.execute(passenger);
						break;
					default:
						System.out.println("Metodo invalido");
						break;
					}
				}
			}
			if (mobile instanceof Cab) {
				refreshScreen.refreshScreen();
				Cab cab = (Cab) mobile;
				if (cab.getPositions().size() != 0) {
					System.out.println("Objeto cab foi alterado: "
							+ cab.getPositions().get(cab.getPositions().size() - 1) + " - " + cab.getState());
					switch (cab.getState()) {
					case EMPTY:
						break;
					case ACCEPT_PASSENGER:
						startMovingCab.execute(cab, cab.getPassenger().getInitialPosition());
						break;
					case ON_THE_WAY:						
						break;
					case GET_PASSENGER:
						startMovingCab.execute(cab, cab.getPassenger().getDestination());
						break;
					case BUSY:
						cab.getPassenger().setPosition(cab.getLastPosition());
						if (cab.getLastPosition().equals(cab.getPassenger().getDestination())) {
							cab.getPassenger().next();
							cab.next();
						}
						break;
					default:
						System.out.println("Metodo invalido");
						break;
					}
				}
			}
			refreshScreen.refreshScreen();
		}
	}

}
