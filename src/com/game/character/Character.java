package com.game.character;

import java.util.ArrayList;
import java.util.List;

import com.game.card.Card;
import com.game.data.Status;

public class Character {
	
	private String name;						// 캐릭터 명
	private int maxHp;
	private String def;							// 캐릭터에 대한 설명
//	private Card[] deck = new Card[50];			
	private List<Card> deck = new ArrayList<>();// 전투 시 매 턴 5장씩 뽑는 카드 풀.
	
	private Card[][] cardList = new Card[3][];	// 캐릭터가 가진 전체 카드 리스트. 레어도별로 열로 구분.
	private int deckCnt = 0;					// 현재 덱이 몇 장 있는지 세는 카운터 
	private Status status;						// 체력 등 정보를 저장하는 Status필드
	private int maxEnergy = 3;					// 전투 시작시 매 턴 얻게되는 에너지량
	
	public Character(String name, int maxHp, String def) {
		super();
		this.name = name;
		this.maxHp = maxHp;
		this.def = def;
		this.status = new Status(this.maxHp);
	}

	public void characterEffect() {}			// 캐릭터 고유 효과 구현 메소드
	
	public void startingDeck() {}				// 캐릭터 고유 시작 덱 구현 메소드

	/*getter, setter*/
	public String getName() {
		return name;
	}

	public int getMaxhp() {
		return maxHp;
	}

	public String getDef() {
		return def;
	}

//	public Card[] getDeck() {
//		return deck;
//	}
	
	public List<Card> getDeck() {
		return deck;
	}

	public Card[][] getCardList(){
		return cardList;
	}
	
	public int getDeckCnt() {
		return deckCnt;
//		return deck1.size();
	}

	public Status getStatus(){
		return status;
	}
	
	public int getMaxEnergy() {
		return maxEnergy;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMaxhp(int maxHp) {
		this.maxHp = maxHp;
	}

	public void setDef(String def) {
		this.def = def;
	}

//	public void setDeck(Card[] deck) {
//		this.deck = deck;
//	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	public void setCardList(Card[][] cardList){
		this.cardList = cardList;
	}

	public void setStatus(Status status){
		this.status = status;
	}
	
	public void setMaxEnergy(int maxEnergy) {
		this.maxEnergy = maxEnergy;
	}
	
	/* deck에 카드를 추가하는 메소드
	 * 매개변수로 입력받을 카드를 받아서
	 * 첫번째 null이 오는 deck[index]에 해당 카드를 저장한다.
	 * deckCnt도 해당 index로 바꾼다.
	 * */
	public void addCard(Card card) {
		deck.add(card);
	}
		
//	public void addCard(Card card) {
//		for(int i = 0; i < deck.length; i++) {
//			if(deck[i] == null) {
//				deckCnt = i;
//				break;
//			}
//		}
//		deck[deckCnt] = card;
//		deckCnt++;
//	}
	

	
	
	
}
