package vh.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Button {

	private int x, y, width, height;
	private String name;
	private Rectangle buttonBound;
	
	private boolean mouseOverButton = false;
	private boolean mousePressedButton = false;
	
	public Button (String name, int x, int y, int width, int height) {
		
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		initializeBound();
	}
	
	private void initializeBound() {
		this.buttonBound = new Rectangle(x, y, width, height);
	}
	
	public void draw(Graphics g) {
		
		// Draw button's body
		drawButton(g);
		
		// Draw button's border
		drawBorder(g);
		
		// Draw button's name
		drawName(g);
		
	}
	
	private void drawName(Graphics g) {

		g.setColor(Color.BLACK);
		if (name == "Settings") g.drawString(name, x + (2*(width/7)), y + (2 * (height/3)));
		else g.drawString(name, x + (2*width/5), y + (2 * (height/3)));	
	}

	private void drawBorder(Graphics g) {

		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
		if(mousePressedButton) {
			g.drawRect(x + 1, y + 1, width - 2, height - 2);
			g.drawRect(x + 2, y + 2, width - 4, height - 4);
		} 
	}

	private void drawButton(Graphics g) {
		// TODO Auto-generated method stub
		if (mouseOverButton) {
			
			g.setColor(Color.black);
			g.fillRect(x, y, width, height);
			
			g.setColor(Color.gray);
			g.fillRect(x , y , width, height-3);
		}else {
			
			g.setColor(Color.WHITE);
			g.fillRect(x, y, width, height);
		}
	}
	
	

	public Rectangle getBounds() {
		return buttonBound;
	}
	
	public void setMouseOverButton (boolean mouseOverButton) {
		this.mouseOverButton = mouseOverButton;
	}
	
	public void setMousePressedButton (boolean mousePressedButton) {
		this.mousePressedButton = mousePressedButton;
	}
	
	public void resetMouseState () {
		this.mouseOverButton = false;
		this.mousePressedButton = false;
	}
}