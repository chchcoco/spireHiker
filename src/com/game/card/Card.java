package com.game.card;

import com.game.character.Character;
import com.game.enemy.Enemy;

public interface Card {

	public String printText();
	
	public boolean useCard(Character player, Enemy enemy);
	
}
