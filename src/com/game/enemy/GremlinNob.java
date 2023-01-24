package com.game.enemy;

import com.game.character.Character;

public class GremlinNob extends Enemy{
	
	private int pattern = (int)(Math.random() * 4 + 1);
	
	public GremlinNob() {
		super("귀족 그렘린", (int)(Math.random() * 4) + 82, "elite");
	}
	
	
	
	@Override
	public void actionPattern(Character player, int turnCnt) {
		if(turnCnt == 1) {
			System.out.println("구어어어어!!");
		} else if (turnCnt == 2){
			this.getStatus().addStrength(2);
			int damage = (int)((this.getDamage() + this.getStatus().getStrength()) 
					* (this.getStatus().isWeak() ? 0.75 : 1));
			System.out.println(this.getName() + "의 " + damage + "피해의 공격!");
			player.getStatus().getDamage(damage);
			player.getStatus().addVulnerable(3);
		} else {
			this.getStatus().addStrength(2);
			int damage = (int)((this.getDamage() + this.getStatus().getStrength()) 
					* (this.getStatus().isWeak() ? 0.75 : 1));
			System.out.println(this.getName() + "의 " + damage + "피해의 공격!");
			player.getStatus().getDamage(damage);
		}
	}
	
	@Override
	public void printPattern(int turnCnt) {
		if(turnCnt == 1) {
			this.setDamage(11);
			this.setActionDef("적이 자신에게 이로운 버프를 부여합니다.(매턴 힘 2 획득)");
		} else if (turnCnt == 2 || turnCnt % pattern == 0){
			this.setDamage(4);
			this.setActionDef("적이 " + (this.getDamage() + this.getStatus().getStrength()) + "의 피해로 공격하며 해로운 효과를 부여합니다.");
		} else {
			this.setDamage(14);
			this.setActionDef("적이 " + (this.getDamage() + this.getStatus().getStrength()) + "의 피해로 공격합니다.");
		}
		System.out.println(this.getActionDef());
	}

}
