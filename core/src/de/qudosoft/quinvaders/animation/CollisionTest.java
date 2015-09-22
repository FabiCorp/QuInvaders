package de.qudosoft.quinvaders.animation;

import java.awt.geom.Rectangle2D;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import de.qudosoft.quinvaders.sprite.Laser;
import de.qudosoft.quinvaders.sprite.Sprite;
import de.qudosoft.quinvaders.util.TextureFactory;


public class CollisionTest {

	@DataProvider(name="boundingBoxes")
	private Object[][] getBoundingBoxes() {
		
		return new Object[][] {
			
			{ new Rectangle2D.Float(0, 0, 500, 500), new Rectangle2D.Float(5, 5, 495, 495), true },
			{ new Rectangle2D.Float(0, 0, 500, 500), new Rectangle2D.Float(-500, -500, 10, 10), false },
			{ new Rectangle2D.Float(0, 0, 500, 500), new Rectangle2D.Float(-50, -50, 495, 495), true },
		};
		
	}
	
	
	@Test(dataProvider="boundingBoxes")
	public void testCollides(Rectangle2D.Float spriteBoundingBox, Rectangle2D.Float laserBoundingBox, boolean expectedResult) {
		
		TextureFactory mockedTextureFactory = Mockito.mock(TextureFactory.class);
		Mockito.when(mockedTextureFactory.createTexture(Mockito.anyString())).thenReturn(null);
		
		Sprite sprite = new Sprite(mockedTextureFactory);
		sprite.setBoundingBox(spriteBoundingBox);
		
		Laser laser = new Laser(mockedTextureFactory);
		laser.setBoundingBox(laserBoundingBox);
		
		boolean collides = Collision.collides(sprite, laser);
		Assert.assertEquals(collides, expectedResult);
	}
}