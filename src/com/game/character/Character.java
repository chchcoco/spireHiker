package com.game.character;

import com.game.card.Card;

public class Character {
	
	private String name;
	private int Maxhp;
	private String def;
	private Card[] deck = new Card[50];
	private int deckCnt = 0;
	
	
	public Character(String name, int maxhp, String def) {
		super();
		this.name = name;
		Maxhp = maxhp;
		this.def = def;
	}

	public void characterEffect() {}
	
	public void startingDeck() {}

	public String getName() {
		return name;
	}

	public int getMaxhp() {
		return Maxhp;
	}

	public String getDef() {
		return def;
	}

	public Card[] getDeck() {
		return deck;
	}
	
	public int getDeckCnt() {
		return deckCnt;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMaxhp(int maxhp) {
		Maxhp = maxhp;
	}

	public void setDef(String def) {
		this.def = def;
	}

	public void setDeck(Card[] deck) {
		this.deck = deck;
	};
	
	public void addCard(Card card) {
		for(int i = 0; i < deck.length; i++) {
			if(deck == null) {
				deckCnt = i;
				break;
			}
		}
		deck[deckCnt] = card;
	}
	
	
	
}
