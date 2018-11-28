package br.com.yellowcar.usecase.cab;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yellowcar.domain.Position2D;
import br.com.yellowcar.domain.mobile.Cab;

@Service
public class CreateListRandomCabs {

	@Autowired
	CreateRandomCab createRandomCab;

	public static final Integer NumberOfCabs = 5;

	public Set<Cab> execute(Position2D position2D) {
		Set<Cab> cabs = new HashSet<>();
		for (int x = 0; x < NumberOfCabs; x++)
			cabs.add(createRandomCab.execute(position2D));
		return cabs;
	}
}
