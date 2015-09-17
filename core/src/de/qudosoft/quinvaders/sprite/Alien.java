package de.qudosoft.quinvaders.sprite;

import com.badlogic.gdx.graphics.Texture;

import de.qudosoft.quinvaders.animation.Animation;
import de.qudosoft.quinvaders.util.GameGlobals;
import de.qudosoft.quinvaders.util.Point;

public class Alien extends Sprite{

	public Alien() {

		setPosition(new Point(200, 200));
		setDirection(1);
		setSpeed(10);
		
		setAnimation(createAnimation());
		getAnimation().start();
	}

	private Animation createAnimation() {
		Animation animation = new Animation(0.5f, new Texture ("enemy01_a.png"), new Texture ("enemy01_b.png"));
		return animation;
		
	}

	@Override
	public void modelUpdate(float deltaTime) {
			
			super.modelUpdate(deltaTime);
			if (getAnimation().isChangeAnimation()){
				getPosition().setX(getPosition().getX() + getSpeed() * getDirection());
				if (getPosition().getX() >= GameGlobals.getInstance().getRechtesende()
						|| getPosition().getX() <= GameGlobals.getInstance().getLinkesende()){
					setDirection(getDirection() * -1);
				
				}
				getAnimation().setChangeAnimation(false);
			}

	}

}
