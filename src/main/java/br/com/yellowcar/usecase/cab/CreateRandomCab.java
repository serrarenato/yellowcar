package br.com.yellowcar.usecase.cab;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yellowcar.domain.Position2D;
import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.CabsWorld;
import br.com.yellowcar.usecase.observer.ObserverMobile;

@Service
public final class CreateRandomCab {
	
	@Autowired
	ObserverMobile observer;
	
	public Cab execute(Integer sizeX, Integer sizeY) {
		String generatedString = RandomStringUtils.randomAlphabetic(3).toUpperCase()
				+ RandomStringUtils.randomNumeric(4);
		Double x = Math.random() * sizeX;
		Double y = Math.random() * sizeY;
		Position2D position = new Position2D(x.intValue(), y.intValue());
		Cab cab=new Cab(generatedString, position, observer);
		CabsWorld.setCabInWorld(cab);
		return cab;
	}
}
