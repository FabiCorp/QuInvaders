package de.qudosoft.quinvaders.animation;

import de.qudosoft.quinvaders.sprite.Laser;
import de.qudosoft.quinvaders.sprite.Sprite;

public class Collision {
	
	public static boolean collides(Sprite sprite, Laser laser){

		return sprite.getBoundingBox().intersects(laser.getBoundingBox());
	}
}
