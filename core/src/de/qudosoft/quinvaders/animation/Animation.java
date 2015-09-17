package de.qudosoft.quinvaders.animation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;

public class Animation {

	// Einzelbilder der Animation
	private List<Texture> images; 

	private int currentImageIndex;

	// Zeit zwischen zwei Einzelbildern
	private float delay;

	// Seit dem letzten Bildwechsel verstrichene Zeit
	private float time;

	private boolean running;

	public Animation(float delay, Texture... textures) {

		this.delay = delay;
		
		images = new ArrayList<Texture>();
		images.addAll(Arrays.asList(textures));

		running = false; 
	}

	public void start() {
		currentImageIndex = 0;
		time = 0;
		running = true;
	}

	public void stop() {
		running = false;
	}

	// abhängig von Zeit model updaten, ggfs Bild weiterschalten
	public void updateModel(float deltaTime) {
		// :-)

		time += deltaTime;
		System.out.println("delay: " + delay + "time: " + time + " deltaTime : " + deltaTime);
		
		if (time >= delay){
			if (currentImageIndex == images.size()-1){
				currentImageIndex = 0;
			}
			else {
				currentImageIndex++;
			}
			time = 0;

		}
	}

	public Texture getCurrentImage() {
		Texture currentImage = images.get(currentImageIndex);
		return currentImage;
	}


}
