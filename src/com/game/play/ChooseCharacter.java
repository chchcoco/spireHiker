package com.game.play;

import java.util.Scanner;

import com.game.GameInformation;
import com.game.card.CardListOfA;
import com.game.character.Character;
import com.game.character.CharacterList;

public class ChooseCharacter implements GameInformation {
	Scanner sc = new Scanner(System.in);
	Character[] character;

	public Character choose() {
		System.out.println("==============Hiking Spire==================");
		
		while (true) {
			character = new CharacterList().getCharacterList();
			for (int i = 0; i < character.length; i++) {
				System.out.println("1)" + character[i].getName());
				System.out.println(character[i].getDef());
			}
			System.out.print("캐릭터를 선택해주세요 : ");
			int input = sc.nextInt();
			if (input > 0 && input <= GameInformation.CHARACTER_COUNT) {
				Character player = character[input - 1];
				player.setCardList(new CardListOfA().characterChoose(player));
				player.startingDeck();
				
				HikingSpire gameStart = new HikingSpire();

				gameStart.hiking(player);
			} else {
				System.out.println("없는 번호입니다. 골라주세요.");
			}
		}
	}

	

}
