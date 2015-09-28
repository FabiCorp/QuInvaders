package de.qudosoft.quinvaders.animation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;

public class Animation {

	private List<Texture> images; 

	private int currentImageIndex;

	private float delay;

	private float time;

	private boolean running;

	private boolean animationChanged;

	public Animation(float delay, Texture... textures) {

		this.delay = delay;

		images = new ArrayList<Texture>();
		images.addAll(Arrays.asList(textures));

		running = false;
		animationChanged = false;
	}

	public void start() {
		currentImageIndex = 0;
		time = 0;
		running = true;
	}

	public void stop() {
		running = false;
	}

	public void modelUpdate(float deltaTime) {
		time += deltaTime;

		if (time >= delay){
			if (currentImageIndex == images.size()-1){
				currentImageIndex = 0;
			}
			else {
				currentImageIndex++;
			}
			time = 0;
			animationChanged = true;
		}
	}

	public Texture getCurrentImage() {
		Texture currentImage = images.get(currentImageIndex);
		return currentImage;
	}

	public boolean isChangeAnimation() {
		return animationChanged;
	}

	public void setChangeAnimation(boolean changeAnimation) {
		this.animationChanged = changeAnimation;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

}
