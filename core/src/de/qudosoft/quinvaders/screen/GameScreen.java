package de.qudosoft.quinvaders.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

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
	private Texture oneLife;
    private BitmapFont comboText;
    private BitmapFont score;

	
	public GameScreen() {
		spaceship   = new Spaceship();
		laser       = new Laser();
		background  = new Texture("QuInvadersBackground.jpg");
		alienMatrix = new AlienMatrix();
		oneLife     = new Texture("Q_solo_reg_rgb.png");
        comboText   = new BitmapFont();
        score       = new BitmapFont();
        comboText.setColor(Color.GOLD);
        score.setColor(Color.SKY);      
        
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
		alienMatrix.killAliens(laser);
		laser.modelUpdate(deltaTime);
		spaceship.modelUpdate(deltaTime);
		if(alienMatrix.levelEnds(spaceship, alienMatrix.getAlienLaser())){
			GameGlobals.getInstance().setGameEnd(true);
		}


	}

	@Override
	public void draw() {
		Point laserPosition = laser.getPosition();
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		GameGlobals.getInstance().getBatch().begin();
		
		GameGlobals.getInstance().getBatch().draw(background, 0, 0);
		
		if (GameGlobals.getInstance().getLives() > 0){
			GameGlobals.getInstance().getBatch().draw(oneLife, 0, 430);
		}
		if (GameGlobals.getInstance().getLives() > 1){
			GameGlobals.getInstance().getBatch().draw(oneLife, 50, 430);
		}
		if (GameGlobals.getInstance().getLives() > 2){
			GameGlobals.getInstance().getBatch().draw(oneLife, 100, 430);
		}
		
        comboText.draw(GameGlobals.getInstance().getBatch(), GameGlobals.getInstance().getCombo() + "x Combo", 270, 460);
        score.draw(GameGlobals.getInstance().getBatch(),"Score:" + GameGlobals.getInstance().getScore() , 540, 460);
        
        
		spaceship.draw();
		if (laser.isAlive()){
			laser.draw();
		}
		alienMatrix.draw();
		alienMatrix.alienShoot();
		
		
		
		if(shootLaser){

			if (laserPosition.getY() > 485.0){
				shootLaser = false;
				if (laser.isAlive()){
					GameGlobals.getInstance().setCombo(0);
				}
			}
			else {
				laserPosition.setY(laserPosition.getY() + laser.getSpeed() + GameGlobals.getInstance().getCombo());

			}
		}

		GameGlobals.getInstance().getBatch().end();

	}

	

}
