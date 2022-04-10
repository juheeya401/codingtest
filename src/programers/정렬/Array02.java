package programers.정렬;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 정렬 > 가장 큰 수
 * ⭐️ 컨셉, 그 외 구현방법 등 공부 할 게 많다!! 꼭 성공 코드의 주석들을 읽어보자
 * #우선큐 #우선순위큐 #PriorityQueue
 * 우선큐설명: https://coding-factory.tistory.com/603
 * <p>
 * 문제 설명
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * 제한 사항
 * numbers의 길이는 1 이상 100,000 이하입니다.
 * numbers의 원소는 0 이상 1,000 이하입니다.
 * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 * 입출력 예
 * numbers	            return
 * [6, 10, 2]	        "6210"
 * [3, 30, 34, 5, 9]	"9534330"
 */

/**
 * [개념정리]
 * 1. String 두 개를 더하면 사칙연산이 아닌, 문자열로써 이어진다. => String a='1', String b='2'일 때 a+b='12'임!
 * 2. ⭐️핵심⭐️ "조합한 문자열"을 내림차순으로 정렬하는 아이디어
 * : 문자열 a와 b를 (b + a) - (a + b) 하면됨! / 오름차순은 (a + b) - (b + a)로!
 * : 즉, 단순히 역순 정렬한다고 능사가 아니다. ((30, 3) -> 303 보다 330이 더 크기 때문에!)
 * : b.compareTo(a) 가 아닌 (b + a).compareTo(a + b) 로 구현해야 하는 이유다.
 * 3. 문자열 비교 정렬은 String.compareTo(String)로 한다.
 * : 찾은 그대로 빼기(-)로 했다가 Integer.parseInt()썼더니 런타임 오류^^
 * 4. 생각못한 점 : 문제 파라미터가 0으로만 이루어진 배열이 들어온 경우 return '0'을 해야함.
 */
public class Array02 {
    public static void main(String[] args) {
        Array02 main = new Array02();
        int[] array1 = new int[]{6, 10, 2};
        int[] array2 = new int[]{3, 30, 34, 5, 9};

        String solution02 = main.solution02(array1);
        System.out.println("solution02 array1 = " + solution02);
        String solution02_array2 = main.solution02(array2);
        System.out.println("solution02_array2 = " + solution02_array2);

        String solution03_array1 = main.solution03(array1);
        System.out.println("solution03_array1 = " + solution03_array1);
        String solution03_array2 = main.solution03(array2);
        System.out.println("solution03_array2 = " + solution03_array2);


/*        String solution = main.solution(array2);
        System.out.println("solution = " + solution);*/
    }

    /**
     * 2022-04 ⭐️
     * 컨셉: 원래 컨셉을 유지하되, 복잡도가 O(NLogN)라는 우선순위큐를 사용해본다.
     * 주의사항: 반복문 조건에 queue.size() 를 이용하지 말자!
     * 주의사항: String substring()보다 carAt() 를 사용하자!
     */
    public String solution03(int[] numbers) {
        String answer = "";

        // 정렬기준대로 출력하는 큐 생성
        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b)); // 정렬기준은 원래 컨셉과 동일하다.
        for (int number : numbers) {
            queue.add(number + "");
        }
        // 반복문 실행 시 주의사항! queue.size()로 조건을 넣으면 안된다!!!! queue.remove()로 제거하기 때문에 사이즈가 계속 달라지기 때문이다!!
        //System.out.println("q:" + queue.size() + ", num=" + numbers.length); // q:5, num=5
        //for (int i=0; i<queue.size(); i++) {
        for (int i = 0; i < numbers.length; i++) {
            answer += queue.remove();
        }

        // 맙소사!!!!!! 여기서 성능차이가 나다니. String.substring()보다 String.carAt() 가 더 빠르다!!!!
        // 안에 구현 소스를 뜯어보면 이유를 알 수 있다.
        // 가장 큰 차이는 substring()은 new String()으로 객체를 만들고, charAt()은 배열에서 바로 꺼낸다. 당연히 빠를 수밖에!!!
        //if (answer.substring(0, 1) == "0") answer = "0"; // 다른건 다 똑같고 이부분만 있으면 실패한다!!!
        if (answer.charAt(0) == '0') answer = "0"; // String.carAt() 다른건 다 똑같고 이 부분만 바꿧는데 성공했다.
        return answer;
    }


    /**
     * 2022-04
     * 컨셉: 원소를 String으로 바꿔서 앞자리가 큰 수부터 내림차순 정렬하여 조합한다.
     * 결과: ❌. 원인: 정렬 시 단순 역순으로만 정렬하면 안됨. (30, 3) -> 303 보다 330이 더 크다!
     * 결과: ❌ 타임아웃.
     * 복잡도: N+N+N -> O(N) 으로 예상됨.
     */
    public String solution02(int[] numbers) {
        String answer = Arrays.stream(numbers)
                .mapToObj(e -> Integer.toString(e))
                //.sorted(Comparator.reverseOrder())
                .sorted((a, b) -> (b + a).compareTo(a + b))  // 이 부분이 틀린 이유.
                .collect(Collectors.joining());
        if (answer.substring(0, 1) == "0") answer = "0";
        return answer;
    }

    /**
     * 2021-03
     * 컨셉: 찾아서 했음.
     * 2022-04 기준 실패하는 코드 -> 타임아웃 남.
     */
    public String solution01(int[] numbers) {
        String answer = Arrays.stream(numbers)
                .mapToObj(String::valueOf)                  // !기본형->참조형으로 변환이니까 map()를 쓰면 에러남!
                .sorted((a, b) -> (b + a).compareTo(a + b)) // Comparator구현한 람다 리턴(반환=int타입)
                .collect(Collectors.joining());

        if (answer.substring(0, 1).equals("0"))
            answer = "0";    // 앞자리가 0이면 모든 문자열이 0이란의미 (numbers 배열에 {0,0,0} 처럼 모두 0으로 들어오는 경우 대비)

        return answer;
    }
}
