package de.qudosoft.quinvaders.animation;

import de.qudosoft.quinvaders.sprite.Sprite;

public class Collision {
	
	public static boolean collides(Sprite sprite, Sprite sprite2 ){

		return sprite.isAlive() && sprite2.isAlive() && sprite.getBoundingBox().intersects(sprite2.getBoundingBox());
	}
}
