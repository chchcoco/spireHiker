package com.game.card;

import com.game.character.Character;
import com.game.enemy.Enemy;
import com.game.stage.Battle;

public class FlameBarrier extends SkillCard {
	
	public int weak = 2;
	
	public FlameBarrier() {}
	
	public FlameBarrier(int idx, String name, int cost, int guard, String rarity, String owner) {
		super(idx, name, cost, guard, rarity, owner);
	}
	
	public SkillCard getCard() {
		int idx = 9;
		String name = "화염 장벽";
		int cost = 2;
		int guard = 14;
		String rarity = "rare";
		String owner = "A";
		
		SkillCard flameBarrier = new FlameBarrier(idx, name, cost, guard, rarity, owner);
		flameBarrier.setDef("방어도를 " + flameBarrier.getGuard() + "얻습니다. 적에게 약화" + this.weak + "를 부여합니다.");
		
		return flameBarrier;
	}
	
	@Override
	public boolean useCard(Character player, Enemy enemy) {
		if(Battle.nowEnergy >= this.getCost()) {
			Battle.nowEnergy -= this.getCost();
			player.getStatus().addBlock(this.getGuard());
			enemy.getStatus().addWeak(this.weak);
			
			return true;
		} else {
			System.out.println("에너지가 없어 사용할 수 없습니다.");
			
			return false;
		}
	}

}
