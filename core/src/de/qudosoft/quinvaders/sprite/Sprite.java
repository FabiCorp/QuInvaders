package de.qudosoft.quinvaders.sprite;

import com.badlogic.gdx.graphics.Texture;

import de.qudosoft.quinvaders.util.GameGlobals;
import de.qudosoft.quinvaders.util.Point;
import de.qudosoft.quinvaders.util.Vector;

public abstract class Sprite {
	
	private Point position;
	
	private Texture picture;
	
	private int direction; // +1 or -1
	
	private float speed;
	
	public abstract void modelUpdate(float deltaTime);
	
	public void draw (){
			
		GameGlobals.getInstance().getBatch().draw(picture, position.getX(), position.getY());
	}
	
	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Texture getPicture() {
		return picture;
	}

	public void setPicture(Texture picture) {
		this.picture = picture;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	
	
}
