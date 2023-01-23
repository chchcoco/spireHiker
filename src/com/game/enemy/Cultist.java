package com.game.enemy;

import com.game.character.Character;

public class Cultist extends Enemy {

	public Cultist() {
		super("광신자", 48, "normal");
	}
	
	
	
	@Override
	public void actionPattern(Character player, int turnCnt) {
		if(turnCnt == 1) {
			System.out.println("까-까악!");
		} else {
			int damage = (int)((this.getDamage() + this.getStatus().getStrength()) 
					* (this.getStatus().isWeak() ? 0.75 : 1));
			System.out.println(this.getName() + "의 " + damage + "피해의 공격!");
			player.getStatus().getDamage(damage);
		}
	}
	
	@Override
	public void printPattern(int turnCnt) {
		if(turnCnt == 1) {
			this.setActionDef("적이 매 턴마다 힘 3를 얻는 버프를 자신에게 부여합니다");
		}  else {
			this.setDamage(3);
			this.getStatus().addStrength(3);
			this.setActionDef("적이 " + (this.getDamage() + this.getStatus().getStrength()) + "의 피해로 공격합니다.");
		}
	}
}
