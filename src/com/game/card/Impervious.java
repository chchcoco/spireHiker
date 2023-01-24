package com.game.card;

import com.game.character.Character;
import com.game.enemy.Enemy;
import com.game.stage.Battle;

public class Impervious extends SkillCard {
	
	public Impervious() {}
	
	public Impervious(int idx, String name, int cost, int guard, String rarity, String owner) {
		super(idx, name, cost, guard, rarity, owner);
	}
	
	public SkillCard getCard() {
		int idx = 15;
		String name = "무적";
		int cost = 2;
		int guard = 27;
		String rarity = "epic";
		String owner = "A";
		
		SkillCard impervious = new Impervious(idx, name, cost, guard, rarity, rarity);
		impervious.setDef("방어도를 " + this.getGuard() + "얻습니다.");
		
		return impervious;
	}

	@Override
	public boolean useCard(Character player, Enemy enemy) {
		if(Battle.nowEnergy >= this.getCost()) {
			Battle.nowEnergy -= this.getCost();
			player.getStatus().addBlock(this.getGuard() + player.getStatus().getDexterity());
			
			return true;
		} else {
			System.out.println("에너지가 없어 사용할 수 없습니다.");
			
			return false;
		}
	}

}
