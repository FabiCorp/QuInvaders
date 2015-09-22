package de.qudosoft.quinvaders.sprite;

import java.awt.geom.Rectangle2D;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import de.qudosoft.quinvaders.util.TextureFactory;

public class SpriteTest {

	@Test(enabled=false)
	public void testBoundingBox() {
		
		Sprite classUnderTest = new Sprite(new TextureFactory());
		
		classUnderTest.setBoundingBox(new Rectangle2D.Float(0, 0, 200, 200));
		
		Assert.assertNotNull(classUnderTest.getBoundingBox());
	}

	@DataProvider(name="rectangleValues")
	private Object[][] getRectangleValues() {
		
		return new Object[][] {
			{ new Rectangle2D.Float(0, 0, 200, 200), new Rectangle2D.Float(5, 5, 195, 195) },
			{ new Rectangle2D.Float(10, 10, 200, 200), new Rectangle2D.Float(15, 15, 195, 195) }
		};
		
	}
	
	@Test(dataProvider="rectangleValues", enabled=false)
	public void testBoundingBoxWithDelta(Rectangle2D.Float boundingBox, Rectangle2D.Float expectedBoundingBox) {
		
		Sprite classUnderTest = new Sprite(new TextureFactory());
		
		classUnderTest.setBoundingBox(boundingBox);
		classUnderTest.setBoundingBoxDelta(5);
		
		Assert.assertEquals(classUnderTest.getBoundingBox(), expectedBoundingBox);
	}
	
}
