package Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 02-05 소수(에라토스테네스 체)
 * 2022-03-11: ❌ (에라토스테네츠 체를 구현하는 방법 미숙)
 */
public class Array05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        //personal(count);
        //personal02(count);
    }

    /**
     * 전) 내가하기
     * 시간초과
     */
    private static void personal(int limit) {
        // 소수: 1과 자기자신을 제외한 숫자로 나누었을 때 나누어 떨어지지 않는 수
        int answer = 1;
        int number = 3;
        while (number <= limit) {
            boolean isSosu = true;
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isSosu = false;
                    break;
                }
            }
            if (isSosu) answer++;
            number++;
        }
        System.out.println(answer);
    }

    /**
     * 강의 후 + 소스 보기 전) 내가 하기 ⭕
     * (에라토스테네스 체 - 알려진 가장 빠른 소수찾기)
     */
    private static void personal02(int limit) {
        int answer = 0;
        int[] array = new int[limit+1];     // 주의! index가 소수가 되므로, limit만큼이 아니라, limit+1 갯수만큼 배열을 생성한다
        Arrays.fill(array, 0);
        for (int i = 2; i <= limit; i++) {
            if (array[i] == 0) {
                answer++;
                for (long j = i; j <= limit; j = j + i) {
                    array[(int) j] = 1;
                }
            }
        }
        System.out.println(answer);
    }

    /**
     * 강의 풀이
     * (에라토스테네스 체 - 알려진 가장 빠른 소수찾기)
     */
    private static void solution(int limit) {
        int answer = 0;
        int[] ch = new int[limit + 1];   // 주의! index가 소수가 되므로, limit만큼이 아니라, limit+1 갯수만큼 배열을 생성한다
        for (int i = 2; i <= limit; i++) {  // 주의! i는 limit까지 연산해야 함
            if (ch[i] == 0) {   // 0이면 소수!
                answer++;
                for (int j = i; j <= limit; j = j + i) { // j도 역시 limit 까지 연산!
                    ch[j] = 1;
                }
            }
        }
        System.out.println(answer);
    }
}
