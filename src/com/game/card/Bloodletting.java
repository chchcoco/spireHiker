package com.game.card;

public class Bloodletting extends SkillCard {
	
	public Bloodletting() {}
	
	public Bloodletting(int idx, String name, int cost, int guard, String rarity, String owner) {
		super(idx, name, cost, guard, rarity, owner);
	}
	
	public SkillCard getCard() {
		int idx = 8;
		String name = "사혈";
		int cost = 0;
		int guard = 0;
		String rarity = "rare";
		String owner = "A";
		
		SkillCard bloodletting = new Bloodletting(idx, name, cost, guard, rarity, owner);
		bloodletting.setDef("체력을 3 잃습니다. 에너지를 2 얻습니다.");
		
		return bloodletting;
	}

	

}
