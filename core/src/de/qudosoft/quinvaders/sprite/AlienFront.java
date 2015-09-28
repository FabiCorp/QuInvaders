package de.qudosoft.quinvaders.sprite;

import de.qudosoft.quinvaders.animation.Animation;
import de.qudosoft.quinvaders.util.GameGlobals;

public class AlienFront extends Alien {

	public AlienFront() {
	}

	@Override
	protected Animation createAnimation() {
		Animation animation = new Animation(0.5f, GameGlobals.getInstance().getTextureFactory().createTexture("enemy01_a.png"), GameGlobals.getInstance().getTextureFactory().createTexture("enemy01_b.png"));
		return animation;

	}

}
