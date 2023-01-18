package com.game.character;

import com.game.card.*;

public class CharacterA extends Character {

	public CharacterA() {
		super("A", 80, "악마와 계약한 전사입니다.\n전투가 끝나면 체력을 6 회복합니다.");
		this.startingDeck();
	}
	
	@Override
	public Status characterEffect(Status status) {
		status.heal(6);
		return status;
	};
	
	@Override
	public void startingDeck() {
		for(int i = 1; i <= 4; i++) {
			this.addCard(new Strike().getCard());
		}
		for(int i = 1; i <= 4; i++) {
			this.addCard(new Defence().getCard());
		}
		this.addCard(new Bash().getCard());
		
	}

}
