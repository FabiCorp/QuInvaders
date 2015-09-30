package de.qudosoft.quinvaders.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import de.qudosoft.quinvaders.util.GameGlobals;

public class ScreenManager implements GameEntity {

	private Screen screen;
	private ScreenState screenState  = null;
	private boolean switchToGame     = false;
	private boolean switchToHelp     = false;
	private boolean switchToMainMenu = false;

	public ScreenManager() {
		screen = new MainMenuScreen();
		screenState = ScreenState.MAINMENU;
	}

	@Override
	public void userInput() {
		if (screenState == ScreenState.MAINMENU) {
			if (Gdx.input.isKeyPressed(Keys.G)) {
				switchToGame = true;
			} else if (Gdx.input.isKeyPressed(Keys.H)) {
				switchToHelp = true;
			}
		} else if (screenState == ScreenState.GAME) {
			if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
				switchToMainMenu = true;
			} else {
				screen.userInput();
			}
		} else if (screenState == ScreenState.HELP) {
			if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
				switchToMainMenu = true;
			} else {
				screen.userInput();
			}

		} else if (screenState == ScreenState.END) {
			if (Gdx.input.isKeyPressed(Keys.G)) {
				switchToGame = true;
			} else if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
				switchToMainMenu = true;
			} else {
				screen.userInput();
			}
		}
	}

	public Screen getScreen() {
		return screen;
	}

	@Override
	public void modelUpdate(float deltaTime) {
		if(GameGlobals.getInstance().isGameEnd()){
			screenState = screenState.END;
			screen = new EndScreen();
			GameGlobals.getInstance().setGameEnd(false);
		}
		if (switchToGame) {
			screenState = ScreenState.GAME;
			screen = new GameScreen();
			switchToGame = false;
			GameGlobals.getInstance().setLives(3);
			GameGlobals.getInstance().setCombo(0);
			GameGlobals.getInstance().setScore(0);
		}
		if (switchToMainMenu) {
			screenState = ScreenState.MAINMENU;
			screen = new MainMenuScreen();
			switchToMainMenu = false;
		}
		if (switchToHelp) {
			screenState = ScreenState.HELP;
			screen = new HelpScreen();
			switchToHelp = false;
		} else {
			screen.modelUpdate(deltaTime);
		}
	}

	@Override
	public void draw() {
		screen.draw();

	}

}
