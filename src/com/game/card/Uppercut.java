package com.game.card;

public class Uppercut extends AttackCard {
	
	public Uppercut() {}
	
	public Uppercut(int idx, String name, int cost, int damage, String rarity, String owner) {
		super(idx, name, cost, damage, rarity, owner);
	}
	
	public AttackCard getCard() {
		int idx = 12;
		String name = "어퍼컷";
		int cost = 2;
		int damage = 13;
		String rarity = "rare";
		String owner = "A";
		
		AttackCard uppercut = new Uppercut(idx, name, cost, damage, rarity, owner);
		uppercut.setDef("피해를 " + uppercut.getDamage() + "줍니다.\n약화와 취약을 1 부여합니다.");
		
		return uppercut;
	}

}
