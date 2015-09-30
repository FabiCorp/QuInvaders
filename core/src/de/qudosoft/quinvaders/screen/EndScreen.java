package de.qudosoft.quinvaders.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import de.qudosoft.quinvaders.util.GameGlobals;

public class EndScreen extends Screen {
	
	private Texture WinOrLosePicture;
	private BitmapFont score;
	com.badlogic.gdx.graphics.g2d.Sprite sprite;
	
	
	public EndScreen() {
		if (GameGlobals.getInstance().isWon()){
			WinOrLosePicture = new Texture("win-screen.png");
			GameGlobals.getInstance().setWon(false);
		} else {
			WinOrLosePicture = new Texture("Game Over screen.jpg");
		}
		sprite = new com.badlogic.gdx.graphics.g2d.Sprite(WinOrLosePicture);
		sprite.setSize(700, 900 * sprite.getHeight() / sprite.getWidth());
		score  = new BitmapFont();
	    score.setColor(Color.FIREBRICK);   
	}
	@Override
	public void userInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modelUpdate(float deltaTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		GameGlobals.getInstance().getBatch().begin();
		
		sprite.setPosition(0, 0);
		sprite.draw(GameGlobals.getInstance().getBatch());
		score.draw(GameGlobals.getInstance().getBatch(),"Endscore:" + GameGlobals.getInstance().getScore() , 320, 360);
		
		GameGlobals.getInstance().getBatch().end();
		
	}

}
