package com.game.data;

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
	
	public boolean isDead(Status obj) {
		boolean isDead;
		
		return isDead;
	}
	
	

}
