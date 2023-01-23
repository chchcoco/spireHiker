package com.game.card;

import com.game.character.Character;
import com.game.enemy.Enemy;
import com.game.stage.Battle;

public class Bludgeon extends AttackCard {
	
	public Bludgeon() {}
	
	public Bludgeon(int idx, String name, int cost, int damage, String rarity, String owner) {
		super(idx, name, cost, damage, rarity, owner);
	}
	
	public AttackCard getCard() {
		int idx = 14;
		String name = "몽둥이질";
		int cost = 3;
		int damage = 36;
		String rarity = "Epic";
		String owner = "A";
		
		AttackCard bludgeon = new Bludgeon(idx, name, cost, damage, rarity, owner);
		bludgeon.setDef("피해를 " + bludgeon.getDamage() + "줍니다.");
		
		return bludgeon;
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
