package de.qudosoft.quinvaders.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;

import de.qudosoft.quinvaders.sprite.Alien;
import de.qudosoft.quinvaders.sprite.Laser;
import de.qudosoft.quinvaders.sprite.Spaceship;
import de.qudosoft.quinvaders.util.GameGlobals;
import de.qudosoft.quinvaders.util.Point;

public class GameScreen extends Screen {

	private Spaceship spaceship;
	private Laser laser;
	private Alien alien;
	private boolean shootLaser = false;

	public GameScreen() {
		spaceship = new Spaceship();
		laser     = new Laser();
		alien     = new Alien();
	}

	@Override
	public void userInput() {
		Point position        = spaceship.getPosition();
		if(Gdx.input.isKeyPressed(Keys.LEFT)){
			position.setX(position.getX()- spaceship.getSpeed());
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)){
			position.setX(position.getX()+ spaceship.getSpeed());
		}

		if (!shootLaser){
			Point laserPosition = laser.getPosition();
			if(Gdx.input.isKeyPressed(Keys.SPACE)){
				shootLaser = true;
				laserPosition.setX(position.getX() + 16);
				laserPosition.setY(position.getY() + 16);

			}
		}
	}

	@Override
	public void modelUpdate(float deltaTime) {
		alien.modelUpdate(deltaTime);

	}

	@Override
	public void draw() {
		Point laserPosition = laser.getPosition();

		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		GameGlobals.getInstance().getBatch().begin();

		laser.draw();
		spaceship.draw();
		alien.draw();

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
