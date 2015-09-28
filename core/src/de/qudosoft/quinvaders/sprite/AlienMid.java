package de.qudosoft.quinvaders.sprite;

import de.qudosoft.quinvaders.animation.Animation;
import de.qudosoft.quinvaders.util.GameGlobals;

public class AlienMid extends Alien {

	public AlienMid() {
	}

	@Override
	protected Animation createAnimation() {
		Animation animation = new Animation(0.5f, GameGlobals.getInstance().getTextureFactory().createTexture("enemy02_a.png"), GameGlobals.getInstance().getTextureFactory().createTexture("enemy02_b.png"));
		return animation;

	}
}
