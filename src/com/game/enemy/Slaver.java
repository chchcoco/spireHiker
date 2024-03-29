package com.game.enemy;

import com.game.character.Character;

public class Slaver extends Enemy {

	private int pattern;
	
	public Slaver() {
		super("노예 상인", (int)(Math.random() * 5) + 46, "normal");
	}
	
	
	
	@Override
	public void actionPattern(Character player, int turnCnt) {
		if (turnCnt % pattern == 0){
			int damage = (int)((this.getDamage() + this.getStatus().getStrength()) 
					* (this.getStatus().isWeak() ? 0.75 : 1));
			System.out.println(this.getName() + "의 " + damage + "피해의 공격!");
			player.getStatus().getDamage(damage);
		} else {
			int damage = (int)((this.getDamage() + this.getStatus().getStrength()) 
					* (this.getStatus().isWeak() ? 0.75 : 1));
			System.out.println(this.getName() + "의 " + damage + "피해의 공격!");
			player.getStatus().getDamage(damage);
			player.getStatus().addWeak(1);
			System.out.println(this.getName() + "가 약화를 부여!");
		}
	}
	
	@Override
	public void printPattern(int turnCnt) {
		pattern = (int)(Math.random() * 2 + 1);
		if (turnCnt % pattern == 0){
			this.setDamage(12);
			this.setActionDef(this.getName()+"이(가) " + this.getDamage() + "의 피해로 공격합니다.");
		} else {
			this.setDamage(7);
			this.setActionDef(this.getName()+"이(가) " + this.getDamage() + "의 피해로 공격하면서 해로운 효과를 줍니다.");
		}
		System.out.println(this.getActionDef());
	}
}
