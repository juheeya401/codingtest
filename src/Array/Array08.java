package Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * todo 강의 & 풀기
 * 02-08. 등수구하기
 * 2022-04-05: ❌
 */
public class Array08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        personal(scanner);
    }

    /**
     * 입력값 정렬하고
     * max 길이만큼 배열 만들어서
     * 점수=index, 값=등수로 저장한다
     * 1등부터 매기고, 다음 점수도 같다면 등수 유지한다.
     * 출력할 때는 원래 받은 값들을 갖고 인덱스 찾아서 등수를 입력한다
     */
    static void personal(Scanner scanner) {
        int count = scanner.nextInt();
        int[] in = new int[count];
        for (int i=0; i<count;i++) {
            in[i] = scanner.nextInt();
        }

        int[] sort = Arrays.copyOf(in, count + 1);
        Arrays.sort(sort);

        int maxScore = sort[count-1];

        int[] ranking = new int[maxScore+1];
        for (int i=count-1; i<=0; i--) {
            int score = sort[i];// 점수
            if (score != sort[i+1]) {
                ranking[score] = count - i;
            }
        }

        // 출력
        for (int i=0; i<count; i++) {
            System.out.println(ranking[in[i]]);
        }

    }
}
