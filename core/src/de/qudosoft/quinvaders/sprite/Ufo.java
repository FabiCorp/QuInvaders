package de.qudosoft.quinvaders.sprite;

import com.badlogic.gdx.graphics.Texture;

import de.qudosoft.quinvaders.util.Point;

public class Ufo extends Sprite{
	
	public Ufo() {
		
		setPicture(new Texture("bonusshipFARB.png"));
		setPosition(new Point(400, 400));
		setSpeed(5);
		setSize(35);
	}

	@Override
	public void modelUpdate(float deltaTime) {
		
	}
}