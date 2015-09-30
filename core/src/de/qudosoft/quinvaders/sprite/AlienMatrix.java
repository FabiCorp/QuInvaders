package de.qudosoft.quinvaders.sprite;

import java.util.Random;

import de.qudosoft.quinvaders.animation.Animation;
import de.qudosoft.quinvaders.animation.Collision;
import de.qudosoft.quinvaders.screen.GameEntity;
import de.qudosoft.quinvaders.util.GameGlobals;
import de.qudosoft.quinvaders.util.Point;

public class AlienMatrix implements GameEntity{

	private static final int ALIEN_NUM_ROWS = 5;

	private static final int ALIEN_NUM_COLS = 9;

	private Alien[][] aliens;

	private float speed;

	private Point position;

	private Point oldPosition;

	private final int DELTA_HOR = 10;

	private final int DELTA_VERT = 5;

	private Animation animation;

	private float width;

	int lastRow = ALIEN_NUM_ROWS - 1;

	Laser alienLaser = new Laser();

	public AlienMatrix() {
		aliens = new Alien[ALIEN_NUM_ROWS][ALIEN_NUM_COLS];
		for (int i = 0; i < ALIEN_NUM_ROWS; i++){
			for(int j = 0; j < ALIEN_NUM_COLS; j++){

				switch (i) {
				case 0:
					aliens[i][j] = new AlienEnd();
					break;
				case 1:
				case 2:
					aliens[i][j] = new AlienMid();
					break;
				case 3:
				case 4:
					aliens[i][j] = new AlienFront();
					break;
				default:
					// ggfs Fehlermeldung
					break;
				}
				//				System.out.println(aliens[i][j]);
			}
		}

		setPosition(new Point (10, 400));
		oldPosition = new Point(0, 0);
		width = aliens[ALIEN_NUM_ROWS-1][ALIEN_NUM_COLS-1].getPicture().getWidth() + aliens[ALIEN_NUM_ROWS-1][ALIEN_NUM_COLS-1].getPosition().getX();
	}	

	public void draw(){

		for (int i = 0; i < ALIEN_NUM_ROWS; i++) {
			for (int j = 0; j < ALIEN_NUM_COLS; j++) {
				Alien alien = aliens[i][j];
				if (alien.isAlive()){
					alien.draw();
				}
			}
		}
	}

	public void setPosition(Point position) {

		// set position of aliens
		for (int i = 0; i < ALIEN_NUM_ROWS; i++) {
			for (int j = 0; j < ALIEN_NUM_COLS; j++) {
				Alien alien = aliens[i][j];
				float x = position.getX() + (alien.getPicture().getWidth() + DELTA_HOR) * j;
				float y = position.getY() - (alien.getPicture().getHeight() + DELTA_VERT) * i;
				alien.getPosition().setX(x);
				alien.getPosition().setY(y);
			}
		}

		this.position = position;
	}
	@Override
	public void modelUpdate(float deltaTime) {
		for (int i = 0; i < ALIEN_NUM_ROWS; i++) {
			for (int j = 0; j < ALIEN_NUM_COLS; j++) {
				Alien alien = aliens[i][j];

				alien.modelUpdate(deltaTime);
			}
		}
		position.setX(aliens[0][0].getPosition().getX());
		position.setY(aliens[0][0].getPosition().getY() + aliens[0][0].getPicture().getHeight());

		if (oldPosition.getX() != position.getX()) {
			oldPosition.setX(position.getX());
			if (position.getX() + width >= GameGlobals.getInstance().getScreenWidth()) {
				for (int i = 0; i < ALIEN_NUM_ROWS; i++) {
					for (int j = 0; j < ALIEN_NUM_COLS; j++) {
						Alien alien = aliens[i][j];

						alien.setDirection(-1);
						alien.setPosition(new Point(alien.getPosition().getX(), alien.getPosition().getY() - GameGlobals.getInstance().getDropDown()));

					}
				}
			}
			if (position.getX() <= GameGlobals.getInstance().getLeftEnd()) {
				for (int i = 0; i < ALIEN_NUM_ROWS; i++) {
					for (int j = 0; j < ALIEN_NUM_COLS; j++) {
						Alien alien = aliens[i][j];

						alien.setDirection(1);
						alien.setPosition(new Point(alien.getPosition().getX(), alien.getPosition().getY() - GameGlobals.getInstance().getDropDown()));

					}
				}
			} 
		}
	}

	public boolean levelEnds(Spaceship spaceship, Laser laser) {
		boolean allDead = true;
		for (int i = 0; i < ALIEN_NUM_ROWS; i++) {
			for (int j = 0; j < ALIEN_NUM_COLS; j++) {
				Alien alien = aliens[i][j];
				if (Collision.collides(spaceship, alien)){
					System.out.println("Aliens an Board!");
					return true;
				}
				if (alien.isAlive()){
					allDead = false;
				}
			}
		}
		if (Collision.collides(spaceship, laser)){
			GameGlobals.getInstance().setLives(GameGlobals.getInstance().getLives() - 1);
			GameGlobals.getInstance().setCombo(0);
			alienLaser.setAliveState(AliveState.DEAD);
		}
		if (allDead){
			System.out.println("Aliens eliminiert!");
			GameGlobals.getInstance().setWon(true);
			return true;
		}
		if (GameGlobals.getInstance().getLives() == 0){
			System.out.println("Sie haben keine Leben mehr!");
			return true;
		}
		return false;
	}

	public void killAliens(Laser laser) {
		for (int i = 0; i < ALIEN_NUM_ROWS; i++) {
			for (int j = 0; j < ALIEN_NUM_COLS; j++) {
				Alien alien = aliens[i][j];
				if (Collision.collides(alien, laser)) {
					laser.setAliveState(AliveState.DEAD);
					alien.setAliveState(AliveState.DEAD);
					GameGlobals.getInstance().setCombo(GameGlobals.getInstance().getCombo() + 1);
					GameGlobals.getInstance().setScore(GameGlobals.getInstance().getScore() + (100 * GameGlobals.getInstance().getCombo()));
					System.out.println("Alienabschuss!");
				}
			}

		}
	}
	public void alienShoot(){
		boolean lastRowDead = true;
		alienLaser.setSpeed(6);
		for (int i = 0; i < ALIEN_NUM_ROWS; i++) {
			for (int j = 0; j < ALIEN_NUM_COLS; j++) {
				if (aliens[lastRow][j].isAlive()) {
					lastRowDead = false;
				}
			}
		}
		
		if (lastRowDead && lastRow != 0){
			lastRow --;					
		}
		for (int j = 0; j < ALIEN_NUM_COLS; j++) { 
			Alien alien = aliens[lastRow][j];
			Random random = new Random();
			int randomShoot = random.nextInt(100);
			if (!alienLaser.isAlive() && alien.isAlive()){
				if(randomShoot == 0){
					alienLaser.getPosition().setX(alien.getPosition().getX() + 10);
					alienLaser.getPosition().setY(alien.getPosition().getY());
					alienLaser.setAliveState(AliveState.ALIVE);
				}
			}
		}
		if (alienLaser.isAlive()){
			alienLaser.getPosition().setY(alienLaser.getPosition().getY() - alienLaser.getSpeed());
			alienLaser.draw();
		}
		if (alienLaser.getPosition().getY() < 0){
			alienLaser.setAliveState(AliveState.DEAD);
		}
	}

	@Override
	public void userInput() {
	}

	public Animation getAnimation() {
		return animation;
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

	public Alien[][] getAliens() {
		return aliens;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public Point getPosition() {
		return position;
	}

	public Laser getAlienLaser() {
		return alienLaser;
	}



}
