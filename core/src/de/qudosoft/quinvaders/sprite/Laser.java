package de.qudosoft.quinvaders.sprite;

import java.awt.geom.Rectangle2D;

import de.qudosoft.quinvaders.util.GameGlobals;
import de.qudosoft.quinvaders.util.Point;


public class Laser extends Sprite{
	
	public Laser() {
		
		setPicture(GameGlobals.getInstance().getTextureFactory().createTexture("laser03.png"));
		setPosition(new Point(0, 0));
		setSpeed(25);
		setSize(3);		
	}

	@Override
	public void modelUpdate(float deltaTime) {
		setBoundingBox(new Rectangle2D.Float(getPosition().getX(), getPosition().getY()+getSize(), getSize(), getSize()* getPicture().getHeight() / getPicture().getWidth()));
	}

}
