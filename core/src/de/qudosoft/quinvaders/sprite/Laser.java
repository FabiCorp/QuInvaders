package de.qudosoft.quinvaders.sprite;

import java.awt.geom.Rectangle2D;

import de.qudosoft.quinvaders.util.Point;
import de.qudosoft.quinvaders.util.TextureFactory;


public class Laser extends Sprite{
	
	public Laser(TextureFactory textureFactory) {
		
		super(textureFactory);
		
		setPicture(textureFactory.createTexture("laser03.png"));
		setPosition(new Point(0, 0));
		setSpeed(15);
		setSize(3);
		setRechtesEnde(625);
		
	}

	@Override
	public void modelUpdate(float deltaTime) {
		setBoundingBox(new Rectangle2D.Float(getPosition().getX(), getPosition().getY()+getSize(), getSize(), getSize()* getPicture().getHeight() / getPicture().getWidth()));
	}

}
