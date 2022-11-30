package vh.helper;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave {
	
	public static BufferedImage getMapAtlas() {
		
		BufferedImage img = null;
		InputStream is;
		
		try {
			is = LoadSave.class.getClassLoader().getResourceAsStream("outdoors.png");
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
		/*
		is = getClass().getResourceAsStream("/marioatlas.png");
		try {
			this.spriteIMG = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}
	
	public static BufferedImage getSpriteAtlas() {
		
		BufferedImage img = null;
		InputStream is;
		
		try {
			is = LoadSave.class.getClassLoader().getResourceAsStream("enemy1.png");
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
		/*
		is = getClass().getResourceAsStream("/marioatlas.png");
		try {
			this.spriteIMG = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}
	
}