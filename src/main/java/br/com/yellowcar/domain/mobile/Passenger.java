package br.com.yellowcar.domain.mobile;

import java.util.Observer;

import br.com.yellowcar.domain.Position2D;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public final class Passenger extends Mobile {
	State state = State.INITIAL;

	public Passenger(String id, Observer observer) {
		super(id, observer);

	}
	/**
	 * Next state of FSM
	 * @param arg
	 */
	public void next() {
		state = state.nextState();
	}

	public static enum State {
		/**
		 * Este {@link Passenger} ainda não inseriu suas coordenadas no sistema
		 * 
		 */
		INITIAL {
			@Override
			State nextState() {
				return NO_CAB;
			}
		},
		/**
		 * Nenhum {@link Cab} está a caminho deste {@link Passenger}. Estado inicial da
		 * máquina de estado.
		 */
		NO_CAB {
			@Override
			State nextState() {
				return State.WAITING_CAB;
			}
		},

		/**
		 * Um {@link Cab} já está a caminho deste {@link Passenger}.
		 */
		WAITING_CAB {
			@Override
			State nextState() {
				return State.IN_CAB;
			}
		},

		/**
		 * Este {@link Passenger} está dentro de um {@link Cab} a caminho de seu
		 * destino.
		 */
		IN_CAB {
			@Override
			State nextState() {
				return State.ARRIVE_DESTINATION;
			}
		},

		/**
		 * Este {@link Passenger} chegou a seu destino. Estado final da máquina de
		 * estado.
		 */
		ARRIVE_DESTINATION {
			@Override
			State nextState() {
				return INITIAL;
			}
		};

		abstract State nextState();
	}

	@Override
	public void setPosition(Position2D position) {
		this.setPositions(position);
	}

}
