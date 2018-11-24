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
}
