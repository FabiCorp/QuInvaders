package de.qudosoft.quinvaders.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import de.qudosoft.quinvaders.util.GameGlobals;

public class MainMenuScreen extends Screen {
	
	private Texture pressButton;
	
	
	public MainMenuScreen() {
		pressButton = new Texture("QuinvadersLogo.png");
		
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
		GameGlobals.getInstance().getBatch().draw(pressButton, 0, 0);
		GameGlobals.getInstance().getBatch().end();

	}

}
