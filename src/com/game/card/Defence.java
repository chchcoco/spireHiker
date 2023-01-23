package com.game.card;

import com.game.character.Character;
import com.game.enemy.Enemy;
import com.game.stage.Battle;

public class Defence extends SkillCard{
	
	public Defence() {}
	
	public Defence(int idx, String name, int cost, int guard, String rarity, String owner) {
		super(idx, name, cost, guard, rarity, owner);
	}
	
	public SkillCard getCard() {
		int idx = 2;
		String name = "수비";
		int cost = 1;
		int guard = 5;
		String rarity = "normal";
		String owner = "A";
		
		SkillCard defence = new Defence(idx, name, cost, guard, rarity, owner);
		defence.setDef("방어도를 " + defence.getGuard() + " 얻습니다.");
		
		return defence;
	}
	
	@Override
	public boolean useCard(Character player, Enemy enemy) {
		if(Battle.nowEnergy >= this.getCost()) {
			Battle.nowEnergy -= this.getCost();
			player.getStatus().addBlock(this.getGuard());
			
			return true;
		} else {
			System.out.println("에너지가 없어 사용할 수 없습니다.");
			
			return false;
		}
	}
}

