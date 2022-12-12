package vh.hungries;

import java.awt.Rectangle;
import static vh.helper.Constants.Direction.*;

public abstract class Hungries {
	
	private float x, y;
	private Rectangle hungriesBound;
	private int hunger;
	private int maxhunger;
	private int id;
	private int type;
	private int lastDir;
	private boolean hungry;
	
	public Hungries(float x, float y, int id, int type) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.type = type;
		this.lastDir = -1;
		this.hungry = true;
		
		hungriesBound = new Rectangle((int)x - 16 , (int)y - 16, 48, 48);
		setHungriesHP();
	}
	
	private void setHungriesHP() {
		hunger = vh.helper.Constants.Enemies.getHunger(id);
		maxhunger = hunger;
	}

	public void move(float speed, int direction) {
		
		lastDir = direction;
		switch (direction) {
		case LEFT :
			this.x -= speed;
			break;
		case UP :
			this.y -= speed;
			break;
		case RIGHT :
			this.x += speed;
			break;
		case DOWN :
			this.y += speed;
			break;
		}
		
		updateEnemyHitBox();
	}
	
	private void updateEnemyHitBox() {
		hungriesBound.x = (int) x - 16;
		hungriesBound.y = (int) y - 16;
	}

	public float getHungerBar() {
		return hunger/(float)maxhunger;
	}
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public Rectangle getBound() {
		return hungriesBound;
	}

	public int getHunger() {
		return hunger;
	}

	public int getId() {
		return id;
	}

	public int getType() {
		return type;
	}

	public int getLastDir() {
		return lastDir;
	}

	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void attacked(float feedEffect) {
		this.hunger -= feedEffect;
		if (this.hunger <= 0) this.hungry = false;
	}
	
	public boolean isAlive() {
		return hungry;
	}
	
	public void setDead() {
		hungry = false;
	}
}