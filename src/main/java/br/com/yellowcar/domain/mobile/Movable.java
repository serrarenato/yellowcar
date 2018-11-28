package br.com.yellowcar.domain.mobile;

import br.com.yellowcar.domain.Position2D;

public interface Movable {

	public static int increment(final int current, final int destination) {
		if (current == destination) {
			return current;
		}

		if (current > destination) {
			return current - 1;
		}

		return current + 1;
	}
	public void move(Position2D destinationPosition);

}
