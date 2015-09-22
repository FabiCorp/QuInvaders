package de.qudosoft.quinvaders.util;

import com.badlogic.gdx.graphics.Texture;

public class ResizeDrawUtil {

	public static void resizeTextureDraw(float size, Texture picture, float positionX, float positionY) {
		com.badlogic.gdx.graphics.g2d.Sprite sprite;
		sprite = new com.badlogic.gdx.graphics.g2d.Sprite(picture);
		sprite.setSize(size, size * sprite.getHeight() / sprite.getWidth());
		sprite.setPosition(positionX, positionY);
		sprite.draw(GameGlobals.getInstance().getBatch());
	}

}
