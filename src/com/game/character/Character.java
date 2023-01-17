package com.game.character;

public abstract class Character {
	
	private String name;
	private int Maxhp;
	private String bonusDef;
	private Card[] deck = new Card[50];
	
	public abstract void characterEffect();
	
	public Card[] startingDeck(Card[] deck) {
		
	};
	
}
