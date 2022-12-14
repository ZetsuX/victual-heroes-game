package vh.objectManagers;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import vh.helper.LoadSave;
import vh.hungries.Hungries;
import vh.object.Stall;
import vh.scene.Playing;
import static vh.helper.Constants.StallsClass.*;

public class StallManager {
	
	private Playing playing;
	private BufferedImage[] stallImages;
	public ArrayList<Stall> stalls = new ArrayList<>();
	private int stallCount = 0;
	
	public StallManager(Playing playing) {
		this.playing = playing;
		
		loadstallImages();
	}

	private void loadstallImages() {
		BufferedImage stallAtlas = LoadSave.getStallAtlas();
		this.stallImages = new BufferedImage[4];
		
		for (int i = 0 ; i < 4 ; i++) {
			stallImages[i] = stallAtlas.getSubimage(48*i, 0, 48, 48);
		}
	}
	
	public void draw(Graphics g) {
		for (Stall s : stalls) {
			g.drawImage(stallImages[s.getStallType()], s.getX(), s.getY(), null);
		}
	}
	
	public void update() {
		for (Stall s : stalls) {
			s.update();
			feedHungriesIfClose(s);
		}
	}
	
	private void feedHungriesIfClose(Stall s) {
		for (Hungries h : playing.getHungriesManager().getAllHungries()) {
			// breakdown is Alive from this if, if necessary for further development
			if (h.isHungry() && isHungriesInRange(s, h) && s.isCooldown()) {
				h.fed(s.getStallDamage());
				playing.feedEnemy(s, h);
				s.resetCooldown();
				break;
			}else {
				// do nothing for now
			}
		}		
	}
	
	private boolean isHungriesInRange(Stall s, Hungries h) {
		
		int range = vh.helper.Utility.GetHypoDistance(s.getX(), s.getY(), h.getX(), h.getY());
		return range < s.getStallRange()/2;
	}

	public void addStall(Stall curstall, int x, int y) {
		stalls.add(new Stall(x, y, stallCount++ + 1, curstall.getStallType()));
		
	}
	
	public Stall getStallIntersect(Rectangle r) {
		
		for (Stall s : stalls) {
			if (s.getBound().intersects(r)) {
				return s;
			}
		}
		
		return null;
	}
	
	public Stall getPathIntersect(Rectangle r) {
		
		for (Stall s : stalls) {
			if (s.getBound().intersects(r)) {
				return s;
			}
		}
		
		return null;
	}
	
	public Stall getStallOn(int x, int y) {
		
		for (Stall s : stalls) {
			if (s.getBound().contains(x, y)) {
				return s;
			}
		}
		
		return null;
	}
	
	public void upgradeStall(Stall dispStall) {
		for (Stall s : stalls) {
			if (s.getId() == dispStall.getId()) s.upgradeStall();
		}
	}
	
	public void removeStall(Stall dispStall) {
		for (int i = 0 ; i < stalls.size() ; i++) {
			if (stalls.get(i).getId() == dispStall.getId()) {
				stalls.remove(i);
			}
		}
		
	}

	public BufferedImage[] getStallImages() {
		return stallImages;
	}
	
	public void resetStalls() {
		stalls.clear();
		stallCount = 0;
	}
}
