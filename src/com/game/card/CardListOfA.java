package com.game.card;

public class CardListOfA {
	
	Card[] cardList = new Card[15];

}

class Strike extends AttackCard{
	
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

class Defence extends SkillCard{
	
	public Defence(int idx, String name, int cost, int guard, String rarity, String owner) {
		super(idx, name, cost, guard, rarity, owner);
	}
	
	public SkillCard getCard() {
		int idx = 2;
		String name = "수비";
		int cost = 1;
		int guard = 5;
		String rarity = "normal";
		String owner = "A";
		
		SkillCard defence = new Defence(idx, name, cost, guard, rarity, owner);
		defence.setDef("방어도를 " + defence.getGuard() + " 얻습니다.");
		
		return defence;
	}
}

class Bash extends AttackCard {
	
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

class BodySlam extends AttackCard{
	
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