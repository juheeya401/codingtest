package inflearnCodingTest.Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 02-07. 점수계산
 * 2022-04-05: ⭕ => BUT, 강의 풀이가 훨씬 간단하다. 내 풀이는 쓸데없이 복잡하게 생각함.
 */
public class Array07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        solution(scanner);
    }

    /**
     * 혼자하기(전) ⭕
     * 전체 점수 갯수+1 길이의 scores 배열을 만들어서 0으로 세팅.
     * 입력된 채점결과를 체크하면서 배열에 앞 점수와 합산해서 scores 배열에 저장
     * 마지막에 scores 배열의 모든 값을 합산해서 리턴
     */
    static void personal(Scanner scanner) {
        int count = scanner.nextInt();
        int[] scores = new int[count+1];    // count+1 아래 반복문에서 맨 첫번째 점수부터 계산하기 위해 +1을 했다. scores[0]은 0으로 세팅되며 의미없는 값이다.
        for (int i=1; i<=count; i++) {      // 위에서 count+1을 했기 때문에 마지막에 배열이 1개 늘었다. 따라서 <= 로 연산해야 마지막 점수까지 계산된다.
            int score =  scanner.nextInt();
            if (score == 1) {
                scores[i] = scores[i-1] + score;
            }
        }

        int sum = Arrays.stream(scores).sum();
        System.out.println(sum);
    }

    /**
     * 강의 풀이
     * 나랑 다름
     * 강의풀이가 훨씬 간단하다.★
     */
    static void solution(Scanner scanner) {
        int count = scanner.nextInt();
        int[] scores = new int[count];
        for (int i=0; i<count; i++) {
            scores[i] = scanner.nextInt();
        }
        System.out.println(solutionCul(count, scores));
    }

    private static int solutionCul(int count, int[] scores) {
        int sum = 0;
        int cnt = 0;

        for (int i=0; i<count; i++) {
            if (scores[i]==1) {
                cnt++;
                sum += cnt;
            } else {
                cnt = 0;
            }
        }
        return sum;
    }
}
