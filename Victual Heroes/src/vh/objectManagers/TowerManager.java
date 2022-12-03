package vh.objectManagers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import vh.helper.LoadSave;
import vh.object.Tower;
import vh.scene.Playing;
import static vh.helper.Constants.Towers.*;

public class TowerManager {
	
	private Playing playing;
	private BufferedImage[] towerImages;
	private ArrayList<Tower> towers = new ArrayList<>();
	private int towerCount = 0;
	
	public TowerManager(Playing playing) {
		this.playing = playing;
		
		loadTowerImages();
	}

//	private void initializeTowers() {
//		tower = new Tower(5*16, 5*16, 0, SNOW);
//		
//	}

	private void loadTowerImages() {
		BufferedImage towerAtlas = LoadSave.getTowerAtlas();
		this.towerImages = new BufferedImage[4];
		
		for (int i = 0 ; i < 4 ; i++) {
			towerImages[i] = towerAtlas.getSubimage(48*i + 48*2, 48*12, 48, 48);
//			towerImages[i] = towerAtlas.getSubimage(32*i + 32*7, 32*3, 32, 32);
		}
	}
	
	public void draw(Graphics g) {
		for (Tower t : towers) {
			g.drawImage(towerImages[t.getTowerType()], t.getX(), t.getY(), null);
		}
	}
	
	public void update() {
		// TODO Auto-generated method stub
	}
	
	public void addTower(Tower curTower, int x, int y) {
		towers.add(new Tower(x, y, towerCount++ + 1, curTower.getTowerType()));
		
	}
	
	public Tower getTowerOn(int x, int y) {
		
		for (Tower t : towers) {
			if (t.getX() == x && t.getY() == y) {
				return t;
			}
		}
		
		return null;
	}


	public BufferedImage[] getTowerImages() {
		return towerImages;
	}
}