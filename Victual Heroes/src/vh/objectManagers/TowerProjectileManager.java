package vh.objectManagers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import vh.helper.Constants.Enemies;
import vh.helper.LoadSave;
import vh.object.Tower;
import vh.object.TowerProjectile; 
import vh.enemy.Enemy;
import vh.scene.Playing;
import static vh.helper.Constants.Towers.*;
import static vh.helper.Constants.TowerProjectiles.*;

public class TowerProjectileManager {
	
	private Playing playing;
	private ArrayList<TowerProjectile> towerProjectiles = new ArrayList<>();
	private BufferedImage[] projectile_Images;
	private int projectile_Id = 0;
	
	public TowerProjectileManager (Playing playing) {
		this.playing = playing;
		importing();
	}
	
	private void importing() {
		
		BufferedImage projectileAtlas = LoadSave.getTowerAtlas();
		this.projectile_Images = new BufferedImage[4];
		
		for (int i = 0; i < 4; i++) {
			projectile_Images[i] = projectileAtlas.getSubimage(48*i + 48*3, 48*6, 16, 16);
		}
	}
	
	public void newProjectile(Tower t, Enemy e) {
		int type = getProjectileType(t);
		int damage = getDefaultDamage(type);
		
		int xDistance = (int) Math.abs(t.getX() - e.getX());
		int yDistance = (int) Math.abs(t.getY() - e.getY());
		int totalDistance = xDistance + yDistance;
		
		float xProportion = (float) xDistance/ totalDistance;
		//float yProportion = 1.0f - xProportion;
				
		float xSpeed = xProportion * vh.helper.Constants.TowerProjectiles.getSpeed(t.getTowerType());
		float ySpeed = vh.helper.Constants.TowerProjectiles.getSpeed(t.getTowerType()) - xSpeed;
	
		if (t.getX() > e.getX()) {
			xSpeed = -xSpeed;
		}
		if (t.getY() > e.getY()) {
			ySpeed = -ySpeed;
		}
		
		towerProjectiles.add(new TowerProjectile((t.getX() + t.getTowerSize()/2), (t.getY() + t.getTowerSize()/2), xSpeed, ySpeed, projectile_Id++ , damage,  type));
		
	}
	
	private int getProjectileType(Tower t) {
		switch(t.getTowerType()) {
			case METAL :
				return METALS;
			case JADE :
				return JADES;
			case SNOW :
				return SNOWS;
			case WOOD :
				return WOODS;
		}
		return 0;
	}

	public void update() {
		for (TowerProjectile p : towerProjectiles) {
			if (p.isActive()) {
				p.move();
				if (isProjectileHitEnemy(p)) {
					p.setActive(false);
				}else {
					// nothing for now
				}
			}
		}
	}
	
	private boolean isProjectileHitEnemy(TowerProjectile p) {
		for (Enemy e : playing.getEnemyManager().getEnemies()) {
			if (e.getBound().contains(p.getPosition())) {
					e.attacked(p.getProjectileDamage());
					return true;
			}
		}
		return false;
	}

	public void draw(Graphics g) {
		for (TowerProjectile p : towerProjectiles) {
			if (p.isActive())
				g.drawImage(projectile_Images[p.getProjectileType()], (int) p.getPosition().getX(), (int) p.getPosition().getY(), null);
		}
	}

}
