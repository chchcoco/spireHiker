package com.game.character;

import com.game.card.Card;
import com.game.data.Status;

public class Character {
	
	private String name;
	private int maxHp;
	private String def;
	private Card[] deck = new Card[50];
	private Card[][] cardList = new Card[3][];
	private int deckCnt = 0;
	private Status status;
	private int maxEnergy = 3;
	
	public Character(String name, int maxHp, String def) {
		super();
		this.name = name;
		this.maxHp = maxHp;
		this.def = def;
		this.status = new Status(this.maxHp);
	}

	public void characterEffect() {}
	
	public void startingDeck() {}

	public String getName() {
		return name;
	}

	public int getMaxhp() {
		return maxHp;
	}

	public String getDef() {
		return def;
	}

	public Card[] getDeck() {
		return deck;
	}

	public Card[][] getCardList(){
		return cardList;
	}
	
	public int getDeckCnt() {
		return deckCnt;
	}

	public Status getStatus(){
		return status;
	}
	
	public int getMaxEnergy() {
		return maxEnergy;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMaxhp(int maxHp) {
		this.maxHp = maxHp;
	}

	public void setDef(String def) {
		this.def = def;
	}

	public void setDeck(Card[] deck) {
		this.deck = deck;
	}

	public void setCardList(Card[][] cardList){
		this.cardList = cardList;
	}

	public void setStatus(Status status){
		this.status = status;
	}
	
	public void setMaxEnergy(int maxEnergy) {
		this.maxEnergy = maxEnergy;
	}
	
	public void addCard(Card card) {
		for(int i = 0; i < deck.length; i++) {
			if(deck[i] == null) {
				deckCnt = i;
				break;
			}
		}
		deck[deckCnt] = card;
	}

	public void characterEfferct() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
