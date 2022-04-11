# codingtest
알고리즘&amp;자료구조

# 인프런 코딩테스트 대비 (Java)

[03-02. 공통원소 구하기](src/inflearnCodingTest/TwoPointer/TwoPointer02.java)

[03-03. 최대 매출](src/inflearnCodingTest/TwoPointer/TwoPointer03.java)

## TwoPointer
* inflearnCodingTest.TwoPointer 문제
* inflearnCodingTest.TwoPointer 문제는 정렬이 필요한 것 같다.
* 정렬된 두 배열에 투 포인터로 처리


## 슬라이딩윈도우
* 영역만큼 윈도우를 이동하면서 N번만 반복한다.

## 해쉬맵

## Stack, Queue

## 재귀함수
* 스택 프레임에 저장된다.
* 스택 프레임에 3개 정보 저장됨: 매개변수, 지역변수, 복귀주소
* 모든 재귀함수는 반복문을 이용하여 동일한 기능을 구현할 수 있다.
* (재귀함수는 스택프레임을 생성하고 저장해야 하기 때문에 단순 반복문보다 느려질 수 있다)
* 이해하기 어려운 코드가 될 수 있으니 신중하게 작성해야 한다.

## DFS
* 깊게 검색
* 깊이 우선 탐색
* 스택 자료구조 사용됨

## BFS
* 넓게 검색
* 최단거리 검색
* 큐 자료구조 사용됨
* Queue<Node> Q = new LinkedList<>();
* Q.offer(root); // 데이터 삽입
* Q.poll(); // 데이터 출력(처음 들어간 데이터)

# 복잡도에 따른 알고리즘 설계
![image](https://user-images.githubusercontent.com/52496734/162666452-0d36e41d-4698-4788-82da-43ca9582f978.png)

# 정렬
대부분 프로그래밍 언어에서 지원하는 **표준 정렬 라이브러리는 최악의 경우에도 O(NlogN)을 보장**하도록 설계되어있다.
## 정렬 알고리즘 비교
정렬 알고리즘 : 평균 시간 복잡도 : 공간 복잡도 : 특징
    
선택 정렬    : O(N^2)       : O(N)     : 아이디어가 매우 간단하다. 제일 작은수를 선택해서 i와 바꾼다.
    
삽입 정렬    : O(N^2)       : O(N)     : 데이터가 거의 정렬되어 있을 때 가장 빠르다. left/right 중 적절한 위치에 삽입한다.
 
퀵 정렬     : O(NlogN)     : O(N)     : 



# 마크다운 작성 샘
<details>
<summary>토글</summary>

    토글 내부에 작성할 내용을 여기에 쓴다.
    위, 아래에 한 줄씩 떼고, 앞에 탭을 둬야 네모 영역에 쓰여진다.

</details>

