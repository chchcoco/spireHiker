package com.game.card;

public class Impervious extends SkillCard {
	
	public Impervious() {}
	
	public Impervious(int idx, String name, int cost, int guard, String rarity, String owner) {
		super(idx, name, cost, guard, rarity, owner);
	}
	
	public SkillCard getCard() {
		int idx = 15;
		String name = "무적";
		int cost = 2;
		int guard = 27;
		String rarity = "epic";
		String owner = "A";
		
		SkillCard impervious = new Impervious(idx, name, cost, guard, rarity, rarity);
		impervious.setDef("방어도를 " + impervious.getGuard() + "얻습니다.");
		
		return impervious;
	}

}
