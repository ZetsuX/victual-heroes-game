package vh.enemy;

import java.awt.Rectangle;

public class Enemy {
	
	private float x, y;
	private Rectangle bounds;
	private int hp;
	private int id;
	private int type;
	
	public Enemy(float x, float y, int id, int type) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.type = type;
		
		bounds = new Rectangle((int)x, (int)y, 32, 32);
	}

	public void move(float xSpd, float ySpd) {
		this.x += xSpd;
		this.y += ySpd;
	}
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public int getHp() {
		return hp;
	}

	public int getId() {
		return id;
	}

	public int getType() {
		return type;
	}
}