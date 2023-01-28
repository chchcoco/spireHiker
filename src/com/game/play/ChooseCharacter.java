package com.game.play;

import java.util.Scanner;

import com.game.GameInformation;
import com.game.card.CardListOfA;
import com.game.character.Character;
import com.game.character.CharacterList;

public class ChooseCharacter implements GameInformation {
	Scanner sc = new Scanner(System.in);
	Character[] character;

	/*
	 * main()에서 실행하는 메소드 캐릭터를 고르고 고른 캐릭터를 매개변수로 hiking()를 실행시킨다.
	 */
	public void choose() {
		System.out.println("===============Hiking Spire==================");

		while (true) {
			character = new CharacterList().getCharacterList();
			for (int i = 0; i < character.length; i++) {
				System.out.println("1)" + character[i].getName());
				System.out.println(character[i].getDef());
			}
			System.out.print("캐릭터를 선택해주세요 : ");

			String inputStr = sc.nextLine();
			int input;
			if (inputStr.charAt(0) >= '0' && inputStr.charAt(0) <= '9') {
				input = (int) inputStr.charAt(0) - 48;
				if (input > 0 && input <= GameInformation.CHARACTER_COUNT) {
					Character player = character[input - 1];
					player.setCardList(new CardListOfA().characterChoose(player));

					HikingSpire gameStart = new HikingSpire();

					gameStart.hiking(player);
				} else {
					System.out.println("없는 번호입니다. 골라주세요.");
				}
			} else {
				System.out.println("허용되지 않은 입력입니다. 캐릭터의 번호를 재입력 하세요.");
			}
		}
	}

}
