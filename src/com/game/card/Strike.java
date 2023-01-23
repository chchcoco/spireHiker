package com.game.card;

import com.game.character.Character;
import com.game.enemy.Enemy;
import com.game.stage.Battle;

public class Strike extends AttackCard{
	
	public Strike() {}
	
	public Strike(int idx, String name, int cost, int damage, String rarity, String owner) {
		super(idx, name, cost, damage, rarity, owner);
	}
	
	public AttackCard getCard() {
		int idx = 1;
		String name = "타격";
		int cost = 1;
		int damage = 6;
		String rarity = "normal";
		String owner = "A";
		
		AttackCard strike = new Strike(idx, name, cost, damage, rarity, owner);
		strike.setDef("피해를 " + strike.getDamage() + " 줍니다.");
		
		return strike;
	}
	
	@Override
	public boolean useCard(Character player, Enemy enemy) {
		if(Battle.nowEnergy >= this.getCost()) {
			Battle.nowEnergy -= this.getCost();
			int damage =(int) ((this.getDamage() + player.getStatus().getStrength())
					* (player.getStatus().isWeak()? 0.75 : 1));
			enemy.getStatus().getDamage(damage);			
			
			return true;
		} else {
			System.out.println("에너지가 없어 사용할 수 없습니다.");
			
			return false;
		}
	}
	
}