package com.game.play;

import com.game.character.Character;

/* class : Ending
 * comment
 * : 엔딩을 출력하는 메소드
 * 결과 출력과 함께, 지금까지 얻은 카드들을 출력한다.
 * */
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
		System.exit(0);}
	
	public void badEnd(Character player) {
		System.out.println("패배...");
		System.out.println("얻은 카드");
		for(int i = 0; i < player.getDeckCnt(); i++) {
			if(player.getDeck()[i] == null) {
				break;
			}
			System.out.println(player.getDeck()[i].printText());
		}
		System.exit(0);
	}
}
