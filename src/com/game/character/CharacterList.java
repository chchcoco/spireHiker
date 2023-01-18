package com.game.character;

import com.game.GameInformation;

public class CharacterList implements GameInformation{
	
	public Character[] getCharacterList() {
		Character[] ch = new Character[GameInformation.CHARACTER_COUNT];
		
		ch[0] = new CharacterA();
		
		return ch;
	}

}
