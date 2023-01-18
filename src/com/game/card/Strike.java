package com.game.card;

public class Strike extends AttackCard{
	
	public Strike() {}
	
	public Strike(int idx, String name, int cost, int damage, String rarity, String owner) {
		super(idx, name, cost, damage, rarity, owner);
	}
	
	public AttackCard getCard() {
		int idx = 1;
		String name = "타격";
		int cost = 1;
		int damage = 6;
		String rarity = "normal";
		String owner = "A";
		
		AttackCard strike = new Strike(idx, name, cost, damage, rarity, owner);
		strike.setDef("피해를 " + strike.getDamage() + " 줍니다.");
		
		return strike;
	}
	
}