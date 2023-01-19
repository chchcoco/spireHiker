package com.game.card;

import com.game.character.Character;

public class CardListOfA {

	public Card[][] characterChoose(Character character) {
		if ("A".equals(character.getName())) {
			return getCardListA();
		} else {
			System.out.println("심각한오류가 발생했습니다. 게임을 다시 작동해주세요.");
			return new Card[][]{{new Strike(), new Defence()},{},{}};
		}
	}

	public Card[][] getCardListA() {
		Card[][] cardList = new Card[3][];
		cardList[0] = new Card[8];
		cardList[1] = new Card[5];
		cardList[2] = new Card[2];

		cardList[0][0] = new Strike().getCard();
		cardList[0][1] = new Defence().getCard();
		cardList[0][2] = new Bash().getCard();
		cardList[1][0] = new Bloodletting().getCard();
		cardList[2][0] = new Bludgeon().getCard();
		cardList[0][3] = new BodySlam().getCard();
		cardList[0][4] = new Dash().getCard();
		cardList[1][1] = new FlameBarrier().getCard();
		cardList[0][5] = new HeavyBlade().getCard();
		cardList[0][2] = new Hemokinesis().getCard();
		cardList[2][1] = new Impervious().getCard();
		cardList[1][3] = new Inflame().getCard();
		cardList[0][6] = new ShrugItOff().getCard();
		cardList[0][7] = new SwordBoomerang().getCard();
		cardList[1][4] = new Uppercut().getCard();

		return cardList;
	}

}
