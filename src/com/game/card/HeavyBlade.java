package com.game.card;

public class HeavyBlade extends AttackCard {
	
	public HeavyBlade(int idx, String name, int cost, int damage, String rarity, String owner) {
		super(idx, name, cost, damage, rarity, owner);
	}
	
	public AttackCard getCard() {
		int idx = 5;
		String name = "대검";
		int cost = 2;
		int damage = 14;
		String rarity = "normal";
		String owner = "A";
		
		AttackCard heavyBlade = new HeavyBlade(idx, name, cost, damage, rarity, owner);
		heavyBlade.setDef("피해를 " + heavyBlade.getDamage() + " 줍니다.\n힘의 효과가 4배로 적용됩니다.");
		
		return heavyBlade;
	}

}


