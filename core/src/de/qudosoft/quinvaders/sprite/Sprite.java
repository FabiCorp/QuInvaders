package de.qudosoft.quinvaders.sprite;

import java.awt.geom.Rectangle2D;

import com.badlogic.gdx.graphics.Texture;

import de.qudosoft.quinvaders.animation.Animation;
import de.qudosoft.quinvaders.screen.GameEntity;
import de.qudosoft.quinvaders.util.Point;
import de.qudosoft.quinvaders.util.ResizeDrawUtil;
import de.qudosoft.quinvaders.util.TextureFactory;

public class Sprite implements GameEntity {

	protected TextureFactory textureFactory;

	private Point position;

	private Texture picture;

	private int direction; // +1 or -1

	private float speed;

	private Animation animation;

	private float size;

	private float rechtesEnde;

	private Rectangle2D.Float boundingBox;

	private int boundingBoxDelta;

	private AliveState aliveState;

	public boolean isAlive() {
		return aliveState == AliveState.ALIVE;
	}

	public Sprite(TextureFactory textureFactory) {
		this.textureFactory = textureFactory;
		aliveState = AliveState.ALIVE;
		position   = new Point(0, 0);
		boundingBox = new Rectangle2D.Float();
	}

	@Override
	public void userInput() {
		// empty
	}

	@Override
	public void modelUpdate(float deltaTime) {

		if (animation != null) {
			animation.updateModel(deltaTime);
		}

	}

	@Override
	public void draw() {
		ResizeDrawUtil.resizeTextureDraw(getSize(), getPicture(), getPosition().getX(), getPosition().getY());
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Texture getPicture() {

		if (animation != null) {
			return animation.getCurrentImage();
		} else {

			return picture;
		}
	}

	public void setPicture(Texture picture) {
		this.picture = picture;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public Animation getAnimation() {
		return animation;
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public float getRechtesEnde() {
		return rechtesEnde;
	}

	public void setRechtesEnde(float rechtesEnde) {
		this.rechtesEnde = rechtesEnde;
	}

	public Rectangle2D.Float getBoundingBox() {

		boundingBox.setRect(getPosition().getX() + boundingBoxDelta,
				getPosition().getY() + getSize() + boundingBoxDelta, getSize() - boundingBoxDelta,
				getSize() * getPicture().getHeight() / getPicture().getWidth() - boundingBoxDelta);

		return boundingBox;
	}

	public void setBoundingBox(Rectangle2D.Float boundingBox) {
		this.boundingBox = boundingBox;
	}

	public int getBoundingBoxDelta() {
		return boundingBoxDelta;
	}

	public void setBoundingBoxDelta(int boundingBoxDelta) {
		this.boundingBoxDelta = boundingBoxDelta;
	}

	public AliveState getAliveState() {
		return aliveState;
	}

	public void setAliveState(AliveState aliveState) {
		this.aliveState = aliveState;
	}

}
