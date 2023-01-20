package com.game.stage;

import java.util.Scanner;

import com.game.card.Card;
import com.game.card.CardReward;
import com.game.character.Character;
import com.game.data.Action;

public class StartEvent implements GameStage{
    
    Scanner sc = new Scanner(System.in);
    String[] bonus = new String[3];

    public StartEvent(){
        bonus[0] = "카드 보상을 얻습니다.";
        bonus[1] = "최대 체력이 10% 증가합니다.";
        bonus[2] = "피해를 최대 체력의 20% 받고, 희귀 카드 보상을 얻습니다.";
    }

    @Override
    public void entry(Character player){
        int random = (int)(Math.random() * bonus.length);
        for(int i = 0; i < bonus.length; i++){
            if(random == i){
                continue;
            }
            System.out.println(i + ".)" + bonus[i]);
        }
        while(true){
            System.out.print("시작 보상을 선택하시오 : ");
            int input = sc.nextInt();
            if(input == 0 && random != 0){
                Card reward = new CardReward().getReward(player);
                if(reward != null) {
                	player.addCard(reward);
                }
                break;
            } else if(input == 1 && random != 1){
                int result = player.getStatus().getMaxHp();
                result = (int)(result * 1.1);
                player.getStatus().setMaxHp(result);
                break;
            } else if(input == 2 && random != 2){
                //데미지 20%
            	new Action().getDamage((int)(player.getStatus().getMaxHp() * 0.2), player.getStatus());
                //히히카드보상
            	Card reward = new CardReward().EpicCardReward(player);
            	if(reward != null) {
            		player.addCard(reward);
            	}
            } else {
                System.out.println("다시 골라주세요");
            } 
        
        }
    }

}