Practice
===

문제 설명
---

x 축 상에 앞 뒤로만 이동할 수 있는 로봇이 0 위치에 놓여 있다.  
해당 로봇은 다음과 같은 규칙으로 움직일 수 있다.
* forward 방향으로는 a 만큼 움직일 수 있다.
* backward 방향으로는 b 만큼 움직일 수 있다.
* backward 로 연속해서 2번 움직일 수 없다.
* forbidden 위치로는 갈 수 없다.
* 음수 지역으로 갈 수 없다.

forbidden 배열과 a, b, 그리고 목적지 x 가 주어졌을 때,  
몇 번의 이동으로 목적지에 도달 할 수 있는지 계산하는 프로그램을 구현하세요.  
이동이 가능하면 이동횟수를, 이동이 불가능하면 -1을 반환하세요.



입출력 예시
---
|forbidden|a|b|x|결과|
|---|---|---|---|---|
|14, 4, 18, 1, 15|3|15|9|3|
|1, 6, 2, 14, 5, 17, 4|16|9|7|2|
|8, 3, 16, 6, 12, 20|15|13|11|-1|
