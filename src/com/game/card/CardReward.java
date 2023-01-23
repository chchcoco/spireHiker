package com.game.card;

import java.util.Scanner;
import com.game.character.Character;

public class CardReward {

	Scanner sc = new Scanner(System.in);

	/** 
	 * 카드의 희귀도에 따라 다른 확률을 적용하여
	 * 난수로 값을 생성해 랜덤 카드를 하나 리턴하는 메소드; 
	 * 
	 * */
	public Card randomCard(Character player) {
		Card reward;
		Card[][] pool = player.getCardList();
		int random = (int) (Math.random() * 100);
		if (random < 10) {
			random = (int) (Math.random() * pool[2].length);
			reward = pool[2][random];
		} else if (random < 40) {
			random = (int) (Math.random() * pool[1].length);
			reward = pool[1][random];
		} else {
			random = (int) (Math.random() * pool[0].length);
			reward = pool[0][random];
		}

		return reward;
	}

	public Card getReward(Character player) {
		System.out.println("!! 카드보상 !!");
		Card[] rewards = new Card[3];
		for (int i = 0; i < rewards.length; i++) {
			rewards[i] = randomCard(player);
		}

		while (true) {
			for (int i = 0; i < rewards.length; i++) {
				System.out.println(i + ". " + rewards[i].printText());
			}
			System.out.println("9) 보상을 포기합니다.");
			System.out.print("카드보상을 선택하여 주세요 : ");
			int input = sc.nextInt();

			if (input == 9) {
				return null;
			} else if (input >= 0 && input < rewards.length) {
				return rewards[input];
			} else {
				System.out.println("다시 선택해주세요.");
			}

		}
	}

	public Card EpicCardReward(Character player) {
		System.out.println("!!!!희귀카드 보상!!!!");
		Card[][] rewards = player.getCardList();
		while (true) {
			for (int i = 0; i < rewards[2].length; i++) {
				System.out.println(rewards[2][i].printText());
			}
			System.out.println("9) 보상을 포기합니다.");
			System.out.print("카드보상을 선택하여 주세요 : ");
			int input = sc.nextInt();

			if (input == 9) {
				return null;
			} else if (input >= 0 && input < rewards.length) {
				return rewards[2][input];
			} else {
				System.out.println("다시 선택해주세요.");
			}
		}
	}

}
