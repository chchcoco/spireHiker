package com.game.card;

import com.game.character.Character;
import com.game.enemy.Enemy;
import com.game.play.Ending;
import com.game.stage.Battle;

public class Bloodletting extends SkillCard {
	
	int costHp = 3;
	
	public Bloodletting() {}
	
	public Bloodletting(int idx, String name, int cost, int guard, String rarity, String owner) {
		super(idx, name, cost, guard, rarity, owner);
	}
	
	public SkillCard getCard() {
		int idx = 8;
		String name = "사혈";
		int cost = 0;
		int guard = 0;
		String rarity = "rare";
		String owner = "A";
		
		SkillCard bloodletting = new Bloodletting(idx, name, cost, guard, rarity, owner);
		bloodletting.setDef("체력을 " + this.costHp + " 잃습니다. 에너지를 2 얻습니다.");
		
		return bloodletting;
	}

	@Override
	public boolean useCard(Character player, Enemy enemy) {
		if(Battle.nowEnergy >= this.getCost()) {
			Battle.nowEnergy -= this.getCost();
			player.getStatus().getDamage(this.costHp);
			if(!player.getStatus().isLive()) {
				new Ending().badEnd(player);
			}
			Battle.nowEnergy += 2;
			
			return true;
		} else {
			System.out.println("에너지가 없어 사용할 수 없습니다.");
			
			return false;
		}
	}

}
