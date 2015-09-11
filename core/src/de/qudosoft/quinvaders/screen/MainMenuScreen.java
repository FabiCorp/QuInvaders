package de.qudosoft.quinvaders.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class MainMenuScreen extends Screen {
	
	private Texture pressButton;
	
	public MainMenuScreen() {
		pressButton = new Texture("Press G and H.png");
		
	}
	
	@Override
	public void userInput() {
		System.out.println("MainMenuScreen userInput");
		
	}

	@Override
	public void modelUpdate() {
		System.out.println("MainMenuScreen modelUpdate");
	}

	@Override
	public void draw() {
		System.out.println("MainMenuScreen draw");
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		getBatch().begin();
		getBatch().draw(pressButton, 0, 0);
		getBatch().end();

	}

}
