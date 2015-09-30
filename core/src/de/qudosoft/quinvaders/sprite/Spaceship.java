package de.qudosoft.quinvaders.sprite;

import com.badlogic.gdx.graphics.Texture;

import de.qudosoft.quinvaders.util.GameGlobals;
import de.qudosoft.quinvaders.util.Point;

public class Spaceship extends Sprite{
	
	public Spaceship() {
		
		setPicture(new Texture("Q_solo_reg_rgb2.png"));
		setPosition(new Point(500, 0));
		setSpeed(5);
		setSize(35);
	}

	@Override
	public void modelUpdate(float deltaTime) {
		setSpeed(5 + GameGlobals.getInstance().getCombo());
	}
}