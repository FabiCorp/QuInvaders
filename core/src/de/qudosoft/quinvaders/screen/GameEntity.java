package de.qudosoft.quinvaders.screen;

public interface GameEntity {
	
	void userInput();
	
	void modelUpdate(float deltaTime);
	
	void draw();
}
