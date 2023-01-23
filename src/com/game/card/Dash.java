package com.game.card;

import com.game.character.Character;
import com.game.enemy.Enemy;
import com.game.stage.Battle;

public class Dash extends AttackCard {
	
	private int guard = 5;
	
	public Dash() {}
	
	public Dash(int idx, String name, int cost, int damage, String rarity, String owner) {
		super(idx, name, cost, damage, rarity, owner);
	}
	
	public int getGuard() {
		return guard;
	}



	public void setGuard(int guard) {
		this.guard = guard;
	}

	public AttackCard getCard() {
		int idx = 7;
		String name = "돌진";
		int cost = 2;
		int damage = 10;
		String rarity = "normal";
		String owner = "A";
		
		AttackCard dash = new Dash(idx, name, cost, damage, rarity, owner);
		dash.setDef("피해를 " + dash.getDamage() + "줍니다. 방어도를 " +
					getGuard() + "얻습니다.");
		
		return dash;
	}
	
	@Override
	public boolean useCard(Character player, Enemy enemy) {
		if(Battle.nowEnergy >= this.getCost()) {
			Battle.nowEnergy -= this.getCost();
			int damage =(int) ((this.getDamage() + player.getStatus().getStrength())
					* (player.getStatus().isWeak()? 0.75 : 1));
			player.getStatus().addBlock(this.guard);
			enemy.getStatus().getDamage(damage);			
			
			return true;
		} else {
			System.out.println("에너지가 없어 사용할 수 없습니다.");
			
			return false;
		}
	}

}
