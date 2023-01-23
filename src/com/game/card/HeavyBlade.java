package com.game.card;

import com.game.character.Character;
import com.game.enemy.Enemy;
import com.game.stage.Battle;

public class HeavyBlade extends AttackCard {
	
	public HeavyBlade() {}
	
	public HeavyBlade(int idx, String name, int cost, int damage, String rarity, String owner) {
		super(idx, name, cost, damage, rarity, owner);
	}
	
	public AttackCard getCard() {
		int idx = 5;
		String name = "대검";
		int cost = 2;
		int damage = 14;
		String rarity = "normal";
		String owner = "A";
		
		AttackCard heavyBlade = new HeavyBlade(idx, name, cost, damage, rarity, owner);
		heavyBlade.setDef("피해를 " + heavyBlade.getDamage() + " 줍니다. 힘의 효과가 4배로 적용됩니다.");
		
		return heavyBlade;
	}
	
	@Override
	public boolean useCard(Character player, Enemy enemy) {
		if(Battle.nowEnergy >= this.getCost()) {
			Battle.nowEnergy -= this.getCost();
			int damage =(int) ((this.getDamage() + player.getStatus().getStrength() * 4)
					* (player.getStatus().isWeak()? 0.75 : 1));
			enemy.getStatus().getDamage(damage);			
			
			return true;
		} else {
			System.out.println("에너지가 없어 사용할 수 없습니다.");
			
			return false;
		}
	}

}


