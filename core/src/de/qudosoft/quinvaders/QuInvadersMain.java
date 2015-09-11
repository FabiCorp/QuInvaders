package de.qudosoft.quinvaders;

import com.badlogic.gdx.ApplicationAdapter;

import de.qudosoft.quinvaders.screen.ScreenManager;

public class QuInvadersMain extends ApplicationAdapter {
	
	private ScreenManager screenManager;
	
	@Override
	public void create () {
		
		screenManager = new ScreenManager();
	}

	@Override
	public void render () {
		
		screenManager.userInput();
		
		screenManager.modelUpdate();
		
		screenManager.draw();
	}
}
