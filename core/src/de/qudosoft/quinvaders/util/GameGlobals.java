package de.qudosoft.quinvaders.util;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameGlobals {

	private SpriteBatch batch;
	
	private TextureFactory textureFactory;
	
	boolean won = false;
	
	boolean gameEnd = false;
	
	private final float leftEnd     = 20;
	
	private final float screenWidth = 640;
	
	private final float dropDown    = 10;
	
	private int lifes = 3;
	
	private int combo;
	
	private int score;
	
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

	public boolean isWon() {
		return won;
	}

	public void setWon(boolean won) {
		this.won = won;
	}

	public boolean isGameEnd() {
		return gameEnd;
	}

	public void setGameEnd(boolean gameEnd) {
		this.gameEnd = gameEnd;
	}

	public int getLives() {
		return lifes;
	}

	public void setLives(int lives) {
		this.lifes = lives;
	}

	public int getCombo() {
		return combo;
	}

	public void setCombo(int combo) {
		this.combo = combo;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
}
