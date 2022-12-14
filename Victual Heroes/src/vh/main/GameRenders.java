package vh.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class GameRenders {

	private GameMain game;
	private Random rand;
	
	public GameRenders(GameMain gm) {
		this.game = gm;
		this.rand = new Random();
	}
	
	public void render(Graphics g) {
		switch(GameStates.gameState) {
		
			case MENU :
				game.getMenu().render(g);
				break;
				
			case ABOUT :
				game.getAbout().render(g);
				break;
				
			case PLAYING :
				game.getPlaying().render(g);
				break;
				
			case OVER :
				game.getGameOver().render(g);
				break;
				
			case SETTINGS :
				game.getSettings().render(g);
				break;
		}
	}
}
