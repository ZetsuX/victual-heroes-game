package vh.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

import vh.input.KeyboardInput;
import vh.input.MouseInput;

public class GameScreen extends JPanel{
	private GameMain game;
	private Dimension size;
	
	private MouseInput mouseListener;
	private KeyboardInput keyboardListener;
	
	public GameScreen(GameMain game) {
		this.game = game;

		setPanelSize();
	}
	
	public void initializeInput() {
		mouseListener = new MouseInput(game);
		keyboardListener = new KeyboardInput(game);
		
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);
		addKeyListener(keyboardListener);
		
		requestFocus();
	}
	
	private void setPanelSize() {
		size = new Dimension(1024, 576 + 100);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.getRenderer().render(g);
	}
}
