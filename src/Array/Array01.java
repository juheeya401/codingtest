package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 02-01 큰 수 출력하기
 * 2022-03-11 ⭕
 * 참고: Collectors 를 쓰면 체점 사이트에서 컴파일 에러가 난다.(왜지? 얘도 자바8 클래슨데?)
 * ⭐️ Scanner.next() 와 nextLine() 차이점. 주의사항 숙지!!
 */
public class Array01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        personal_main(scanner);
    }

    /**
     * 나의 풀이1
     */
    private static void personal_main(Scanner scanner) {
        int count = Integer.parseInt(scanner.nextLine());   // ⭐️ Scanner.next() 와 nextLine() 차이점. 주의사항 숙지!!
        String[] numbers = scanner.nextLine().split(" ");
        // 체점사이트에서 에러남. 하지만 정답은 맞음
        //List<Integer> integers = Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());
        personal(numbers);
    }
    // 이전 수 저장 -> 이전수와 비교해서 크면 출력
    private static void personal(String[] numbers) {
        int temp = Integer.MIN_VALUE;
        for (String s : numbers) {
            int n = Integer.parseInt(s);
            if (temp < n) {
                System.out.print(n + " ");
            }
            temp = n;
        }
    }

    /**
     * 나의 풀이2
     * 강의 보고 내꺼 보완
     */
    private static void personal02_main(Scanner scanner) {
        int count = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[count];
        for (int i=0; i<count; i++) {
            numbers[i] = scanner.nextInt();
        }
        personal02(numbers);
    }
    // 입력받을 때 int 타입으로 직접 받음
    private static void personal02(int[] numbers) {
        int temp = Integer.MIN_VALUE;
        for (int n : numbers) {
            if (temp < n) {
                System.out.print(n + " ");
            }
            temp = n;
        }
    }

    /**
     * 강의 풀이
     * 배울점: ⭐️입력받는 데이터를 다 사용함 & ⭐️입력받는 부분에서 굳이 형변환 하지 않음
     * 안배울점: for문 내에서 모든 연산이 끝나지 않고 for 문 전에 한 번 미리 결과를 저장해 줘야 함(첫 값은 무조건 출력해야 한다는 조건때문에)
     */
    private static void solution_main(Scanner scanner) {
        int count = scanner.nextInt();
        int[] array = new int[count];
        for (int i=0; i<count; i++) {
            array[i] = scanner.nextInt();
        }
        for(int x : solution(count, array)) {
            System.out.println(x + " ");
        }
    }

    private static List<Integer> solution(int count, int[] array) {
        List<Integer> answer = new ArrayList<>();
        answer.add(array[0]);
        for (int i=1; i<count; i++) {
            if (array[i] > array[i-1]) {
                answer.add(array[i]);
            }
        }
        return answer;
    }
}
