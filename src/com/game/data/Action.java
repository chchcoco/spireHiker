package com.game.data;

import com.game.card.Card;
import com.game.character.Character;

public class Action {
	
	public void calcDamage() {}
	
	public Status getDamage(Status attack, Status defend) {
		
		return defend;
	}
	
	public Status getDamage(int damage, Status defend) {
		defend.setHp(defend.getHp() - damage);
		
		return defend;
	}
	
	public void heal() {}
	

	
	public boolean isDead(Status status) {
		boolean isDead = false;
		if(status.getHp() <= 0) {
			isDead = true;
		}
		return isDead;
	}
	

	
	
}
