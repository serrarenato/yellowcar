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
import br.com.yellowcar.domain.mobile.Passenger;
import br.com.yellowcar.usecase.passenger.CreateRandomPassenger;
import br.com.yellowcar.usecase.passenger.PutRandomPositionPassenger;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = YellowCarApplication.class)
public class RandomPassengerTest {
	@Autowired
	private CreateRandomPassenger createRandomPassenger;
	
	@Autowired
	private PutRandomPositionPassenger putRandomPositionPassenger;
	
	private final Position2D world = new Position2D(500,400);
	@Test
	public void shouldReturnListPassengerWithSuccess() {
		Passenger passenger = createRandomPassenger.execute(world);
		Passenger passenger2 = createRandomPassenger.execute(world);
		System.out.println(passenger +" "+ passenger2);
		Assert.assertNotNull(passenger);
		Assert.assertFalse(passenger.equals(passenger2));	
	}
	@Test
	public void shouldPutPositionInPassengerWithSuccess() throws PassengerInvalidStateException {
		Passenger passenger = createRandomPassenger.execute(world);
		passenger = putRandomPositionPassenger.execute(passenger, world);
		System.out.println(passenger);
		Assert.assertNotNull(passenger);
		Assert.assertTrue(passenger.getState()==Passenger.State.NO_CAB);	
	}
	
}
