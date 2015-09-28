package de.qudosoft.quinvaders.sprite;

import de.qudosoft.quinvaders.animation.Animation;
import de.qudosoft.quinvaders.util.Point;

public abstract class Alien extends Sprite {

	public Alien() {
		
		setPosition(new Point(10, 400));
		setDirection(1);
		setSpeed(25);
		setSize(35);
		

		setAnimation(createAnimation());
		getAnimation().start();
		setBoundingBoxDelta(2);
	}

	protected abstract Animation createAnimation();
	
	@Override
	public void modelUpdate(float deltaTime) {
		super.modelUpdate(deltaTime);
		if (getAnimation().isChangeAnimation()) {
			getPosition().setX(getPosition().getX() + getSpeed() * getDirection());
			
			getAnimation().setChangeAnimation(false);
		}

	}
		

}
