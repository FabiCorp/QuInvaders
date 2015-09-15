package de.qudosoft.quinvaders.screen;


public abstract class Screen implements GameEntity {
	
	public Screen() {
	}
	
	public abstract void modelUpdate(float deltaTime);
	
	public abstract void draw();

}
