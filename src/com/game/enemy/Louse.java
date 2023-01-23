package com.game.enemy;

import com.game.character.Character;

public class Louse extends Enemy{
	
	private int pattern = (int)(Math.random() * 3 + 1);
	private int randomCnt;
	
	public Louse() {
		super("공벌레", (int)(Math.random() * 5) + 18, "normal");
	}
	
	
	
	@Override
	public void actionPattern(Character player, int turnCnt) {
		if(turnCnt == 1) {
			this.getStatus().addBlock(10);
		} else if(turnCnt % pattern == 0) {
			if(this.randomCnt == 0) {
				player.getStatus().addWeak(2);
			} else {
				this.getStatus().addStrength(3);
			}
		} else {
			int damage = (int)(((int)(Math.random() * 3 + 5) + this.getStatus().getStrength()) 
					* (this.getStatus().isWeak() ? 0.75 : 1));
			player.getStatus().getDamage(damage);
		}
	}
	
	@Override
	public void printPattern(int turnCnt) {
		if(turnCnt == 1) {
			this.setActionDef("방어도를 10 얻습니다.");
		} else if(turnCnt % pattern == 0) {
			randomCnt = (int)(Math.random() * 2);
			if(randomCnt == 0) {
				this.setActionDef("적이 디버프를 부여합니다.");
			} else {
				this.setActionDef("적이 자신에게 이로운 효과를 부여합니다.");
			}
		} else {
			this.setDamage((int)(Math.random() * 3 + 5));
			this.setActionDef("적이 피해를 " + super.getDamage() + " 만큼 줍니다.");
		}
	}
}
