package br.com.yellowcar.domain.mobile;

import java.util.Observer;

import br.com.yellowcar.domain.Position2D;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class Cab extends Mobile implements Movable {

	private static final int LAST_POSITIONS_MAX_SIZE = 30;
	private int velocity = 500; // 500 ms interval of time in each move.

	private Passenger passenger;

	public Cab(String id, Position2D position, Observer observer) {
		super(id, observer);
		this.setInitialPosition(position);
	}

	public Cab(String id, Position2D position, Observer observer, Integer velocity) {
		super(id, observer);
		this.setInitialPosition(position);
		this.velocity = velocity;
	}

	State state = State.EMPTY;

	/**
	 * Next state of FSM
	 * 
	 * @param arg
	 */
	public void next() {
		state = state.nextState();
		setChanged();
        notifyObservers();
	}

	public static enum State {

		/**
		 * O {@link Cab} está vazio. Estado inicial da máquina de estado.
		 */
		EMPTY {
			@Override
			State nextState() {
				return ACCEPT_PASSENGER;
			}
		},

		/**
		 * O {@link Cab} está vazio. Estado inicial da máquina de estado.
		 */
		ACCEPT_PASSENGER {
			@Override
			State nextState() {
				return ON_THE_WAY;
			}
		},

		/**
		 * O {@link Cab} está a caminho de um {@link Passenger}
		 */
		ON_THE_WAY {
			@Override
			State nextState() {
				return GET_PASSENGER;
			}
		},
		/**
		 * O {@link Cab} está a pegando um {@link Passenger} em sua posição inicial
		 */
		GET_PASSENGER{
			@Override
			State nextState() {
				return BUSY;
			}
		},

		/**
		 * O {@link Cab} está ocupado transportando o {@link Passenger} a seu destino
		 */
		BUSY {
			@Override
			State nextState() {
				return EMPTY;
			}
		};

		abstract State nextState();
	}

	@Override
	public void setPosition(Position2D position) {

		if (this.getPositions().size() == LAST_POSITIONS_MAX_SIZE) {
			// Remove a Position mais antiga
			this.getPositions().remove(0);
		}
		this.setPositions(position);
	}

	@Override
	public void move(Position2D destinationPosition) {
		while (!this.getLastPosition().equals(destinationPosition)) {

			Position2D currentPosition = this.getLastPosition();
			currentPosition = new Position2D(Movable.increment(currentPosition.getX(), destinationPosition.getX()),
					Movable.increment(currentPosition.getY(), destinationPosition.getY()));
			setPositions(currentPosition);
			try {
				Thread.sleep(velocity);
			} catch (InterruptedException e) {
				System.out.println("Exceção na Thread do movimento do Carro");
			}
		}
	}

}
