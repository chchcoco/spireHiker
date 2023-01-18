package com.game.card;

public class Hemokinesis extends AttackCard {
	
	public Hemokinesis() {}
	
	public Hemokinesis(int idx, String name, int cost, int damage, String rarity, String owner) {
		super(idx, name, cost, damage, rarity, owner);
	}
	
	public AttackCard getCard() {
		int idx = 11;
		String name = "혈류";
		int cost = 1;
		int damage = 15;
		String rarity = "rare";
		String owner = "A";
		
		AttackCard hemokinesis = new Hemokinesis(idx, name, cost, damage, rarity, owner);
		hemokinesis.setDef("피해를 " + hemokinesis.getDamage() + "줍니다.\n체력을 2 잃습니다.");
		
		return hemokinesis;
	}

}
