package br.com.yellowcar.usecase.cab;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.yellowcar.YellowCarApplication;
import br.com.yellowcar.domain.mobile.Passenger;
import br.com.yellowcar.usecase.passenger.CreateRandomPassenger;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = YellowCarApplication.class)
public class CreateRandomPassengerTest {
	@Autowired
	private CreateRandomPassenger createRandomPassenger;

	@Test
	public void shouldReturnListPassengerWithSuccess() {
		Passenger passenger = createRandomPassenger.execute(500, 400);
		Passenger passenger2 = createRandomPassenger.execute(500, 400);
		System.out.println(passenger +" "+ passenger2);
		Assert.assertNotNull(passenger);
		Assert.assertFalse(passenger.equals(passenger2));	
	}
}
