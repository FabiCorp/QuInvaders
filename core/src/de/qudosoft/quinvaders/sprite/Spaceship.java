package de.qudosoft.quinvaders.sprite;

import com.badlogic.gdx.graphics.Texture;

import de.qudosoft.quinvaders.util.Point;
import de.qudosoft.quinvaders.util.TextureFactory;

public class Spaceship extends Sprite{
	
	public Spaceship(TextureFactory textureFactory) {
		
		super(textureFactory);
		
		setPicture(new Texture("Q_solo_reg_rgb2.png"));
		setPosition(new Point(500, 0));
		setSpeed(5);
		setSize(35);
		setRechtesEnde(618);
	}

	@Override
	public void modelUpdate(float deltaTime) {
		
	}
}