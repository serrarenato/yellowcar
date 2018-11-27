package br.com.yellowcar.usecase;

import org.springframework.stereotype.Service;

import br.com.yellowcar.domain.Position2D;

/**
 * Calcute the distance between two points.
 * 
 * @author renato
 *
 */
@Service
public class CalculateDistance {
	public static Double execute(Position2D position1, Position2D position2) {
		Double result = Math.sqrt(
				Math.pow(position1.getX() - position2.getX(), 2) + Math.pow(position2.getY() - position2.getY(), 2));
		return result;
	}
}
