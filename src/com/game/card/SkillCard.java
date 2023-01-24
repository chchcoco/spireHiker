package com.game.card;

import com.game.character.Character;
import com.game.data.Status;
import com.game.enemy.Enemy;
import com.game.stage.Battle;

public class SkillCard implements Card {
	
	private int idx;
	private String name;
	private int cost;
	private int guard;
	private String rarity;
	private String def;
	private String owner;
	
	public SkillCard() {};
	
	public SkillCard(int idx, String name, int cost, int guard, String rarity, String owner) {
		super();
		this.idx = idx;
		this.name = name;
		this.cost = cost;
		this.guard = guard;
		this.rarity = rarity;
		this.owner = owner;
	}

	/* 카드의 정보를 출력하는 메소드
	 * 사용시 소모 에너지, 이름, 카드 효과를 String으로 반환
	 * */
	@Override
	public String printText() {
		return "Cost : " + cost + ", " + name + " : " + def;
	}
	
	/* 카드를 사용했을 때, 쓰인 효과를 실행, 구현한 메소드
	 * 카드의 사용 여부를 위해 boolean타입을 반환한다.
	 * */
	@Override
	public boolean useCard(Character player, Enemy enemy) {
		if(Battle.nowEnergy >= this.getCost()) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getIdx() {
		return idx;
	}

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}

	public int getGuard() {
		return guard;
	}

	public String getRarity(){
		return rarity;
	}

	public String getDef() {
		return def;
	}

	public String getOwner() {
		return owner;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setGuard(int guard) {
		this.guard = guard;
	}

	public void setDef(String def) {
		this.def = def;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}
