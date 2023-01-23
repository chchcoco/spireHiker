package com.game.stage;

import java.util.Scanner;
import com.game.card.Card;
import com.game.character.Character;
import com.game.play.Ending;

public class CardCopyEvent implements GameStage {
	
	Scanner sc = new Scanner(System.in);
	
	public void entry(Character player) {
		Card[] deck = player.getDeck();
		System.out.println("신비로운 재단이다. 카드를 1장 골라 놓으면 그 카드가 2장이 된다.");
		System.out.println("어떤 카드를 고를까?");
		for(int i = 0; i < deck.length; i++) {
			System.out.println((i+1) + ".) " + deck[i].printText());
		} System.out.println("0.) 그냥 지나친다.");
		
		int input = sc.nextInt();
		if(input == 0) {
			System.out.println("역시 그냥 지나치기로 했다.");
		} else if (input <= deck.length && input > 0) {
			player.addCard(deck[input-1]);
			System.out.println("선택한 카드가 하나 더 늘었다.");
		} else {
			System.out.println("재단을 훼손했다. 좋지 않은 무언가가 나를 짓눌렀다.");
			System.out.println("피로를 느껴서 체력이 3 줄었다.");
			player.getStatus().getDamage(3);
			if(!player.getStatus().isLive()) {
				new Ending().badEnd(player);
			}
		}
	}
}
