package de.qudosoft.quinvaders.util;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameGlobals {

	private SpriteBatch batch;
	
	private final float rechtesEnde = 545;
	
	private final float linkesEnde  = 0;
	
	private GameGlobals() {
		batch = new SpriteBatch();
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

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	public float getRechtesende() {
		return rechtesEnde;
	}

	public float getLinkesende() {
		return linkesEnde;
	}
	
}
