package br.com.yellowcar.usecase.cab;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.yellowcar.YellowCarApplication;
import br.com.yellowcar.domain.Position2D;
import br.com.yellowcar.domain.exception.PassengerInvalidStateException;
import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.Passenger;
import br.com.yellowcar.domain.mobile.World;
import br.com.yellowcar.usecase.PickBestCabToPassenger;
import br.com.yellowcar.usecase.passenger.CreateRandomPassenger;
import br.com.yellowcar.usecase.passenger.PutRandomPositionPassenger;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = YellowCarApplication.class)
public class PickTheBestCabToPassengerTest {
	@Autowired
	private CreateListRandomCabs createListRandomCabs;
	@Autowired
	private PickBestCabToPassenger pickBestCabToPassenger;
	@Autowired
	private PutRandomPositionPassenger putRandomPositionPassenger;
	@Autowired
	private CreateRandomPassenger createRandomPassenger;

	@Test
	public void shouldReturnOneCabsWithPassengerWithSuccess() throws PassengerInvalidStateException {
		Position2D position2D = new Position2D(World.SIZE_X, World.SIZE_Y);
		createListRandomCabs.execute(World.SIZE_X, World.SIZE_Y);
		Passenger passenger = createRandomPassenger.execute(position2D);
		passenger = putRandomPositionPassenger.execute(passenger, position2D);
		Cab cab = pickBestCabToPassenger.execute(passenger);
		System.out.println(cab);
		Assert.assertNotNull(cab.getPassenger());
	}
}
