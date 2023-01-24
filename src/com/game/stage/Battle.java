package com.game.stage;

import java.util.Scanner;

import com.game.GameInformation;
import com.game.card.Card;
import com.game.card.CardReward;
import com.game.character.Character;
import com.game.enemy.Enemy;
import com.game.enemy.TheGuardian;
import com.game.play.Ending;

public class Battle implements GameInformation {
	
	Scanner sc = new Scanner(System.in);
	private Character player;
	private Enemy enemy;
	
	private int[] cardCnt;							// draw()에서 플레이어가 같은 카드를 뽑지 않게 하기위한 변수
	private int cnt; 								// cardCnt의 cnt
	private Card[] hand = new Card[10];				// 전투시 덱에서 뽑은 카드. '패'라고 함.
	private int handCnt = 0;						// 패의 수를 저장하는 변수
	
	private int maxEnergy;							// 매 턴 얻게되는 최대 에너지
	public static int nowEnergy;					// 현재 에너지. 카드를 사용하면 카드의 Cost만큼 감소한다.
	private boolean isUse;							// 카드의 사용여부를 저장하는 메소드
	private boolean battleEnd;						// 전투가 끝남을 판별하는 메소드
	
	public Battle(Character player, Enemy enemy) {
		this.setPlayer(player);
		this.enemy = enemy;
		this.maxEnergy = player.getMaxEnergy();
	}
	
	/* 전투 실행 메소드
	 * 적의 행동을 먼저 출력하고,
	 * player가 카드를 뽑고 사용한다.
	 * player가 턴을 종료할 경우, enemy가 예고한 행동을 수행한다.
	 * player의 체력이 0이 된 경우, badEnd()를 실행하며,
	 * enemy의 체력이 0이 된 경우, battle을 종료하고 battleEnd()를 출력한다.
	 * */
	public void fight() {
		System.out.println(enemy.getName() + "이 나타났습니다!");
		int turnCnt = 1;
		while(true) {
			System.out.println(turnCnt+ "턴입니다.");
			nowEnergy = maxEnergy;									// 에너지를 최대에너지로 조정
			readyToBattle(player);									// 턴 시작시 이전 전투의 정보 초기화
			
			for(int i = 0; i < GameInformation.DRAW_CARDS; i++) {	// 카드 뽑기
				hand[i] = draw(player);
				handCnt++;
			}
			
			int input = 0;
			while(input != -1) {
				showBattleInformation(player, enemy);
				enemy.printPattern(turnCnt);						// 전투 시작시 적이 할 행동 출력
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
			System.out.println();
		}
	}
	
	/** 턴 시작시 필요한 카운터들을 초기화하는 메소드
	 * 	cardCnt : 덱에서 draw한 카드를 중복되지 않게 하기위해, 이미 뽑은 deck의 인덱스를 저장하는 int[];
	 *  cnt : cardCnt의 cnt
	 *  handCnt : 손패의 카드 수를 세는 카운터
	 * */
	public void readyToBattle(Character player) {
		cardCnt = new int[player.getDeckCnt()]; 						
		cnt = 0;
		handCnt = 0;
	}
	
	/* 카드를 뽑는 메소드
	 * deck을 가져와 deck의 카드를 랜덤으로 1장 반환하며, 반환된 카드의 정보를 cardCnt에 저장한다.
	 * 만약 반환하려는 카드가 이미 cardCnt에 존재하는 경우, 다시 카드를 뽑는다.
	 * */
	public Card draw(Character player) {
		Card result;
		while(true) {
			boolean doReroll = false;
			int random = (int)(Math.random() * player.getDeckCnt());
			for(int i = 0; i <= cnt; i++) {
				if(random == cardCnt[i] || player.getDeck()[random] == null) {
					doReroll = true;
					break;
				}
				if(i == cnt) {
					cardCnt[i] = random;
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

	/* 현재 전투에 참여중인 두 객체의 정보를 출력하는 메소드 */
	public void showBattleInformation(Character player, Enemy enemy) {
		System.out.println("플레이어 정보");
		player.getStatus().printInformation();
		System.out.println("----------------");
		System.out.println("적 정보");
		enemy.getStatus().printInformation();
	}
	
	/* enemy의 체력을 0으로 만들어 battle()에서 승리시 수행되는 메소드
	 * 쓰러뜨린 enemy의 type에 따라 수행되는 결과가 다름.
	 * */
	public void battleEnd(Enemy enemy) {
		System.out.println("몬스터를 처치했습니다!");
		if("normal".equals(enemy.getType())) {
			System.out.println("카드보상을 획득합니다!");
			Card reward = new CardReward().getReward(getPlayer());
			player.addCard(reward);
		}else if("elite".equals(enemy.getType())) {
			System.out.println("카드보상을 획득합니다!");
			Card reward = new CardReward().getReward(getPlayer());
			player.addCard(reward);
			System.out.println("두번째 카드보상!");
			reward = new CardReward().getReward(getPlayer());
			player.addCard(reward);
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
