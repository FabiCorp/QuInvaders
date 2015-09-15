package de.qudosoft.quinvaders.sprite;

import com.badlogic.gdx.graphics.Texture;

import de.qudosoft.quinvaders.util.GameGlobals;
import de.qudosoft.quinvaders.util.Point;

public class Alien extends Sprite{

	private boolean changePicture;

	private Texture texture1;

	private Texture texture2;

	private float delay; 

	public Alien() {
		texture1 = new Texture ("enemy01_a.png");
		texture2 = new Texture ("enemy01_b.png");
		delay = 0;

		setPicture(texture1);
		setPosition(new Point(200, 200));
		setDirection(1);
		setSpeed(10);
	}

	@Override
	public void modelUpdate(float deltaTime) {

		delay += deltaTime;
		
		if (delay >= 0.5) {
			getPosition().setX(getPosition().getX() + getSpeed() * getDirection());

			if (getPosition().getX() >= GameGlobals.getInstance().getRechtesende()
					|| getPosition().getX() <= GameGlobals.getInstance().getLinkesende()){
				setDirection(getDirection() * -1);

			}
			changePicture();
			delay = 0;
		}

	}

	private void changePicture() {
		if (changePicture){

			setPicture(texture1);
			changePicture = false;
		}
		else {
			setPicture(texture2);
			changePicture = true;
		}
	}


}
