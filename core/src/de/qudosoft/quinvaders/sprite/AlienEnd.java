package de.qudosoft.quinvaders.sprite;

import de.qudosoft.quinvaders.animation.Animation;
import de.qudosoft.quinvaders.util.GameGlobals;

public class AlienEnd extends Alien {

	public AlienEnd() {
	}

	@Override
	protected Animation createAnimation() {
		Animation animation = new Animation(0.5f, GameGlobals.getInstance().getTextureFactory().createTexture("enemy03_a.png"), GameGlobals.getInstance().getTextureFactory().createTexture("enemy03_b.png"));
		return animation;

	}

}
