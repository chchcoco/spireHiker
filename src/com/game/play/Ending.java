package com.game.play;

import com.game.character.Character;

public class Ending {
	public void goodEnd(Character player) {
		System.out.println("승리!");
		System.out.println("얻은 카드");
		for(int i = 0; i < player.getDeckCnt(); i++) {
			if(player.getDeck()[i] == null) {
				break;
			}
			System.out.println(player.getDeck()[i].printText());
		}
		System.out.println("수고하셨습니다");
		return;
	}
	
	public void badEnd(Character player) {
		System.out.println("패배...");
		System.out.println("얻은 카드");
		for(int i = 0; i < player.getDeckCnt(); i++) {
			if(player.getDeck()[i] == null) {
				break;
			}
			System.out.println(player.getDeck()[i].printText());
		}
		return;
	}
}
