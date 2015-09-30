package de.qudosoft.quinvaders.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import de.qudosoft.quinvaders.util.GameGlobals;

public class MainMenuScreen extends Screen {
	
	private Texture pressButton;
	com.badlogic.gdx.graphics.g2d.Sprite sprite;
	
	
	public MainMenuScreen() {
		pressButton = new Texture("QuinvadersLogo.png");
		sprite = new com.badlogic.gdx.graphics.g2d.Sprite(pressButton);
		sprite.setSize(640, 500 * sprite.getHeight() / sprite.getWidth());
		
	}
	
	@Override
	public void userInput() {
		
	}

	@Override
	public void modelUpdate(float deltaTime) {
	}

	@Override
	public void draw() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		GameGlobals.getInstance().getBatch().begin();
		sprite.setPosition(0, 0);
		sprite.draw(GameGlobals.getInstance().getBatch());
		GameGlobals.getInstance().getBatch().end();

	}

}
