package br.com.yellowcar.usecase.cab;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.yellowcar.YellowCarApplication;
import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.World;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = YellowCarApplication.class)
public class CreateListRandomCabsTest {
	@Autowired
	private CreateListRandomCabs createListRandomCabs;

	@Test
	public void shouldReturnListCabsWithSuccess() {
		Set<Cab> cabs = createListRandomCabs.execute(World.SIZE_X,World.SIZE_Y);
		System.out.println(cabs);
		Assert.assertNotNull(cabs);
		Assert.assertEquals(cabs.size(), 5);		
	}
}
