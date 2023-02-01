package com.game.enemy;

import com.game.character.Character;

public class JawWorm extends Enemy{
	
	private int pattern = (int)(Math.random() * 3 + 1);
	
	public JawWorm() {
		super("턱벌레", (int)(Math.random() * 5) + 40, "normal");
	}
	
	
	
	@Override
	public void actionPattern(Character player, int turnCnt) {
		if(turnCnt == 1) {
			int damage = (int)((this.getDamage() + this.getStatus().getStrength()) 
					* (this.getStatus().isWeak() ? 0.75 : 1));
			System.out.println(this.getName() + "의 " + damage + "피해의 공격!");
			player.getStatus().getDamage(damage);
		} else if (turnCnt % pattern == 0){
			int damage = (int)((this.getDamage() + this.getStatus().getStrength()) 
					* (this.getStatus().isWeak() ? 0.75 : 1));
			System.out.println(this.getName() + "의 " + damage + "피해의 공격!");
			player.getStatus().getDamage(damage);
		} else if (turnCnt % pattern == 1) {
			this.getStatus().addBlock(5);
			this.getStatus().addStrength(3);
			System.out.println(this.getName() + "의 힘이 증가했다!");
		} else {
			int damage = (int)((this.getDamage() + this.getStatus().getStrength()) 
					* (this.getStatus().isWeak() ? 0.75 : 1));
			System.out.println(this.getName() + "의 " + damage + "피해의 공격!");
			player.getStatus().getDamage(damage);
			this.getStatus().addBlock(6);
		}
	}
	
	@Override
	public void printPattern(int turnCnt) {
		if(turnCnt == 1) {
			this.setDamage(11);
			this.setActionDef(this.getName()+"이(가) " + this.getDamage() + "의 피해로 공격합니다.");
		} else if (turnCnt % pattern == 0){
			this.setDamage(11);
			this.setActionDef(this.getName()+"이(가) " + this.getDamage() + "의 피해로 공격합니다.");
		} else if (turnCnt % pattern == 1) {
			this.setActionDef("적이 방어와 자신에게 이로운 행동을 합니다");
		} else {
			this.setDamage(7);
			this.setActionDef(this.getName()+"이(가) " + this.getDamage() + "의 피해로 공격하면서 방어합니다.");
		}
		System.out.println(this.getActionDef());
	}
}
