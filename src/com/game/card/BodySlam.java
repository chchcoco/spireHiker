package com.game.card;

public class BodySlam extends AttackCard{
	
	public BodySlam() {}
	
	public BodySlam(int idx, String name, int cost, int damage, String rarity, String owner) {
		super(idx, name, cost, damage, rarity, owner);
	}
	
	public AttackCard getCard() {
		int idx = 4;
		String name = "몸통박치기";
		int cost = 0;
		int damage = 0;
		String rarity = "normal";
		String owner = "A";
		
		AttackCard bodySlam = new BodySlam(idx, name, cost, damage, rarity, owner);
		bodySlam.setDef("피해를 현재 방어도 만큼 줍니다.");
		
		return bodySlam;
	}
}
