package com.game.character;

import com.game.GameInformation;

public class CharacterList implements GameInformation{
	
	/*생성된 캐릭터들을 리스트로 저장하여 반환하는 메소드*/
	public Character[] getCharacterList() {
		Character[] ch = new Character[GameInformation.CHARACTER_COUNT];
		
		ch[0] = new CharacterA();
		
		return ch;
	}

}
