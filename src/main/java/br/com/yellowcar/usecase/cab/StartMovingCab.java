package br.com.yellowcar.usecase.cab;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.yellowcar.domain.Position2D;
import br.com.yellowcar.domain.mobile.Cab;

/**
 * Class used to move the cab until some position and change the states.
 * 
 * @author renato
 *
 */
@Service
public class StartMovingCab {
	@Async("cabsExecutor")
	public void execute(Cab cab, Position2D destinationPosition) {
		cab.next();
		cab.move(destinationPosition);
		cab.next();
		if (cab.getPassenger()!=null)
			cab.getPassenger().next();
	}



}
