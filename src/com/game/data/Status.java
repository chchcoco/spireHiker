package com.game.data;

public class Status {

	private int hp;					//체력
	private int block;				//방어도
	private boolean isVulnerable;	//취약 상태 유무
	private int cntVulnerable;		//취약 카운터
	private boolean isWeak;			//약화 상태 우뮤
	private int cntWeak;			//약화 카운터
	private int strength;			//힘
	private int dexterity;			//민첩
	
	public Status() {}
	
	public Status(int maxHp) {
		this.hp = maxHp;
		this.block = 0;
		this.isVulnerable = false;
		this.cntVulnerable = 0;
		this.isWeak = false;
		this.cntWeak = 0;
		this.strength = 0;
		this.dexterity = 0;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getBlock() {
		return block;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	public boolean isVulnerable() {
		return isVulnerable;
	}

	public void setVulnerable(boolean isVulnerable) {
		this.isVulnerable = isVulnerable;
	}

	public int getCntVulnerable() {
		return cntVulnerable;
	}

	public void setCntVulnerable(int cntVulnerable) {
		this.cntVulnerable = cntVulnerable;
	}

	public boolean isWeak() {
		return isWeak;
	}

	public void setWeak(boolean isWeak) {
		this.isWeak = isWeak;
	}

	public int getCntWeak() {
		return cntWeak;
	}

	public void setCntWeak(int cntWeak) {
		this.cntWeak = cntWeak;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	
	public void turnEnd() {
		if(this.isVulnerable) {
			this.cntVulnerable--;
		}
		if(this.cntVulnerable <= 0) {
			this.isVulnerable = false;
		}
		
		if(this.isWeak) {
			this.cntWeak--;
		}
		if(this.cntWeak <= 0) {
			this.isWeak = false;
		}
		
		this.block = 0;
	}
	
}
