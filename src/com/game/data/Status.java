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
	private boolean isLive;			//생존 여부
	
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

	/* getter, setter */
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
	
	/* 방어도 획득 메소드 
	 * 매개변수로 받은 방어도만큼 현재 방어도에 추가한다.
	 * */
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
	
	/* 취약 획득 메소드
	 * 매개변수로 받은 취약 카운터 만큼 취약을 획득한다.
	 * 만약 이로인해 취약이 0에서 추가되었다면, 취약여부를 true로 변환한다.
	 * */
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
	
	/* 약화 획득 메소드
	 * 매개변수로 받은 약화 카운터 만큼 약화을 획득한다.
	 * 만약 이로인해 약화가 0에서 추가되었다면, 약화여부를 true로 변환한다.
	 * */
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
	
	/* 힘 획득 메소드
	 * 매개변수로 받은 힘만큼 힘을 획득한다.
	 * 매개변수가 음수여도 작동한다.
	 * */
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
	
	/* 민첩 획득 메소드
	 * 매개변수로 받은 민첩만큼 민첩을 획득한다.
	 * 매개변수가 음수여도 작동한다.
	 * */
	public void addDexterity(int dexterity) {
		this.dexterity = this.dexterity + dexterity;
	}
	
	/* 턴이 끝났을 때, 디버프(취약, 약화)와 버프(방어도 등)를 처리하는 메소드
	 * 취약과 약화는 카운터를 하나씩 줄이고, 이로인해 0이되면 취약/약화 여부를 false로 바꾼다.
	 * 방어도는 초기화시킨다.
	 * */
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
	
	/* 데미지를 처리하는 메소드.
	 * 매개변수로 입력받은 데미지를 처리한다.
	 * 방어도가 있다면 먼저 방어도를 차감하며,
	 * 차감된 방어도는 저장된다.
	 * */
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
	
	/* 현재 상태를 출력하는 메소드.
	 * 체력을 제외한 상태들은 디폴트 상태에서 변화가 없는 경우 출력하지 않는다.
	 * */
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
	
	/* 체력 회복 메소드
	 * 회복된 체력이 최대체력을 넘으면 최대체력으로 조정한다.
	 * */
	public void heal(int heal) {
		this.hp += heal;
		if(this.hp > this.maxHp) {
			hp = maxHp;
		}
	}
	
	/* 전투가 끝났을 때, 전투중 부여되었던 각종 버프 및 디버프를 초기화하는 메소드
	 * hp와 maxHp, isLive를 제외한 모든 필드를 초기화값으로 변경한다.
	 * */
	public void effectReset() {
		this.block = 0;
		this.strength = 0;
		this.dexterity = 0;
		this.cntVulnerable = 0;
		this.isVulnerable = false;
		this.cntWeak = 0;
		this.isWeak = false;
	}

	
}
