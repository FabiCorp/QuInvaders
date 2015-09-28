package de.qudosoft.quinvaders.sprite;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

import de.qudosoft.quinvaders.util.TextureFactory;

public class AlienFrontTest {

	@Test(enabled=false)
	public void testAlienAnimationNotNull() {

		TextureFactory mockedTextureFactory = Mockito.mock(TextureFactory.class);
		Mockito.when(mockedTextureFactory.createTexture(Mockito.anyString())).thenReturn(null);
		
		AlienFront alien = new AlienFront();
		
		Assert.assertNotNull(alien.getAnimation());
	}
	
	@Test(enabled=false)
	public void testAlienAnimationStarted() {
		
		Texture texture = null;
		
		try {
			URL defaultImage = getClass().getResource("/enemy01_a.png");
			File imageFile = new File(defaultImage.toURI());
			FileHandle filehandle = new FileHandle(imageFile);
			texture = new Texture(filehandle);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		TextureFactory mockedTextureFactory = Mockito.mock(TextureFactory.class);
		Mockito.when(mockedTextureFactory.createTexture(Mockito.anyString())).thenReturn(texture);
		
		AlienFront alien = new AlienFront();
		
		Assert.assertTrue(alien.getAnimation().isRunning());
	}
	
}
