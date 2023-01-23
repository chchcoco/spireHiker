package com.game.card;

import com.game.character.Character;
import com.game.enemy.Enemy;
import com.game.stage.Battle;

public class ShrugItOff extends SkillCard {
	
	public ShrugItOff() {}
	
	public ShrugItOff(int idx, String name, int cost, int guard, String rarity, String owner) {
		super(idx, name, cost, guard, rarity, owner);
	}
	
	public SkillCard getCard() {
		int idx = 6;
		String name = "흘려보내기";
		int cost = 1;
		int guard = 9;
		String rarity = "normal";
		String owner = "A";
		
		SkillCard shrugItOff = new ShrugItOff(idx, name, cost, guard, rarity, owner);
		shrugItOff.setDef("방어도를 " + shrugItOff.getGuard() + "얻습니다.  50%의 확률로 민첩을 1 획득합니다.");
		
		return shrugItOff;
	}
	
	@Override
	public boolean useCard(Character player, Enemy enemy) {
		if(Battle.nowEnergy >= this.getCost()) {
			Battle.nowEnergy -= this.getCost();
			player.getStatus().addBlock(this.getGuard());
			player.getStatus().addDexterity(((int)(Math.random()*2))== 0 ? 1 : 0);
			
			return true;
		} else {
			System.out.println("에너지가 없어 사용할 수 없습니다.");
			
			return false;
		}
	}
}

