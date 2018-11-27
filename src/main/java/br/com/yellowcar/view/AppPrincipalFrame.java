package br.com.yellowcar.view;

import java.awt.Graphics;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;

import br.com.yellowcar.domain.mobile.World;



@Component
public class AppPrincipalFrame extends JFrame {

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
	public void paint(Graphics g) {
		super.paint(g);

		// define the position
		int locX = 200;
		int locY = 200;

		// draw a line (there is no drawPoint..)
		g.drawLine(0, 0, locX, locY);
	}
}
