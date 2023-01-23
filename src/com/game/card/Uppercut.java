package com.game.card;

import com.game.character.Character;
import com.game.enemy.Enemy;
import com.game.stage.Battle;

public class Uppercut extends AttackCard {
	
	public int debuff = 1;
	
	public Uppercut() {}
	
	public Uppercut(int idx, String name, int cost, int damage, String rarity, String owner) {
		super(idx, name, cost, damage, rarity, owner);
	}
	
	public AttackCard getCard() {
		int idx = 12;
		String name = "어퍼컷";
		int cost = 2;
		int damage = 13;
		String rarity = "rare";
		String owner = "A";
		
		AttackCard uppercut = new Uppercut(idx, name, cost, damage, rarity, owner);
		uppercut.setDef("피해를 " + uppercut.getDamage() + "줍니다.\n약화와 취약을 1 부여합니다.");
		
		return uppercut;
	}
	
	@Override
	public boolean useCard(Character player, Enemy enemy) {
		if(Battle.nowEnergy >= this.getCost()) {
			Battle.nowEnergy -= this.getCost();
			int damage =(int) ((this.getDamage() + player.getStatus().getStrength())
					* (player.getStatus().isWeak()? 0.75 : 1));
			enemy.getStatus().getDamage(damage);			
			enemy.getStatus().addVulnerable(debuff);
			enemy.getStatus().addWeak(debuff);
			
			
			return true;
		} else {
			System.out.println("에너지가 없어 사용할 수 없습니다.");
			
			return false;
		}
	}

}
