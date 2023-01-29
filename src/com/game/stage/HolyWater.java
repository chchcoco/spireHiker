package com.game.stage;

import java.util.Scanner;
import com.game.character.Character;

public class HolyWater implements GameStage {
	
	Scanner sc = new Scanner(System.in);
	
	public void entry(Character player) {
		System.out.println("\n신성한 기운이 느껴지는 물이 벽 틈사이로 흘러 고여있다.");
		System.out.println("손을 모아 경건한 마음으로 물을 떠서 마시자, 신기할 정도로 활력이 되살아났다.");
		System.out.println("체력이 전부 회복되었다.");
		player.getStatus().setHp(player.getStatus().getMaxHp());
		System.out.println("다음 층으로 넘어갑니다. 아무 키나 입력하세요");
		String next = sc.nextLine();
		next = null;
	}

}
