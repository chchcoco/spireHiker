package com.game.enemy;

import com.game.character.Character;

public class TheGuardian extends Enemy {
	
	private int shiftMod = 30;
	private int actionCnt = 1;
	private int deadline;
	private boolean isAttackMod = true;
	
	public TheGuardian() {
		super("수호자", 240, "boss");
	}
	
	
	
	@Override
	public void actionPattern(Character player, int turnCnt) {
		if(actionCnt == 1) {
			this.getStatus().addBlock(9);
			actionCnt++;
		} else if(actionCnt == 2) {
			int damage = (int)((this.getDamage() + this.getStatus().getStrength()) 
					* (this.getStatus().isWeak() ? 0.75 : 1));
			System.out.println(this.getName() + "의 " + damage + "피해의 공격!");
			player.getStatus().getDamage(damage);
			actionCnt++;
		} else if (actionCnt == 3){
			this.setActionDef("취약과 약화를 2씩 얻었습니다.");
			player.getStatus().addVulnerable(2);
			player.getStatus().addWeak(2);
			actionCnt++;
		} else if(actionCnt == 4){
			int damage = (int)((this.getDamage() + this.getStatus().getStrength()) 
					* (this.getStatus().isWeak() ? 0.75 : 1));
			System.out.println(this.getName() + "의 " + damage + "피해의 공격!");
			player.getStatus().getDamage(damage);
			actionCnt = 1;
		} else if (actionCnt == 5) {
			System.out.println(this.getName() + "의 방어모드 진행중. 3의 방어도를 항상 얻습니다.");
			actionCnt++;
		} else if(actionCnt == 6) {
			int damage = (int)((this.getDamage() + this.getStatus().getStrength()) 
					* (this.getStatus().isWeak() ? 0.75 : 1));
			System.out.println(this.getName() + "의 " + damage + "피해의 공격!");
			player.getStatus().getDamage(damage);
			actionCnt++;
		} else if(actionCnt == 7) {
			int damage = (int)((this.getDamage() + this.getStatus().getStrength()) 
					* (this.getStatus().isWeak() ? 0.75 : 1));
			System.out.println(this.getName() + "의 " + damage + "피해의 공격!");
			player.getStatus().getDamage(damage);	
			System.out.println(this.getName() + "의 " + damage + "피해의 공격!");
			player.getStatus().getDamage(damage);
			modeChange();
			actionCnt = 1;
		} //else 는 없다.
	}
	
	@Override
	public void printPattern(int turnCnt) {
		if(actionCnt == 1) {
			deadline = this.getStatus().getHp() - shiftMod;
			System.out.println("공격 모드 수행. 모드 변경까지 누적 데미지는 " + shiftMod + "입니다.");
			System.out.println("피해를 " + shiftMod + "만큼 입으면 하려던 행동을 중단하고 즉시 방어모드로 돌입합니다.");
			this.setActionDef("방어도를 얻습니다");
		} else if(actionCnt == 2) {
			System.out.println(" 파괴 파괴 파괴 ");
			this.setDamage(32);
			System.out.println("적이 " + this.getDamage() + "의 피해를 주는 공격을 하려 합니다.");
		} else if (actionCnt == 3){
			this.setActionDef("적이 아주 해로운 효과를 사용하려 합니다.");
		} else if(actionCnt == 4){
			this.setDamage(36);
			this.setActionDef("적이 " + (this.getDamage() + this.getStatus().getStrength()) + "의 피해로 공격합니다.");
		} else if (actionCnt == 5) {
			this.setActionDef("수비모드 변경, 방어도 20 즉시 획득");
			this.getStatus().addBlock(20);
		} else if(actionCnt == 6) {
			this.getStatus().addBlock(3);
			this.setDamage(9);
			this.setActionDef(this.getName() + "가 " + this.getDamage() + "의 피해를 주는 공격을 시도합니다.");
		} else if(actionCnt == 7) {
			this.getStatus().addBlock(3);
			this.setDamage(8);
			this.setActionDef(this.getName() + "가 " + this.getDamage() + " * 2 의 피해를 주는 공격을 시도합니다.");	
		} //else 는 없다.
		System.out.println(this.getActionDef());
	}
	
	/* 고유 패턴을 구현을 위해 추가로 구현된 메소드 */
	public void modeChange() {
		if(isAttackMod && this.getStatus().getHp() <= deadline) {
			actionCnt = 5;
			printPattern(0);
			isAttackMod = false;
		}
		
		if(!isAttackMod && actionCnt == 7) {
			isAttackMod = true;
			shiftMod += 10;
		}
	}

}
