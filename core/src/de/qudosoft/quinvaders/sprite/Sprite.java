package de.qudosoft.quinvaders.sprite;

import com.badlogic.gdx.graphics.Texture;

import de.qudosoft.quinvaders.animation.Animation;
import de.qudosoft.quinvaders.util.GameGlobals;
import de.qudosoft.quinvaders.util.Point;

public abstract class Sprite {
	
	private Point position;
	
	private Texture picture;
	
	private int direction; // +1 or -1
	
	private float speed;
	
	private Animation animation;
	
	
	
	public void modelUpdate(float deltaTime) {
		
		if (animation != null) {
			animation.updateModel(deltaTime);
		}
		
	}
	
	public void draw (){
			
		GameGlobals.getInstance().getBatch().draw(getPicture(), position.getX(), position.getY());
	}
	
	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Texture getPicture() {
		
		if (animation != null) {
			return animation.getCurrentImage(); 
		} else {
		
			return picture;
		}
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

	public Animation getAnimation() {
		return animation;
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}
	
	
	
}
