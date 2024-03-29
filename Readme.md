# SpireHiker

## 게임 내용    


>캐릭터를 고르고 선택한 캐릭터로 11층 짜리 첨탑을 오르는 덱빌딩 카드게임    
>원작의 로그라이크 게임을 열화하고 축소시켜 만든 랜덤 운빨망겜 게임이다.    
>일부 층을 제외한 층들은 확률에 따라 일반 전투, 정예 전투, 휴식, 이벤트 중 하나의 상황을 겪게되고 정상층에서 보스와의 전투를 치르게 된다.    
>보스를 쓰러뜨리고 탑의 정상으로 올라가면 승리하는 조건을 가지며, 정상에 오르기 전에 플레이어의 체력이 0이 되면 패배하는 구조로 설계되어 있다.    
    

## 요구사항
### 카드(Card)
> 카드는 스킬카드와 공격카드, 두 타입으로 나눠지며 각각의 카드마다 실행되는 고유의 동작이 존재한다.    
> ~~게임을 실행하기 위해서는 전체 카드 리스트와, 덱이 필요하다.~~ (캐릭터 내의 필드로 저장)     
> 전체 카드 리스트는 게임에 등록된 모든 카드들이 중복없이 저장되어있는 리스트이다.    
> 선택한 캐릭터에 따라 등장하는 카드들이 다르다.   
> 덱은 플레이어가 탑을 오르며 사용하는 카드뭉치이며, 카드들을 중복으로 가질 수 있다.  
- 공격카드와 스킬카드가 구분되어야 한다.
### 캐릭터(Character)
> 캐릭터는 캐릭터마다 고유의 필드값과 고유 능력을 가진다.    
> 또한 캐릭터마다 등장하는 카드가 다르다.

### 적(Enemy)
> 적은 적마다 고유의 필드값과 고유의 행동패턴을 가진다. 이 행동패턴은 전투의 턴에 영향을 받는다.    
> 또한 type값으로 normal, elite, boss 3가지 타입을 가지는데, 이에 따라 처치시 발생하는 이벤트가 다르며, 실행되는 전투 이벤트에 따라 등장하는 타입이 다르다.    

### 전투(Battle)

>전투는 턴제 전투 형식으로 치뤄지며 기본적으로 매 턴마다 덱에서 랜덤으로 5장을 가져온다.    
>적의 행동을 대략적으로 확인할 수 있으며, 적의 행동을 보고 덱에서 가져온 카드들 안에서 사용하면서 턴을 진행한다.    
>플레이어가 모든 행동을 끝낸 후 턴을 넘기면, 가져온 카드는 덱으로 되돌리고 적은 보여준 행동을 수행한다.    
>적의 행동이 끝나면 다시 새로운 턴이 시작되며 덱에서 가진 카드를 또다시 랜덤으로 5장을 가져온다.    
>전투는 적이나 캐릭터의 체력이 0이 되면 종료되고, 적의 캐릭터를 쓰러뜨리면 전투에서 승리한다.   
>캐릭터의 체력이 0이 되면, 게임이 종료된다.     
>전투에서 승리할 경우, 카드보상을 획득한다.    


### 카드보상(CardReward)
>캐릭터마다 가진 고유의 카드 풀에서 중복없이 3장을 보여준다.    
>플레이어는 3장 중 한장을 골라 덱에 카드를 추가할 수 있다.    
>희귀카드보상을 원할 경우, 희귀도가 Epic인 카드만 카드보상으로 나온다.


### ~~행동~~
> ~~주로 전투 중에 발생하는, 캐릭터나 적 객체가 필드로 갖고있는 Status클래스 인스턴스에 영향을 주는 행동들을 정의한 클래스.    
> 데미지 계산, 회복, 버프/디버프를 주는 담당한다.~~     
> 구현 중 별도의 클래스로 구현하는 것이 어색하여 대부분의 메소드들이 상태 클래스에서 구현되었다.

### 상태
> Character 및 Enemy 의 체력, 디버프 여부, 버프 수 등을 저장하는 클래스.    
> 데미지 계산, 디버프/버프 처리 메소드도 갖고 있다.

## 다이어그램
- Comunication Diagram
![상호작용 drawio](https://user-images.githubusercontent.com/117333258/214222545-1e525be5-714c-44e4-a4b1-0a2a6a6e8477.png)

- Class Diagram
![클래스 drawio](https://user-images.githubusercontent.com/117333258/214222676-cc69aee0-fd1e-4c93-93c1-a3c7cef5e0e2.png)
