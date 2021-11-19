# 미션 - 숫자 야구 게임

## 구현목록

#### Application

* 게임 시작

#### RandomUtils

* 임의의 3자리숫자 생성

#### Answer
* RandomUtils에서 받은 숫자가 서로 다른지 판별

#### Console

* Input 입력 받기
* Print 출력하기

#### MakeException

* console에서 받은 입력이 exception인지 판단하기.
  * 0~9에 해당하는 수가 아닐경우
  * 3자리 숫자가 아닐 경우ssd
  * 중복된 숫자가 포함될 경우

* exception인 경우 : throw IllegalArgumentException
* exception이 아닌 경우 : hint

#### Hint

* 입력과 answer을 비교하기.
  * 정답일경우 -restart
  * 낫싱
  * 스트라이크만 존재
  * 볼만 존재
  * 스트라이크 + 볼

#### Restart

* input 입력 받기
  * 1일경우 재시작, 2일경우 끝
  * 다른 경우exception 발생