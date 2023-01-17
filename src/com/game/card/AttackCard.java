package com.game.card;

public class AttackCard implements Card {
	
	private int idx;
	private String name;
	private int cost;
	private int damage;
	private String rarity;
	private String def;
	private String owner;
	
	public AttackCard() {};
	
	public AttackCard(int idx, String name, int cost, int damage, String rarity, String owner) {
		super();
		this.idx = idx;
		this.name = name;
		this.cost = cost;
		this.damage = damage;
		this.rarity = rarity;
		this.owner = owner;
	}

	@Override
	public String printText() {
		return def;
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

	public int getDamage() {
		return damage;
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

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void setDef(String def) {
		this.def = def;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	
	
}