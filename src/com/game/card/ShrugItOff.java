package com.game.card;

public class ShrugItOff extends SkillCard {
	
	public ShrugItOff(int idx, String name, int cost, int guard, String rarity, String owner) {
		super(idx, name, cost, guard, rarity, owner);
	}
	
	public SkillCard getCard() {
		int idx = 6;
		String name = "흘려보내기";
		int cost = 1;
		int guard = 8;
		String rarity = "normal";
		String owner = "A";
		
		SkillCard shrugItOff = new ShrugItOff(idx, name, cost, guard, rarity, owner);
		shrugItOff.setDef("방어도를 " + shrugItOff.getGuard() + "얻습니다.\n카드를 1장 뽑습니다.");
		
		return shrugItOff;
	}
}

