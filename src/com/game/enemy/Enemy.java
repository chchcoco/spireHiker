package com.game.enemy;

import com.game.data.Status;
import com.game.character.Character;

public class Enemy {
	
	private String name;
	private int maxHp;
	private int damage;							// 상대에게 주는 데미지
	private Status status;						// Enemy 객체의 상태를 저장하는 Status필드
	private String actionDef;					// 이번 턴 수행할 행동을 설명하는 문자열 필드
	private String type;						// Enemy의 등급. normal, elite, boss 세 종류가 있다.
	
	public Enemy(String name, int maxHp, String type) {
		this.name = name;
		this.maxHp = maxHp;
		this.status = new Status(maxHp);
		this.type = type;
	}
	
	/* getter, setter */
	public String getName() {
		return name;
	}

	public int getMaxHp() {
		return maxHp;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public String getActionDef() {
		return actionDef;
	}
	
	public String getType() {
		return type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public void setActionDef(String actionDef) {
		this.actionDef = actionDef;
	}

	/* 패턴에 따라 행동을 구현한 메소드 */
	public void actionPattern(Character player, int turnCnt) {}

	/* 곧 수행할 actionPattern을 설명하고 출력하는 메소드.
	 * actionDef를 출력한다.
	 * */
	public void printPattern(int turnCnt) {
		System.out.println(this.actionDef);
	}

	
}
