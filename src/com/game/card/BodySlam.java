package com.game.card;

import com.game.character.Character;
import com.game.enemy.Enemy;
import com.game.stage.Battle;

public class BodySlam extends AttackCard{
	
	public BodySlam() {}
	
	public BodySlam(int idx, String name, int cost, int damage, String rarity, String owner) {
		super(idx, name, cost, damage, rarity, owner);
	}
	
	public AttackCard getCard() {
		int idx = 4;
		String name = "몸통박치기";
		int cost = 0;
		int damage = 0;
		String rarity = "normal";
		String owner = "A";
		
		AttackCard bodySlam = new BodySlam(idx, name, cost, damage, rarity, owner);
		bodySlam.setDef("피해를 현재 방어도 만큼 줍니다.");
		
		return bodySlam;
	}
	
	@Override
	public boolean useCard(Character player, Enemy enemy) {
		if(Battle.nowEnergy >= this.getCost()) {
			Battle.nowEnergy -= this.getCost();
			int damage =(int) ((player.getStatus().getBlock() + player.getStatus().getStrength())
					* (player.getStatus().isWeak()? 0.75 : 1));
			enemy.getStatus().getDamage(damage);			
			
			return true;
		} else {
			System.out.println("에너지가 없어 사용할 수 없습니다.");
			
			return false;
		}
	}
}
