package de.qudosoft.quinvaders.util;

import com.badlogic.gdx.graphics.Texture;

public class TextureFactory {
	
	public Texture createTexture(String fileName) {
		return new Texture(fileName);
	}
}
