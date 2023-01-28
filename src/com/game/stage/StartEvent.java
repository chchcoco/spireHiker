package com.game.stage;

import java.util.Scanner;

import com.game.card.Card;
import com.game.card.CardReward;
import com.game.character.Character;

public class StartEvent implements GameStage {

	Scanner sc = new Scanner(System.in);
	String[] bonus = new String[3];

	public StartEvent() {
		bonus[0] = "카드 보상을 얻습니다.";
		bonus[1] = "최대 체력이 10% 증가합니다.";
		bonus[2] = "피해를 최대 체력의 20% 받고, 희귀 카드 보상을 얻습니다.";
	}

	@Override
	public void entry(Character player) {
		int random = (int) (Math.random() * bonus.length);
		while (true) {
			for (int i = 0; i < bonus.length; i++) {
				if (random == i) {
					continue;
				}
				System.out.println(i + ".)" + bonus[i]);
			}
			System.out.print("시작 보상을 선택하시오 : ");
			System.out.println((int)'0' + "   " + (int)'9');
			String inputStr = sc.nextLine();
			System.out.println((int)inputStr.charAt(0));
			int input;
			if (inputStr.charAt(0) >= '0' && inputStr.charAt(0) <= '9') {
				input = (int) inputStr.charAt(0) - 48;

				if (input == 0 && random != 0) {
					Card reward = new CardReward().getReward(player);
					if (reward != null) {
						player.addCard(reward);
					}
					break;
				} else if (input == 1 && random != 1) {
					int result = player.getStatus().getMaxHp();
					result = (int) (result * 1.1);
					player.getStatus().setMaxHp(result);
					break;
				} else if (input == 2 && random != 2) {
					// 데미지 20%
					player.getStatus().getDamage((int) (player.getStatus().getMaxHp() * 0.2));
					// 히히카드보상
					Card reward = new CardReward().epicCardReward(player);
					if (reward != null) {
						player.addCard(reward);
					}
					break;
				} else {
					System.out.println("다시 골라주세요");
				}
			} else {
				System.out.println("다시 입력해주세요");
			}
			System.out.println();

		}
	}

}