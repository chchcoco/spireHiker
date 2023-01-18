package com.game.card;

public class Inflame extends SkillCard {
	
	public Inflame() {}
	
	public Inflame(int idx, String name, int cost, int guard, String rarity, String owner) {
		super(idx, name, cost, guard, rarity, owner);
	}
	
	public SkillCard getCard() {
		int idx = 10;
		String name = "발화";
		int cost = 1;
		int guard = 0;
		String rarity = "rare";
		String owner = "A";
		
		SkillCard inflame = new Inflame(idx, name, cost, guard, rarity, owner);
		inflame.setDef("힘을 1 얻습니다");
		
		return inflame;
	}

}
