package de.qudosoft.quinvaders;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import de.qudosoft.quinvaders.screen.ScreenManager;

public class QuInvadersMain extends ApplicationAdapter {
	
	private ScreenManager screenManager;
	private Viewport viewport;
	private Camera camera;
	
	@Override
	public void create () {
		screenManager = new ScreenManager();
		camera = new PerspectiveCamera();
	    viewport = new StretchViewport(1200, 1000, camera);
	}
	
	public void resize(int width, int height) {
	    viewport.update(width, height);
	}

	@Override
	public void render () {
		
		screenManager.userInput();
		
		screenManager.modelUpdate(Gdx.graphics.getDeltaTime());
		
		screenManager.draw();
	}
}
