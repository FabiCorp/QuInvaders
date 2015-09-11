package de.qudosoft.quinvaders.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class GameScreen extends Screen {
	
	private Texture ship;
	private Texture laser;
	
    private float shipX        = 200;
    private float shipY        = 0;
	private float shipSpeed    = 100.0f;
	
	private float laserX       = 0;
    private float laserY       = 0;
    private boolean shootLaser = false;
    
	public GameScreen() {
		ship  = new Texture("Q_solo_reg_rgb2.png");
		laser = new Texture("64px-SpaceInvadersLaserDepiction.png");
		
	}

	@Override
	public void userInput() {
		System.out.println("GameScreen userInput");
		if(Gdx.input.isKeyPressed(Keys.LEFT)){
			shipX -= Gdx.graphics.getDeltaTime() * shipSpeed;
			
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)){
			shipX += Gdx.graphics.getDeltaTime() * shipSpeed;
		}
		if (!shootLaser){
			if(Gdx.input.isKeyPressed(Keys.SPACE)){
				shootLaser = true;
				laserX     = shipX + 16;
				laserY     = shipY + 16;
			
			}
		}
	}

	@Override
	public void modelUpdate() {
		
	}
	@Override
	public void draw() {
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		getBatch().begin();
		if(shootLaser){
			getBatch().draw(laser, laserX, laserY);
			laserY = laserY + 5;
			if (laserY > 485.0){
				shootLaser = false;
			}
		}
		getBatch().draw(ship, shipX, shipY);
		getBatch().end();

	}

}
