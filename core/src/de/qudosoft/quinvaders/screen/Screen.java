package de.qudosoft.quinvaders.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Screen implements GameEntity {
	
	private SpriteBatch batch;
	
	public Screen() {
		batch = new SpriteBatch();
	}
	
	public abstract void modelUpdate();
	
	public abstract void draw();
	
	public SpriteBatch getBatch(){
		return batch;
	}

}
