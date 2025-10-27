# java-racingcar-precourse

---

![Generic badge](https://img.shields.io/badge/precourse-week2-green.svg)

> 우아한테크코스 백엔드 8기 2주차, 자동차 경주를 구현한 저장소입니다.


--- 

## 기능 구현 목록(ToDo List)

---

- **RaceController (컨트롤러)**
    - [x] run() : 게임 전체 흐름 제어
        - 입력 : InputView.readCarNames()로 자동차 이름 문자열 입력받기
        - 파싱/객체화 : ParseCar.parse()를 통해 유효성 검사를 거친 List&lt;Car&gt; 받기
        - 입력 : InputView.readRoundCount()를 통해 유효한 경주 횟수 입력받기
        - 게임 루프 : while (횟수 > 0) 동안 다음을 반복:
            - RaceGame.race() 실행 및 OutputView.printRoundResult() 호출
        - 우승자 결정 : WinnerCheck.getWinners()를 통해 우승자 이름 리스트 추출
        - 결과 출력 : OutputView.printWinners() 호출 후 종료


- **Car (모델)**
    - 속성 : name (String), position (Int)
    - 기능 :
        - [x] move(): 무작위 값(4 이상)에 따라 position을 1 증가


- **InputView (입력)**
    - [x] readCarNames() : 자동차 리스트 문자열 입력
    - [x] readRoundCount() : 경주 횟수 입력
        - IllegalArgumentException : 숫자 변환 및 1회 미만 예외 처리


- **OutputView (출력)**
    - [x] printRoundResult(List&lt;Car&gt;) : 한회차가 끝난 후 모든 자동차의 현재 상태출력
    - [x] printWinners(List&lt;String&gt;) : 최종 우승자 이름 목록 출력


- **ParseCar (파싱)**
    - [x] parse(String) : 문자열 파싱 후 List&lt;Car&gt; 생성 및 반환
    - [x] validateName(String) : 문자열에 대한 유효성 검사


- **RaceGame (게임 로직)**
    - [x] race(List&lt;Car&gt;) : 전달받은 자동차 리스트에 대해 난수 생성 및 Car.move() 호출


- **RoundValidator (유효성 검사)**
    - [x] validateAndParse(String) : 전달받은 횟수 문자열을 검사하고 정수형으로 변환


- **WinnerCheck (우승자 판별)**
    - [x] getWinners(List&lt;Car&gt;) : 최대 거리를 기준으로 우승자 이름(String) 리스트 추출 및 반환

--- 

## 📁 파일 구조 및 설계

---

    src/main/java/racingcar
    ├── Application.java              // 프로그램 실행의 시작점 및 객체 조립
    |
    ├── controller
    │   └── RaceController.java       // 게임 입출력 및 로직의 실행 흐름 제어
    |
    ├── view
    │   ├── InputView.java            // 사용자 입력 담당 (Console.readLine)
    │   └── OutputView.java           // 결과 출력 담당 (System.out.println)
    |
    └── domain
        ├── Car.java                  // 자동차의 이름과 위치, 이동 규칙을 정의
        ├── ParseCar.java             // 자동차 이름 문자열 파싱 및 유효성 검증
        ├── RaceGame.java             // 경주 1회전 진행 (난수 생성 및 Car.move() 요청)
        ├── RoundValidator.java       // 시도 횟수 문자열 유효성 검증 및 정수 변환
        └── WinnerCheck.java          // 최종 우승자 판별 및 추출

---
