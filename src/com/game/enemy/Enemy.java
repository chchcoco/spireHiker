package com.game.enemy;

import com.game.data.Status;

public class Enemy {
	
	private String name;
	private int maxHp;
	private int damage;
	private Status status;
	private int actionCnt;
	private String actionDef;
	
	public Enemy(String name, int maxHp) {
		this.name = name;
		this.maxHp = maxHp;
		this.status = new Status(maxHp);
	}
	
	public String getName() {
		return name;
	}

	public int getMaxHp() {
		return maxHp;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public int getActionCnt() {
		return actionCnt;
	}
	
	public String getActionDef() {
		return actionDef;
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
	
	public void setActionCnt(int actionCnt) {
		this.actionCnt = actionCnt;
	}
	
	public void setActionDef(String actionDef) {
		this.actionDef = actionDef;
	}

	public void actionPattern(int turnCnt) {}

	public void printPattern(int turnCnt) {}

	
}
