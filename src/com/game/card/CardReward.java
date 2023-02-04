package com.game.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.game.character.Character;

public class CardReward {

	Scanner sc = new Scanner(System.in);

	/**
	 * 카드의 희귀도에 따라 다른 확률을 적용하여 난수로 값을 생성해 랜덤 카드를 하나 리턴하는 메소드;
	 * 
	 */
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
		System.out.println("\n!! 카드보상 !!");
		int rewardsLength = 3;
//		Card[] rewards = new Card[3];
		List<Card> rewards = new ArrayList<>();
		
		for (int i = 0; i < rewardsLength; i++) {
			boolean reroll = false;
//			rewards[i] = randomCard(player);
			rewards.add(randomCard(player));
			for(int j = 0; j < rewards.size(); j++) {
				if(rewards.get(i).printText() == rewards.get(j).printText()) {
					reroll = true;
				}
			}
			if(reroll) {
				i--;
			}
		}
		
		while (true) {
			for (int i = 0; i < rewards.size(); i++) {
				if (rewards.get(i) == null) {
					rewards.set(i, new Strike());
					rewards.set(i, randomCard(player));
				}
				System.out.println(i + ".) " + rewards.get(i).printText());
			}
			System.out.println("9.) 보상을 포기합니다.");
			System.out.print("카드보상을 선택하여 주세요 : ");

			String inputStr = sc.nextLine();
			int input;
			if (inputStr.charAt(0) >= '0' && inputStr.charAt(0) <= '9') {
				input = (int) inputStr.charAt(0) - 48;
				if (input == 9) {
					return null;
				} else if (input >= 0 && input < rewards.size()) {
					return rewards.get(input);
				} else {
					System.out.println("다시 선택해주세요.");
				}
			} else {
				System.out.println("허용되지 않은 입력입니다. 재입력 바랍니다.");
			}

		}
	}

	public Card epicCardReward(Character player) {
		System.out.println("\n!!!!희귀카드 보상!!!!");
		Card[][] rewards = player.getCardList();
		while (true) {
			for (int i = 0; i < rewards[2].length; i++) {
				System.out.println(i + ".) " + rewards[2][i].printText());
			}
			System.out.println("9.) 보상을 포기합니다.");
			System.out.print("카드보상을 선택하여 주세요 : ");

			String inputStr = sc.nextLine();
			int input;
			if (inputStr.charAt(0) >= '0' && inputStr.charAt(0) <= '9') {
				input = (int) inputStr.charAt(0) - 48;
				if (input == 9) {
					return null;
				} else if (input >= 0 && input < rewards[2].length) {
					return rewards[2][input];
				} else {
					System.out.println("다시 선택해주세요.");
				}
			} else {
				System.out.println("허용되지 않은 입력입니다. 재입력 바랍니다.");
			}
		}
	}

}
