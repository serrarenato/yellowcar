package br.com.yellowcar.domain.mobile;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import br.com.yellowcar.domain.Position2D;
import lombok.Data;
@Data
public abstract class Mobile extends Observable {

	private List<Position2D> positions;
	private Position2D initialPosition;
	private Position2D destination;
	
	private final String id;

	public Mobile(String id, Observer observer ) {
		this.addObserver(observer);
		this.id = id;
		positions= new ArrayList<Position2D>();
	}	
	public abstract void setPosition(final Position2D position);
	
	public Position2D getLastPosition() {
		return positions.get(positions.size()-1);
	}

	public void setInitialPosition(Position2D initialPosition) {
		this.initialPosition = initialPosition;
		this.positions.add(initialPosition);
		setChanged();
        notifyObservers();
	}

	public void setDestination(Position2D destination) {
		this.destination = destination;
		setChanged();
        notifyObservers();
	}
	
	public void setPositions(Position2D position) {
		this.positions.add(position);
		setChanged();
        notifyObservers();
	}
	private int increment(final int current, final int destination) {
		if (current == destination) {
			return current;
		}

		if (current > destination) {
			return current - 1;
		}

		return current + 1;
	}
	public void move(Position2D destinationPosition) {
		if (this.getLastPosition().equals(destinationPosition)) {
			System.out.println("Cab is on the Destiny - Error");
			return;
		}

		Position2D currentPosition = this.getLastPosition();

		currentPosition = new Position2D(increment(currentPosition.getX(), destinationPosition.getX()),
				increment(currentPosition.getY(), destinationPosition.getY()));
		setPositions(currentPosition);
	}

	
}
