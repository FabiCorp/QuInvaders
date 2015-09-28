package de.qudosoft.quinvaders.util;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameGlobals {

	private SpriteBatch batch;
	
	private TextureFactory textureFactory;
	
	private final float leftEnd     = 20;
	
	private final float screenWidth = 640;
	
	private final float dropDown    = 20;
	
	private GameGlobals() {
		batch          = new SpriteBatch();
		textureFactory = new TextureFactory();
	}
	
	private static GameGlobals INSTANCE;
	
	public static GameGlobals getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new GameGlobals();
		}
		
		return INSTANCE;
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public float getLeftEnd() {
		return leftEnd;
	}

	public TextureFactory getTextureFactory() {
		return textureFactory;
	}

	public float getScreenWidth() {
		return screenWidth;
	}

	public float getDropDown() {
		return dropDown;
	}

	
}
