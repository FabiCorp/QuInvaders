package de.qudosoft.quinvaders.sprite;

import de.qudosoft.quinvaders.animation.Animation;
import de.qudosoft.quinvaders.util.GameGlobals;
import de.qudosoft.quinvaders.util.Point;
import de.qudosoft.quinvaders.util.TextureFactory;

public class Alien extends Sprite {

	public Alien(TextureFactory textureFactory) {
		super(textureFactory);
		
		setPosition(new Point(200, 200));
		setDirection(1);
		setSpeed(25);
		setSize(35);
		setRechtesEnde(600);

		setAnimation(createAnimation());
		getAnimation().start();
		setBoundingBoxDelta(2);
	}

	private Animation createAnimation() {
		Animation animation = new Animation(0.5f, textureFactory.createTexture("enemy01_a.png"), textureFactory.createTexture("enemy01_b.png"));
		return animation;

	}
	
	@Override
	public void modelUpdate(float deltaTime) {
		super.modelUpdate(deltaTime);
		if (getAnimation().isChangeAnimation()) {
			getPosition().setX(getPosition().getX() + getSpeed() * getDirection());
			if (getPosition().getX() >= getRechtesEnde()
					|| getPosition().getX() <= GameGlobals.getInstance().getLinkesende()) {
				setDirection(getDirection() * -1);

			}
			getAnimation().setChangeAnimation(false);
		}

	}

}
