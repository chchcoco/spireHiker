package com.game.play;

import com.game.character.Character;
import com.game.enemy.*;
import com.game.stage.Battle;
import com.game.stage.GameStage;
import com.game.stage.StartEvent;

public class HikingSpire {

    private int floor = 1;
    private Enemy[] enemyArr = {new Cultist(), new JawWorm(), new Louse(), new Slaver(), new Slime()};

    public void hiking(Character player) {
        while(true){
            System.out.println(floor + "층입니다.");
            randomStage(floor, player);

            floor++;
        }

    }

    public void randomStage(int floor, Character player) {
        if(floor == 1){							//시작 이벤트
        	System.out.println("입구 앞의 요정이 첩탑을 오르기 전 보상을 선택하라고 합니다.");
        	GameStage stage = new StartEvent();
        	stage.entry(player);
        } else if(floor == 2){					//일반 전투
        	System.out.println("적이 나타났습니다!");
            Enemy enemy = ((int)(Math.random()*2)==0)? new JawWorm() : new Louse();
        	Battle battle = new Battle(player, enemy);
        	battle.fight(player, enemy);
        	player = battle.getPlayer();
        } else if(floor == 10){					 //휴식
        	System.out.println("휴식합니다. 체력이 30% 회복합니다.");
            player.getStatus().heal((int)(player.getStatus().getMaxHp() * 0.3));
        } else if(floor == 11){
            //보스 전투
        } else{
            int random = (int)(Math.random() * 100) + 1;
            if(random <= 55 && random > 0){
                //일반 전투
            	System.out.println("적이 나타났습니다!");
            	int randomEnemy = (int)(Math.random() * enemyArr.length);
            	Battle battle = new Battle(player, enemyArr[randomEnemy]);
            	battle.fight(player, enemyArr[randomEnemy]);
            	player = battle.getPlayer();
            } else if(random > 55 && random <= 85){
                //랜덤 이벤트
            } else if(random > 85 && random <= 95){
                // 휴식
            	System.out.println("휴식합니다. 체력이 30% 회복합니다.");
                player.getStatus().heal((int)(player.getStatus().getMaxHp() * 0.3));
            } else {
            	System.out.println("강한 적이 나타났습니다! 주의하세요!");
                Enemy elite = new GremlinNob();
                Battle battle = new Battle(player, elite);
                battle.fight(player, elite);
                player = battle.getPlayer();
            }
        }
    }
    
}
