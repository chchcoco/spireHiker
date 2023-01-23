package com.game.enemy;

import com.game.data.Status;
import com.game.character.Character;

public class Enemy {
	
	private String name;
	private int maxHp;
	private int damage;
	private Status status;
	private int actionCnt;
	private String actionDef;
	private String type;
	
	public Enemy(String name, int maxHp, String type) {
		this.name = name;
		this.maxHp = maxHp;
		this.status = new Status(maxHp);
		this.type = type;
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
	
	public Status getStatus() {
		return status;
	}
	
	public int getActionCnt() {
		return actionCnt;
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
	
	public void setActionCnt(int actionCnt) {
		this.actionCnt = actionCnt;
	}
	
	public void setActionDef(String actionDef) {
		this.actionDef = actionDef;
	}

	public void actionPattern(Character player, int turnCnt) {}

	public void printPattern(int turnCnt) {}

	
}
