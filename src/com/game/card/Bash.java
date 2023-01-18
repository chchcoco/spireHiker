package com.game.card;

public class Bash extends AttackCard {
	
	public Bash() {}
	
	public Bash(int idx, String name, int cost, int damage, String rarity, String owner) {
		super(idx, name, cost, damage, rarity, owner);
	}
	
	public AttackCard getCard() {
		int idx = 3;
		String name = "강타";
		int cost = 2;
		int damage = 10;
		String rarity = "normal";
		String owner = "A";
		
		AttackCard bash = new Bash(idx, name, cost, damage, rarity, owner);
		bash.setDef("피해를 " + bash.getDamage() + "줍니다.\n취약을 2 부여합니다.");
		
		return bash;
	}
}