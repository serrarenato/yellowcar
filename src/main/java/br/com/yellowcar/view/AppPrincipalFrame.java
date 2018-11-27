package br.com.yellowcar.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;

import br.com.yellowcar.domain.Position2D;
import br.com.yellowcar.domain.mobile.Cab;
import br.com.yellowcar.domain.mobile.CabsWorld;
import br.com.yellowcar.domain.mobile.Passenger;
import br.com.yellowcar.domain.mobile.PassengersWorld;
import br.com.yellowcar.domain.mobile.World;



@Component
public class AppPrincipalFrame extends JFrame implements RefreshScreen{

	private static final long serialVersionUID = -5680964038598774462L;

	private static final int MAX_X = World.SIZE_X;
	private static final int MAX_Y = World.SIZE_Y;

	private static final int NUMBER_OF_CABS = 10;
	private static final int INTERVAL_BETWEEN_PASSENGER_ADD = 1000;
	private static final int NUMBER_OF_BLOCKED_HORIZONTAL_LINES = 3;
	private static final int NUMBER_OF_BLOCKED_VERTICAL_LINES = 3;
	private static final int MAX_BLOCKED_SIZE_LINE = 500;

	public AppPrincipalFrame() {
		super("Simulator");
		setSize(MAX_X + 50, MAX_Y + 50);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initUI();
	}

	private void initUI() {
		setTitle("Simulator");
		setSize(MAX_X, MAX_Y);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
	}

	@Override
	public synchronized  void paint(Graphics g) {
		final Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setColor(Color.WHITE);
		super.paint(g);

		// define the position
		int locX = 200;
		int locY = 200;

		// draw a line (there is no drawPoint..)
///		g.drawLine(0, 0, locX, locY);
		
		if (CabsWorld.getCabsInWorld().size() != 0) {
			for (final Cab cab : CabsWorld.getCabsInWorld()) {
				switch (cab.getState()) {
				case EMPTY:
					graphics2d.setColor(Color.GRAY);
					break;
				case ON_THE_WAY:
					graphics2d.setColor(Color.DARK_GRAY);
					break;
				case BUSY:
					graphics2d.setColor(Color.BLACK);
				}
				final Position2D p = (Position2D) cab.getLastPosition();
				graphics2d.drawString(cab.getId(), p.getX(), p.getY());
			}
		}
		if (PassengersWorld.getPassengersInWorld().size() != 0) {
			for (final Passenger passenger : PassengersWorld.getPassengersInWorld()) {
				switch (passenger.getState()) {
				case NO_CAB:
					graphics2d.setColor(Color.RED);
					break;
				case WAITING_CAB:
					graphics2d.setColor(Color.BLUE);
					break;
				case IN_CAB:
					graphics2d.setColor(Color.ORANGE);
				}
				final Position2D p = (Position2D) passenger.getLastPosition();
				graphics2d.drawString(passenger.getId(), p.getX(), p.getY());
			}
		}

	}
	@Override
	public synchronized void refreshScreen() {
		repaint();
	}
	
}
