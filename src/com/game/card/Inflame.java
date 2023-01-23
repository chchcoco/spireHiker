package com.game.card;

import com.game.character.Character;
import com.game.enemy.Enemy;
import com.game.stage.Battle;

public class Inflame extends SkillCard {
	
	public int strength = 1;
	
	public Inflame() {}
	
	public Inflame(int idx, String name, int cost, int guard, String rarity, String owner) {
		super(idx, name, cost, guard, rarity, owner);
	}
	
	public SkillCard getCard() {
		int idx = 10;
		String name = "발화";
		int cost = 1;
		int guard = 0;
		String rarity = "rare";
		String owner = "A";
		
		SkillCard inflame = new Inflame(idx, name, cost, guard, rarity, owner);
		inflame.setDef("힘을 " + this.strength + " 얻습니다");
		
		return inflame;
	}
	
	@Override
	public boolean useCard(Character player, Enemy enemy) {
		if(Battle.nowEnergy >= this.getCost()) {
			Battle.nowEnergy -= this.getCost();
			player.getStatus().addStrength(strength);
			
			return true;
		} else {
			System.out.println("에너지가 없어 사용할 수 없습니다.");
			
			return false;
		}
	}

}
