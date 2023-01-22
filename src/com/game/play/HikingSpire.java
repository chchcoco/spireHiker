package com.game.play;

import com.game.character.Character;
import com.game.stage.Battle;
import com.game.stage.GameStage;
import com.game.stage.StartEvent;

public class HikingSpire {

    private int floor = 1;


    public void hiking(Character player) {
        while(true){
            
            randomStage(floor, player);

            floor++;
        }

    }

    public void randomStage(int floor, Character player) {
        if(floor == 1){							//시작 이벤트
        	GameStage stage = new StartEvent();
        	stage.entry(player);
        } else if(floor == 2){					//일반 전투
            //적 생성 Enemy enemy = 적();
        	Battle battle = new Battle(player, enemy);
        } else if(floor == 10){
            //휴식
        } else if(floor == 11){
            //보스 전투
        } else{
            int random = (int)(Math.random() * 100) + 1;
            if(random <= 55 && random > 0){
                //일반 전투
            } else if(random > 55 && random <= 85){
                //랜덤 이벤트
            } else if(random > 85 && random <= 95){
                // 휴식
            } else {
                //정예 전투
            }
        }
    }
    
}
