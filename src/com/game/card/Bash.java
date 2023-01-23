package com.game.card;

import com.game.character.Character;
import com.game.enemy.Enemy;
import com.game.stage.Battle;

public class Bash extends AttackCard {
	
	int vulnerable = 2;
	
	public Bash() {}
	
	public Bash(int idx, String name, int cost, int damage, String rarity, String owner) {
		super(idx, name, cost, damage, rarity, owner);
	}
	
	public AttackCard getCard() {
		int idx = 3;
		String name = "강타";
		int cost = 2;
		int damage = 10;
		String rarity = "normal";
		String owner = "A";
		
		AttackCard bash = new Bash(idx, name, cost, damage, rarity, owner);
		bash.setDef("피해를 " + bash.getDamage() + "줍니다. 취약을" + this.vulnerable + "부여합니다.");
		
		return bash;
	}
	
	@Override
	public boolean useCard(Character player, Enemy enemy) {
		if(Battle.nowEnergy >= this.getCost()) {
			Battle.nowEnergy -= this.getCost();
			int damage =(int) ((this.getDamage() + player.getStatus().getStrength())
					* (player.getStatus().isWeak()? 0.75 : 1));
			enemy.getStatus().getDamage(damage);			
			enemy.getStatus().addVulnerable(this.vulnerable);
			
			return true;
		} else {
			System.out.println("에너지가 없어 사용할 수 없습니다.");
			
			return false;
		}
	}
}