package com.game.stage;

import java.util.Scanner;

import com.game.GameInformation;
import com.game.card.Card;
import com.game.card.CardReward;
import com.game.character.Character;
import com.game.data.Action;
import com.game.enemy.Enemy;
import com.game.enemy.TheGuardian;
import com.game.play.Ending;

public class Battle implements GameInformation {
	
	Scanner sc = new Scanner(System.in);
	Action action = new Action();
	private Character player;
	Enemy enemy;
	
	private int[] cardCnt;							// draw()에서 플레이어가 같은 카드를 뽑지 않게 하기위한 변수
	private int cnt; 								//cardCnt의 cnt
	private Card[] hand = new Card[10];				//전투시 덱에서 뽑은 카드. '패'라고 함.
	private Card temp; 								//사용한 카드를 정렬하기 위해 쓴 임시 변수공간
	private int handCnt = 0;						//패의 수를 저장하는 변수
	
	private int maxEnergy;
	public static int nowEnergy;
	private boolean isUse;
	private boolean battleEnd;
	
	public Battle(Character player, Enemy enemy) {
		this.setPlayer(player);
		this.enemy = enemy;
		this.maxEnergy = player.getMaxEnergy();
	}
	
	
	public void fight(Character player, Enemy enemy) {
		System.out.println(enemy.getName() + "이 나타났습니다!");
		int turnCnt = 1;
		while(true) {
			nowEnergy = maxEnergy;									// 에너지를 최대에너지로 조정
			readyToBattle(player);									// 턴 시작시 이전 전투의 정보 초기화
			
			for(int i = 0; i < GameInformation.DRAW_CARDS; i++) {	// 카드 뽑기
				hand[i] = draw(player);
				handCnt++;
			}
			
			int input = 0;
			while(input != -1) {
				showBattleInformation(player, enemy);
				enemy.printPattern(turnCnt);							// 전투 시작시 적이 할 행동 출력
				for(int i = 0; i < handCnt; i++) {
					if(hand[i] != null) {
						System.out.println(i + ") " + hand[i].printText());
					}
				}
				System.out.println();
				System.out.println("현재 에너지 : " + nowEnergy);
				System.out.println("~ -1) 차례를 넘깁니다.");
				System.out.print("사용할 카드의 번호를 입력하세요 : ");
				input = sc.nextInt();
				if(input < 0) {										// 음수 입력으로 차례를 종료한 경우
					 System.out.println("차례를 넘깁니다.");
					 break;
				} else if(input > handCnt) { 						// 핸드에서 출력된 번호보다 큰 값을 입력한 경우
					System.out.println("없는 카드 입니다. 다시 선택하세요.");
				} else {											// 일반적인 경우(핸드에 있는 카드를 정상적으로 선택한 경우)
					if(hand[input] != null) {
						isUse = hand[input].useCard(player, enemy);
						if(isUse) {
							hand[input] = null;
						}
						if(!enemy.getStatus().isLive()) {
							battleEnd = true;
							break;
						}
						if("boss".equals(enemy.getType())) {
							((TheGuardian)enemy).modeChange();
						}
					} else {
						System.out.println("이미 사용한 카드 입니다.");
					}
				}
				
			
			}
			if(battleEnd) {
				battleEnd(enemy);
				if("A".equals(player.getName())) {
					player.characterEffect();
				}
				break;
			}
			enemy.getStatus().turnEnd();
			enemy.actionPattern(player ,turnCnt);						// if 턴 엔드 : 적 행동 수행;
			if(!player.getStatus().isLive()) {
				new Ending().badEnd(player);
			}
		
			player.getStatus().turnEnd();
			turnCnt ++;
			System.out.println(turnCnt+ "턴입니다.");
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

	public void showBattleInformation(Character player, Enemy enemy) {
		System.out.println("플레이어 정보");
		player.getStatus().printInformation();
		System.out.println("----------------");
		System.out.println("적 정보");
		enemy.getStatus().printInformation();
	}
	
	
	public void battleEnd(Enemy enemy) {
		System.out.println("몬스터를 처치했습니다!");
		if("normal".equals(enemy.getType())) {
			System.out.println("카드보상을 획득합니다!");
			new CardReward().getReward(getPlayer());
		}else if("elite".equals(enemy.getType())) {
			System.out.println("카드보상을 획득합니다!");
			new CardReward().getReward(getPlayer());
			System.out.println("두번째 카드보상!");
			new CardReward().getReward(getPlayer());
		} else if("boss".equals(enemy.getType())) {
			System.out.println("보스를 쓰러뜨리고 첨탑을 정복했습니다!");
			new Ending().goodEnd(player);
			return;
		}
		
	}


	public Character getPlayer() {
		return player;
	}


	public void setPlayer(Character player) {
		this.player = player;
	}
}
