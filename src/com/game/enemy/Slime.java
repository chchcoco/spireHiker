package com.game.enemy;

import com.game.character.Character;

public class Slime extends Enemy{
	
	private int pattern;
	
	public Slime() {
		super("슬라임", (int)(Math.random() * 5) + 28, "normal");
	}

	@Override
	public void actionPattern(Character player, int turnCnt) {
		if(turnCnt % pattern == 0) {
			player.getStatus().addWeak(2);
			System.out.println(this.getName() + "가 약화를 부여!");
		} else {
			int damage = (int)((this.getDamage() + this.getStatus().getStrength()) 
					* (this.getStatus().isWeak() ? 0.75 : 1));
			System.out.println(this.getName() + "의 " + damage + "피해의 공격!");
			player.getStatus().getDamage(damage);
		}
	}
	
	@Override
	public void printPattern(int turnCnt) {
		pattern = (int)(Math.random() * 2 + 1);
		if(turnCnt % pattern == 0) {
			this.setActionDef(this.getName()+"이(가) 디버프를 부여합니다.");
		} else {
			this.setDamage(8);
			this.setActionDef(this.getName()+"이(가) 피해를 " + this.getDamage() + " 만큼 줍니다.");
		}
		System.out.println(this.getActionDef());
	}
}
