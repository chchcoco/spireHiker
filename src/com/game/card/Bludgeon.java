package com.game.card;

public class Bludgeon extends AttackCard {
	
	public Bludgeon() {}
	
	public Bludgeon(int idx, String name, int cost, int damage, String rarity, String owner) {
		super(idx, name, cost, damage, rarity, owner);
	}
	
	public AttackCard getCard() {
		int idx = 14;
		String name = "몽둥이질";
		int cost = 3;
		int damage = 35;
		String rarity = "Epic";
		String owner = "A";
		
		AttackCard bludgeon = new Bludgeon(idx, name, cost, damage, rarity, owner);
		bludgeon.setDef("피해를 " + bludgeon.getDamage() + "줍니다.");
		
		return bludgeon;
	}

}
