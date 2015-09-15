package de.qudosoft.quinvaders.sprite;

import com.badlogic.gdx.graphics.Texture;

import de.qudosoft.quinvaders.util.Point;


public class Laser extends Sprite{
	
	public Laser() {
		setPicture(new Texture("64px-SpaceInvadersLaserDepiction.png"));
		setPosition(new Point(0, 0));
		setSpeed(5);
	}

	@Override
	public void modelUpdate(float deltaTime) {
		// TODO Auto-generated method stub
		
	}

}
