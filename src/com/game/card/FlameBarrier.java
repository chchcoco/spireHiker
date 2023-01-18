package com.game.card;

public class FlameBarrier extends SkillCard {
	
	public int damage = 4;
	
	public FlameBarrier() {}
	
	public FlameBarrier(int idx, String name, int cost, int guard, String rarity, String owner) {
		super(idx, name, cost, guard, rarity, owner);
	}
	
	public SkillCard getCard() {
		int idx = 9;
		String name = "화염 장벽";
		int cost = 2;
		int guard = 14;
		String rarity = "rare";
		String owner = "A";
		
		SkillCard flameBarrier = new FlameBarrier(idx, name, cost, guard, rarity, owner);
		flameBarrier.setDef("방어도를 " + flameBarrier.getGuard() + "얻습니다.\n이번 턴 공격을 받으면 " + getDamage() + "피해를 줍니다");
		
		return flameBarrier;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	

}
