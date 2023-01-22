package com.game.enemy;

public class Louse extends Enemy{
	
	
	public Louse() {
		super("공벌레", (int)(Math.random() * 5) + 9);
	}
	
	
	
	@Override
	public void actionPattern(Character player) {
		actionCnt = (int)(Math.random()*2);
		if(actionCnt == 0) {
			action.attack
		}
	}
	
	@Override
	public void printPattern(int turnCnt) {
		
	}
}
