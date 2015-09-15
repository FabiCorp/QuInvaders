package de.qudosoft.quinvaders.sprite;

import com.badlogic.gdx.graphics.Texture;

import de.qudosoft.quinvaders.util.Point;

public class Spaceship extends Sprite{
	
	public Spaceship() {
		setPicture(new Texture("Q_solo_reg_rgb2.png"));
		setPosition(new Point(500, 0));
		setSpeed(5);
		
	}

	@Override
	public void modelUpdate(float deltaTime) {
		// TODO Auto-generated method stub
		
	}
}