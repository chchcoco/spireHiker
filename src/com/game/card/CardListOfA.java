package com.game.card;

import com.game.character.Character;

public class CardListOfA {

	public void characterChoose(Character character) {
		if (character.getName().equals("A")) {
			getCardListA();
		} 
	}

	public Card[] getCardListA() {
		Card[] cardList = new Card[15];

		cardList[0] = new Strike().getCard();
		cardList[1] = new Defence().getCard();
		cardList[2] = new Bash().getCard();
		cardList[3] = new Bloodletting().getCard();
		cardList[4] = new Bludgeon().getCard();
		cardList[5] = new BodySlam().getCard();
		cardList[6] = new Dash().getCard();
		cardList[7] = new FlameBarrier().getCard();
		cardList[8] = new HeavyBlade().getCard();
		cardList[9] = new Hemokinesis().getCard();
		cardList[10] = new Impervious().getCard();
		cardList[11] = new Inflame().getCard();
		cardList[12] = new ShrugItOff().getCard();
		cardList[13] = new SwordBoomerang().getCard();
		cardList[14] = new Uppercut().getCard();

		return cardList;
	}

}
