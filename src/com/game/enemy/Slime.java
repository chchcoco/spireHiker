package com.game.enemy;

import com.game.character.Character;

public class Slime extends Enemy{
	
	private int pattern = (int)(Math.random() * 2 + 1);
	
	public Slime() {
		super("슬라임", (int)(Math.random() * 5) + 28, "normal");
	}

	@Override
	public void actionPattern(Character player, int turnCnt) {
		if(turnCnt % pattern == 0) {
			player.getStatus().addWeak(2);
		} else {
			int damage = (int)((this.getDamage() + this.getStatus().getStrength()) 
					* (this.getStatus().isWeak() ? 0.75 : 1));
			player.getStatus().getDamage(damage);
		}
	}
	
	@Override
	public void printPattern(int turnCnt) {
		if(turnCnt % pattern == 0) {
			this.setActionDef("적이 디버프를 부여합니다.");
		} else {
			this.setDamage(8);
			this.setActionDef("적이 피해를 " + this.getDamage() + " 만큼 줍니다.");
		}
	}
}
