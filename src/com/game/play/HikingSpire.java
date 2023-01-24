package com.game.play;

import com.game.character.Character;
import com.game.enemy.*;
import com.game.stage.Battle;
import com.game.stage.*;
import com.game.stage.StartEvent;

public class HikingSpire {

    private int floor = 1;
    private Enemy[] enemyArr = {new Cultist(), new JawWorm(), new Louse(), new Slaver(), new Slime()};

    /* 메인 등반 메소드
     * 캐릭터를 골라 선택하면 바로 이 메소드가 실행된다.
     * 층에 따라 각기 다른 이벤트를 출력하는 randomStage()메소드를 실행시킨다.
     * */
    public void hiking(Character player) {
        while(true){
        	System.out.println();
            System.out.println(floor + "층입니다.");
            randomStage(floor, player);
            floor++;
        }
    }

    /* 오른 층에 따라 랜덤으로 이벤트를 실행시키는 메소드
     * 1층은 시작보상, 2층은 일반전투, 10층은 휴식, 11층(마지막)층은 보스전으로 고정이벤트로 설정되어 있으며
     * 3층부터 9층까지는 확률로 랜덤발생되게 설정했다.
     * 해당 이벤트가 끝나면 다시 hiking()으로 돌아간다.
     * */
    public void randomStage(int floor, Character player) {
        if(floor == 1){							//시작 이벤트
        	System.out.println("입구 앞의 요정이 첩탑을 오르기 전 보상을 선택하라고 합니다.");
        	GameStage stage = new StartEvent();
        	stage.entry(player);
        } else if(floor == 2){					//일반 전투
        	System.out.println("적이 나타났습니다!");
            Enemy enemy = ((int)(Math.random()*2)==0)? new JawWorm() : new Louse();
        	Battle battle = new Battle(player, enemy);
        	battle.fight();
        	player = battle.getPlayer();
        } else if(floor == 10){					 //휴식
        	System.out.println("휴식합니다. 체력이 30% 회복합니다.");
            player.getStatus().heal((int)(player.getStatus().getMaxHp() * 0.3));
        } else if(floor == 11){
        	System.out.println("당신은 드디어 마지막 층에 다닿았습니다.");
        	System.out.println("마지막 보스만이 당신을 기다립니다.");
        	Enemy enemy = new TheGuardian();
        	Battle battle = new Battle(player, enemy);
        	battle.fight();
        	return;
        } else{
            int random = (int)(Math.random() * 100) + 1;
            if(random <= 55 && random > 0){
                //일반 전투
            	System.out.println("적이 나타났습니다!");
            	int randomEnemy = (int)(Math.random() * enemyArr.length);
            	Enemy enemy = returnEnemy(enemyArr[randomEnemy]);
            	Battle battle = new Battle(player, enemy);
            	battle.fight();
            	player = battle.getPlayer();
            } else if(random > 55 && random <= 85){
                GameStage[] event = {new CardCopyEvent(), new CardExchangeEvent(), new HolyWater()};
                random = (int)(Math.random() * event.length);
                event[random].entry(player);
            } else if(random > 85 && random <= 95){
                // 휴식
            	System.out.println("휴식합니다. 체력이 30% 회복합니다.");
                player.getStatus().heal((int)(player.getStatus().getMaxHp() * 0.3));
            } else {
            	System.out.println("강한 적이 나타났습니다! 주의하세요!");
                Enemy elite = new GremlinNob();
                Battle battle = new Battle(player, elite);
                battle.fight();
                player = battle.getPlayer();
            }
        }
    }
    
    public Enemy returnEnemy(Enemy enemy) {
    	Enemy result;
    	if("광신자".equals(enemy.getName())){
    		result = new Cultist();
    	} else if("턱벌레".equals(enemy.getName())) {
    		result = new JawWorm();
    	} else if("공벌레".equals(enemy.getName())) {
    		result = new Louse();
    	} else if("노예 상인".equals(enemy.getName())) {
    		result = new Slaver();
    	} else if("슬라임".equals(enemy.getName())) {
    		result = new Slime();
    	} else {
    		result = new Cultist();
    		System.out.println("까마귀 군주께서 나를 불렀다.");
    	}
    	
    	return result;
    }
    
}
