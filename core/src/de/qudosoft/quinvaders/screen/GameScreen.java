package de.qudosoft.quinvaders.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import de.qudosoft.quinvaders.sprite.AlienMatrix;
import de.qudosoft.quinvaders.sprite.AliveState;
import de.qudosoft.quinvaders.sprite.Laser;
import de.qudosoft.quinvaders.sprite.Spaceship;
import de.qudosoft.quinvaders.util.GameGlobals;
import de.qudosoft.quinvaders.util.Point;

public class GameScreen extends Screen {

	private Spaceship spaceship;
	private Laser laser;
	private boolean shootLaser = false;
	private Texture background;
	private AlienMatrix alienMatrix;
	
	public GameScreen() {
		spaceship   = new Spaceship();
		laser       = new Laser();
		background  = new Texture("QuInvadersBackground.jpg");
		alienMatrix = new AlienMatrix();
	}

	@Override
	public void userInput() {
		Point position        = spaceship.getPosition();
		if(Gdx.input.isKeyPressed(Keys.LEFT)){
			if (position.getX() > GameGlobals.getInstance().getLeftEnd()){
				position.setX(position.getX()- spaceship.getSpeed());
			}
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)){
			// TODO 31 weg...
			if (position.getX() + 31 < GameGlobals.getInstance().getScreenWidth())
			position.setX(position.getX()+ spaceship.getSpeed());
		}

		if (!shootLaser){
			Point laserPosition = laser.getPosition();
			if(Gdx.input.isKeyPressed(Keys.SPACE)){
				shootLaser = true;
				laser.setAliveState(AliveState.ALIVE);
				laserPosition.setX(position.getX() + 15);
				laserPosition.setY(position.getY() + 15);

			}
		}
	}

	@Override
	public void modelUpdate(float deltaTime) {
		alienMatrix.modelUpdate(deltaTime);
		if(alienMatrix.levelEnds(spaceship)){
			//TODO terminate level here!!!
		}
		laser.modelUpdate(deltaTime);
		alienMatrix.killAliens(laser);


	}

	@Override
	public void draw() {
		Point laserPosition = laser.getPosition();
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		GameGlobals.getInstance().getBatch().begin();
		GameGlobals.getInstance().getBatch().draw(background, 0, 0);
		spaceship.draw();
		if (laser.isAlive()){
			laser.draw();
		}
		alienMatrix.draw();
		
		
		
		if(shootLaser){

			if (laserPosition.getY() > 485.0){
				shootLaser = false;
			}
			else {
				laserPosition.setY(laserPosition.getY() + laser.getSpeed());

			}
		}

		GameGlobals.getInstance().getBatch().end();

	}

	

}
