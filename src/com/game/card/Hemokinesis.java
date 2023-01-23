package com.game.card;

import com.game.character.Character;
import com.game.enemy.Enemy;
import com.game.play.Ending;
import com.game.stage.Battle;

public class Hemokinesis extends AttackCard {
	
	private int costHp = 2;
	
	public Hemokinesis() {}
	
	public Hemokinesis(int idx, String name, int cost, int damage, String rarity, String owner) {
		super(idx, name, cost, damage, rarity, owner);
	}
	
	public AttackCard getCard() {
		int idx = 11;
		String name = "혈류";
		int cost = 1;
		int damage = 15;
		String rarity = "rare";
		String owner = "A";
		
		AttackCard hemokinesis = new Hemokinesis(idx, name, cost, damage, rarity, owner);
		hemokinesis.setDef("피해를 " + hemokinesis.getDamage() + "줍니다.\n체력을 " + this.costHp + " 잃습니다.");
		
		return hemokinesis;
	}
	
	@Override
	public boolean useCard(Character player, Enemy enemy) {
		if(Battle.nowEnergy >= this.getCost()) {
			Battle.nowEnergy -= this.getCost();
			player.getStatus().getDamage(costHp);
			if(!player.getStatus().isLive()) {
				new Ending().badEnd(player);
			}
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
