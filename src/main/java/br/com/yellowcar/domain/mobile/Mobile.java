package br.com.yellowcar.domain.mobile;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import br.com.yellowcar.domain.Position2D;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public abstract class Mobile extends Observable{

	private List<Position2D> positions;
	private Position2D initialPosition;
	private Position2D destination;
	
	private final String id;

	protected Mobile(String id, Observer observer ) {
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
	}
	
	public void setPositions(Position2D position) {
		this.positions.add(position);
		setChanged();
        notifyObservers();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mobile other = (Mobile) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	
}
