package framework;

import java.awt.*;
import java.util.LinkedList;

public abstract class GameObject {
	protected int x, y, width, height;
	protected int ID;
	protected Rectangle bounds;
	protected int stones;
	
	public GameObject(int x, int y, int width, int height, int ID) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.ID = ID;
		bounds = new Rectangle(x, y, width, height);
		if (ID == 6 || ID == 13) {
			stones = 0;
		} else {
			stones = 4;
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
	
	public int getID() {
		return ID;
	}
}
