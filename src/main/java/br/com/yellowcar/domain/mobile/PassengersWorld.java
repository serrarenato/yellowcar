package br.com.yellowcar.domain.mobile;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public final class PassengersWorld {
	private static Set<Passenger> passengerInWorld;
	private static final PassengersWorld INSTANCE = new PassengersWorld();;

	private PassengersWorld() {
		passengerInWorld = new HashSet<>();
	}

	public static PassengersWorld getInstance() {
		return INSTANCE;

	}

	public static synchronized Set<Passenger> getPassengersInWorld() {
		return passengerInWorld;
	}
	public static synchronized void setPassengerInWorld(Passenger passenger) {
		synchronized (passengerInWorld) {
			passengerInWorld.add(passenger);
		}
	}
	public static void removePassenger(Passenger passenger) {
		synchronized (passengerInWorld) {
			 if (!passengerInWorld.remove(passenger))
				 System.out.println("Impossível remover este Passageiro!");	
		}
	
	}
}
