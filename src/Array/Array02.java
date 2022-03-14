package Array;

import java.util.Scanner;

/**
 * 02-02 보이는 학생
 * 2022-03-11: ⭕
 * 02-01의 연장
 */
public class Array02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] heights = new int[count];
        for (int i=0; i<count; i++) {
            heights[i] = scanner.nextInt();
        }

        //int answer = personal01(heights);
        int answer = solution(count, heights);
        System.out.println(answer);
    }

    /**
     * 내가 풀기 1
     * 이전 높이 중 가장 높은 애보다 높은 애가 나오면 보임 & 그 애가 다시 가장 높은 애로 됨
     * preHeight = 0으로 초기화
     * 반복문 돌면서 preHeight 보다 높으면 결과에 추가 & preHeight 변경
     */
    private static int personal(int[] heights) {
        int preHeight = 0;
        int answer = 0;
        for (int h : heights) {
            if (h > preHeight) {
                answer++;
                preHeight = h;
            }
        }
        return answer;
    }

    /**
     * 강의 풀이
     * 나와 거의 동일.
     * 배울점: 변수 초기화 부분. 나의 짧은 생각으로 0으로 초기화했지만, 강의 풀이를 보면 첫번째 사람 값으로 초기화해도 로직 깔끔함!
     */
    private static int solution(int count, int[] array) {
        int answer = 1, max = array[0]; // 첫번째 사람 값으로 초기화를 함. 깔끔함
        for (int i=0; i<count; i++) {
            if (array[i] > max) {
                answer++;
                max = array[i];
            }
        }
        return answer;
    }
}
