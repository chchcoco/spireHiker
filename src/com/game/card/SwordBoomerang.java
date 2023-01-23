package com.game.card;

import com.game.character.Character;
import com.game.enemy.Enemy;
import com.game.stage.Battle;

public class SwordBoomerang extends AttackCard {
	
	private int atkNum = 3;
	
	public SwordBoomerang() {}
	
	public SwordBoomerang(int idx, String name, int cost, int damage, String rarity, String owner) {
		super(idx, name, cost, damage, rarity, owner);
	}
	
	public AttackCard getCard() {
		int idx = 13;
		String name = "부메랑 칼날";
		int cost = 1;
		int damage = 3;
		String rarity = "normal";
		String owner = "A";
		
		AttackCard swordBoomerang = new SwordBoomerang(idx, name, cost, damage, rarity, owner);
		swordBoomerang.setDef("피해 " + swordBoomerang.getDamage() + "를 " + atkNum + "번 줍니다.");
		
		return swordBoomerang;
	}
	
	@Override
	public boolean useCard(Character player, Enemy enemy) {
		if(Battle.nowEnergy >= this.getCost()) {
			Battle.nowEnergy -= this.getCost();
			int damage =(int) (((this.getDamage() + player.getStatus().getStrength()) * this.atkNum)
					* (player.getStatus().isWeak()? 0.75 : 1));
			enemy.getStatus().getDamage(damage);			
			
			return true;
		} else {
			System.out.println("에너지가 없어 사용할 수 없습니다.");
			
			return false;
		}
	}

}
