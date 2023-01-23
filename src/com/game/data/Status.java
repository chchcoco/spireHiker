package com.game.data;

public class Status {

	private int hp;					//체력
	private int maxHp;				//최대체력
	private int block;				//방어도
	private boolean isVulnerable;	//취약 상태 유무
	private int cntVulnerable;		//취약 카운터
	private boolean isWeak;			//약화 상태 우뮤
	private int cntWeak;			//약화 카운터
	private int strength;			//힘
	private int dexterity;			//민첩
	private boolean isLive;	//생존 여부
	
	public Status() {}
	
	public Status(int maxHp) {
		this.hp = maxHp;
		this.maxHp = maxHp;
		this.block = 0;
		this.isVulnerable = false;
		this.cntVulnerable = 0;
		this.isWeak = false;
		this.cntWeak = 0;
		this.strength = 0;
		this.dexterity = 0;
		this.isLive = true;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getBlock() {
		return block;
	}

	public void setBlock(int block) {
		this.block = block;
	}
	
	public void addBlock(int block) {
		this.block = this.block + block;
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
	
	public void addVulnerable(int vulnerable) {
		this.cntVulnerable = this.cntVulnerable + vulnerable;
		if(this.cntVulnerable > 0) {
		isVulnerable = true;
		}
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
	
	public void addWeak(int weak) {
		this.cntWeak = this.cntWeak + weak;
		if(this.getCntWeak() > 0) {
			this.isWeak = true;
		}
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public void addStrength(int strength) {
		this.strength = this.strength + strength;
	}

	public int getDexterity() {
		return dexterity;
	}
	
	public boolean isLive() {
		return isLive;
	}
	
	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	
	public void addDexterity(int dexterity) {
		this.dexterity = this.dexterity + dexterity;
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
	
	public void getDamage(int damage) {
		damage = (int)(damage * (this.isVulnerable ? 1.5 : 1));
		damage = this.block - damage;
		if(damage >= 0) {
			this.block = damage;
			damage  = 0;
			System.out.println("방어함.");
		} else {
			this.block = 0;
			System.out.println(damage * -1 + "의 피해!");
		}
		this.hp = this.hp + damage;
		if(this.hp <= 0) {
			this.isLive = false;
		}
	}
	
	public void printInformation() {
		System.out.println("현재 체력 : " + this.hp);
		if(this.block != 0) {
			System.out.println("현재 방어도 : " + this.block);
		}
		if(this.strength != 0) {
			System.out.println("힘 : " + this.strength);
		}
		if(this.dexterity != 0) {
			System.out.println("민첩 : " + this.dexterity);
		}
		if(this.isVulnerable) {
			System.out.println("취약 : " + this.cntVulnerable);
		}
		if(this.isWeak) {
			System.out.println("약화 : " + this.cntWeak);
		}
	}
	
	public void heal(int heal) {
		this.hp += heal;
		if(this.hp > this.maxHp) {
			hp = maxHp;
		}
	}

	
}
