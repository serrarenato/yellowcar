package br.com.yellowcar.domain.mobile;

import java.util.HashSet;
import java.util.Set;


public final class CabsWorld {
	private static Set<Cab> cabsInWorld;
	private static final CabsWorld INSTANCE = new CabsWorld();;

	private CabsWorld() {
		cabsInWorld = new HashSet<>();
	}

	public static CabsWorld getInstance() {
		return INSTANCE;

	}

	public static synchronized Set<Cab> getCabsInWorld() {
		return cabsInWorld;
	}
	public static synchronized void setCabInWorld(Cab cab) {
		cabsInWorld.add(cab);
	}
}
