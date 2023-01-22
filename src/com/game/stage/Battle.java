package com.game.stage;

import java.util.Scanner;

import com.game.GameInformation;
import com.game.card.Card;
import com.game.character.Character;
import com.game.data.Action;
import com.game.enemy.Enemy;

public class Battle implements GameInformation {
	
	Scanner sc = new Scanner(System.in);
	Action action = new Action();
	Character player;
	Enemy enemy;
	
	private int[] cardCnt;							// draw()에서 플레이어가 같은 카드를 뽑지 않게 하기위한 변수
	private int cnt; 								//cardCnt의 cnt
	private Card[] hand = new Card[10];				//전투시 덱에서 뽑은 카드. '패'라고 함.
	private Card temp; 								//사용한 카드를 정렬하기 위해 쓴 임시 변수공간
	private int handCnt = 0;						//패의 수를 저장하는 변수
	
	int maxEnergy;
	int nowEnergy;
	
	public Battle(Character player, Enemy enemy) {
		this.player = player;
		this.enemy = enemy;
		this.maxEnergy = player.getMaxEnergy();
		
	}
	
	
	public void fight(Character player, Enemy enemy) {
		int turnCnt = 1;
		while(true) {
			enemy.printPattern(turnCnt);
			nowEnergy = maxEnergy;
			readyToBattle(player);
			
			for(int i = 0; i < GameInformation.DRAW_CARDS; i++) {
				hand[i] = draw(player);
				handCnt++;
			}
			
			int input = 0;
			while(input == -1) {
				for(int i = 0; i < handCnt; i++) {
					System.out.println(i + ") " + hand[i].printText());
				}
				System.out.println("~ -1) 차례를 넘깁니다.");
				System.out.print("사용할 카드의 번호를 입력하세요 : ");
				input = sc.nextInt();
				if(input < 0) {										//음수 입력으로 차례를 종료한 경우
					 System.out.println("차례를 넘깁니다.");
					 break;
				} else if(input > handCnt) { 						//핸드에서 출력된 번호보다 큰 값을 입력한 경우
					System.out.println("없는 카드 입니다. 다시 선택하세요.");
				} else {											//일반적인 경우(핸드에 있는 카드를 정상적으로 선택한 경우)
					hand[0].useCard(player, enemy, nowEnergy);
				// useCard(card, nowEnergy);
				}
			
			}
			// if 턴 엔드 : 적 행동 수행;
			
			
			player.getStatus().turnEnd();
			turnCnt ++;
		}
	}
	
	/*전투시작 및 턴 시작시 덱에서 draw한 카드를 중복되지 않게 하는 것*/
	public void readyToBattle(Character player) {
		cardCnt = new int[player.getDeckCnt()];
		cnt = 0;
		handCnt = 0;
	}
	
	public Card draw(Character player) {
		Card result;
		while(true) {
			boolean doReroll = false;
			int random = (int)(Math.random() * 15);
			for(int i = 0; i <= cnt; i++) {
				if(random == cardCnt[i]) {
					doReroll = true;
					random = (int)(Math.random() * 15);
					break;
				}
			}
			
			if(doReroll) {
				continue;
			}
			cnt++;
			result = player.getDeck()[random];
			break;
		}
	
		return result;
	}

}
