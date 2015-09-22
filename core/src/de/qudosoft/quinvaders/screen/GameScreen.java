package de.qudosoft.quinvaders.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import de.qudosoft.quinvaders.animation.Collision;
import de.qudosoft.quinvaders.sprite.Alien;
import de.qudosoft.quinvaders.sprite.AliveState;
import de.qudosoft.quinvaders.sprite.Laser;
import de.qudosoft.quinvaders.sprite.Spaceship;
import de.qudosoft.quinvaders.util.GameGlobals;
import de.qudosoft.quinvaders.util.Point;
import de.qudosoft.quinvaders.util.TextureFactory;

public class GameScreen extends Screen {

	private Spaceship spaceship;
	private Laser laser;
	private Alien alien;
	private boolean shootLaser = false;
	private Texture background;


	public GameScreen() {
		spaceship   = new Spaceship(new TextureFactory());
		laser       = new Laser(new TextureFactory());
		alien       = new Alien(new TextureFactory());
		background  = new Texture("QuInvadersBackground.jpg");
	}

	@Override
	public void userInput() {
		Point position        = spaceship.getPosition();
		if(Gdx.input.isKeyPressed(Keys.LEFT)){
			if (position.getX() > GameGlobals.getInstance().getLinkesende()){
				position.setX(position.getX()- spaceship.getSpeed());
			}
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)){
			if (position.getX() < spaceship.getRechtesEnde())
			position.setX(position.getX()+ spaceship.getSpeed());
		}

		if (!shootLaser){
			Point laserPosition = laser.getPosition();
			if(Gdx.input.isKeyPressed(Keys.SPACE)){
				shootLaser = true;
				laserPosition.setX(position.getX() + 15);
				laserPosition.setY(position.getY() + 15);

			}
		}
	}

	@Override
	public void modelUpdate(float deltaTime) {
		alien.modelUpdate(deltaTime);
		laser.modelUpdate(deltaTime);

	}

	@Override
	public void draw() {
		Point laserPosition = laser.getPosition();
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		GameGlobals.getInstance().getBatch().begin();
		GameGlobals.getInstance().getBatch().draw(background, 0, 0);
		laser.draw();
		spaceship.draw();
		
		if (alien.isAlive()) {
			alien.draw();
			if (Collision.collides(alien, laser)){
				System.out.println("Boooooom!");
				alien.setAliveState(AliveState.DEAD);
			}
		}
		
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
