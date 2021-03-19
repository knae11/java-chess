# java-chess

체스 게임 구현을 위한 저장소

# 체스 게임 요구 사항

## 체스판 초기화

* 게임을 수행하는 체스 판이 존재한다
* 각 체스판에는 번호가 달려있다(a ~ h, 1 ~ 8 )
* 각 체스판은 검은색과 흰색으로 구별된다

# 체스 게임 TODO 리스트

## 체스판 초기화

- [] 체스 판 객체 생성
    - [] 체스 판은 왼쪽부터 a ~ h 이고, 세로는 아래부터 위로 1 ~ 8 로 구현한다.
    - [] 체스 판은 객체값이 들어간다.
- [] 말 객체 생성

## 말 이동

- [ ] 말 객체는 다음과 공통된 기능을 가진다
    - [ ] 움직임, 상태(alive, dead), 흑백 유무
- [ ] 말 객체는 다음과 같은 세분화된 piece 를 가진다
    - [ ] 킹
        - [ ] 킹은 8방향으로 1칸 움직일 수 있다
    - [ ] 퀸
        - [ ] 퀸은 8방향으로 체스판 어디든 움직일 수 있다
    - [ ] 룩
        - [ ] 룩은 4방향(십자가)으로 어디든 움직일 수 있다
    - [ ] 나이트
        - [ ] 나이트는 4방향(십자가)으로 한 칸, 움직인 칸을 기준으로 대각선 양방향으로 움직일 수 있다
        - [ ] 이 때 4방향(십자가)으로는 다른 기물이 있어도 움직일 수 있다.
    - [ ] 비숍
        - [ ] 비숍은 4방향(대각선)으로 어디든 움직일 수 있다.
    - [ ] 폰
        - [ ] 최초에 폰이 움직이지 않았다면 폰은 전방으로 2칸 움직일 수 있다.
        - [ ] 폰은 앞으로 한 칸 움직일 수 있다.
        - [ ] 단, 폰은 앞에 기물이 있을 경우 움직일 수 없으며, 폰이 상대바으이 기물을 잡기 위해서는 전방 대각선에 상대방의 기물이 존재해야 한다.


    