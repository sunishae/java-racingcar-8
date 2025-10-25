
# java-racingcar-precourse

---

![Generic badge](https://img.shields.io/badge/precourse-week2-green.svg)

> 우아한테크코스 백엔드 8기 2주차, 자동차 경주를 구현한 저장소입니다. 
 
--- 

## 기능 구현 목록(ToDo List)

-  **RaceController (컨트롤러)**
    - [ ] run() : 게임 전체 흐름 제어
      - 입력 : InputView.readCarNames()로 자동차 이름 문자열 입력받기
      - 파싱/객체화 : ParseCar.parse()를 통해 유효성 검사를 거친 List&lt;Car&gt; 받기
      - 입력 : InputView.readRoundCount()를 통해 유효한 경주 횟수 입력받기
      - 게임 루프 : while (횟수 > 0) 동안 다음을 반복: 
        - RaceGame.flyLap() 실행 및 OutputView.printRoundResult() 호출
      - 우승자 결정 : WinnerCheck.getWinners()를 통해 우승자 이름 리스트 추출
      - 결과 출력 : OutputView.printWinners() 호출 후 종료


- **Car (모델)**
    - 속성 : name (String), position (Int)
    - 기능 :
        - [ ] move(): 무작위 값(4 이상)에 따라 position을 1 증가


- **InputView (입력)**
    - [ ] readCarNames() : 자동차 리스트 문자열 입력
    - [ ] readRoundCount() : 경주 횟수 입력
      - IllegalArgumentException : 숫자 변환 및 1회 미만 예외 처리


- **OutputView (출력)**
    - [ ] printRoundResult(List&lt;Car&gt;) : 한회차가 끝난 후 모든 자동차의 현재 상태출력
    - [ ] printWinners(List&lt;String&gt;) : 최종 우승자 이름 목록 출력


- **ParseCar (파싱)**
  - [ ] parse(String) : 문자열 파싱 후 List&lt;Car&gt; 생성 및 반환
    - IllegalArgumentException : 이름 5자 이하 및 이름 공백/빈 값 등의 유효성 검사


- **RaceGame (게임 로직)**
  - [ ] flyLap(List&lt;Car&gt;) : 전달받은 자동차 리스트에 대해 난수 생성 및 Car.move() 호출


- **WinnerCheck (우승자 판별)**
  - [ ] getWinners(List&lt;Car&gt;) : 최대 거리를 기준으로 우승자 이름(String) 리스트 추출 및 반환


--- 

