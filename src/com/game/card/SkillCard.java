package com.game.card;

import com.game.character.Character;
import com.game.data.Status;
import com.game.enemy.Enemy;

public class SkillCard implements Card {
	
	private int idx;
	private String name;
	private int cost;
	private int guard;
	private String rarity;
	private String def;
	private String owner;
	
	public SkillCard() {};
	
	public SkillCard(int idx, String name, int cost, int guard, String rarity, String owner) {
		super();
		this.idx = idx;
		this.name = name;
		this.cost = cost;
		this.guard = guard;
		this.rarity = rarity;
		this.owner = owner;
	}

	@Override
	public String printText() {
		return "Cost : " + cost + name + " : " + def;
	}
	
	@Override
	public void useCard(Character player, Enemy enemy, int nowEnergy) {
		
	}
	
	public int getIdx() {
		return idx;
	}

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}

	public int getGuard() {
		return guard;
	}

	public String getRarity(){
		return rarity;
	}

	public String getDef() {
		return def;
	}

	public String getOwner() {
		return owner;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setGuard(int guard) {
		this.guard = guard;
	}

	public void setDef(String def) {
		this.def = def;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public int giveBlock(Status i) {
		return this.guard;
	}
}
