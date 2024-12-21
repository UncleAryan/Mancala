package framework;

import java.awt.*;
import java.util.LinkedList;

public abstract class GameObject {
	protected int x, y, width, height;
	protected String ID;
	protected Rectangle bounds;
	protected int stones;
	
	public GameObject(int x, int y, int width, int height, String ID) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.ID = ID;
		bounds = new Rectangle(x, y, width, height);
		if (ID.equals("Hole")) {
			stones = 4;
		} else {
			stones = 0;
		}
	}

	public Rectangle getBounds() {
		return bounds;
	}
	
	public void updateBounds() {
		bounds.x = (int) x;
		bounds.y = (int) y;
	}

	public int getStones() {
		return stones;
	}

	public void setStones(int stones) {
		this.stones = stones;
	}

	public abstract void render(Graphics g);
	public abstract void tick(LinkedList<GameObject> gameObjects);

	public void showBoundsOutline(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(x, y, width, width);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		updateBounds();
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		updateBounds();
	}
	
	public String getID() {
		return ID;
	}
}
