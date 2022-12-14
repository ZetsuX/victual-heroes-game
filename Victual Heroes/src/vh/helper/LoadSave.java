package vh.helper;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave {
	
	public static String homePath = System.getProperty("user.home");
	public static String folderSafe = "Victual Heroes";
	public static String dataFile = "userData";
	public static String filePath = homePath + File.separator + folderSafe + File.separator + dataFile;
	private static File userData = new File(filePath);
	
	public static void makeFolder() {
		File folder = new File(homePath + File.separator + folderSafe);
		if (!folder.exists()) folder.mkdir();
	}
	
	public static File getUserData() {
		return userData;
	}
	
	public static BufferedImage getMapAtlas() {
		
		BufferedImage img = null;
		InputStream is;
		
		try {
			is = LoadSave.class.getClassLoader().getResourceAsStream("mapAtlas.png");
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}
	
	public static BufferedImage getHungriesAtlas() {
		
		BufferedImage img = null;
		InputStream is;
		
		try {
			is = LoadSave.class.getClassLoader().getResourceAsStream("enemysprite.png");
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}
	
	public static BufferedImage getStallAtlas() {
		
		BufferedImage img = null;
		InputStream is;
		
		try {
			is = LoadSave.class.getClassLoader().getResourceAsStream("toweratlas.png");
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}

	public static BufferedImage getFoodAtlas() {
	
		BufferedImage img = null;
		InputStream is;
		
		try {
			is = LoadSave.class.getClassLoader().getResourceAsStream("projectileatlas.png");
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}
	
	public static BufferedImage getSlowedImage() {
		
		BufferedImage img = null;
		InputStream is;
		
		try {
			is = LoadSave.class.getClassLoader().getResourceAsStream("slowedatlas.png");
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}
	
	public static BufferedImage getBurnedImage() {
		
		BufferedImage img = null;
		InputStream is;
		
		try {
			is = LoadSave.class.getClassLoader().getResourceAsStream("burnedatlas.png");
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}
	
	public static BufferedImage getExplosionAtlas() {
		
		BufferedImage img = null;
		InputStream is;
		
		try {
			is = LoadSave.class.getClassLoader().getResourceAsStream("explosionimg.png");
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}
	
	public static BufferedImage getCoinSprite() {
		
		BufferedImage img = null;
		InputStream is;
		
		try {
			is = LoadSave.class.getClassLoader().getResourceAsStream("coinsprite.png");
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}
	
	public static BufferedImage getMiniCoin() {
		
		BufferedImage img = null;
		InputStream is;
		
		try {
			is = LoadSave.class.getClassLoader().getResourceAsStream("coinimg.png");
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}
	
	public static BufferedImage getAboutBackground() {
		
		BufferedImage img = null;
		InputStream is;
		
		try {
			is = LoadSave.class.getClassLoader().getResourceAsStream("aboutBG.png");
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}
	
	public static BufferedImage getBaseIcon() {
		
		BufferedImage img = null;
		InputStream is;
		
		try {
			is = LoadSave.class.getClassLoader().getResourceAsStream("burger.png");
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}
	
	public static BufferedImage getSettingsBackground() {
		
		BufferedImage img = null;
		InputStream is;
		
		try {
			is = LoadSave.class.getClassLoader().getResourceAsStream("settingsbg.jpg");
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}
	
	public static BufferedImage getGameOverWinBackground() {
		
		BufferedImage img = null;
		InputStream is;
		
		try {
			is = LoadSave.class.getClassLoader().getResourceAsStream("overbgwin.png");
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}
	
	public static BufferedImage getGameOverLoseBackground() {
		
		BufferedImage img = null;
		InputStream is;
		
		try {
			is = LoadSave.class.getClassLoader().getResourceAsStream("overbglose.png");
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}
}
