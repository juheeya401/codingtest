package inflearnCodingTest.String;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 01-10 가장 짧은 문자거리 ⭐️⭐️
 * 2022-03-10: ❌ (푸는 방법을 아예 몰랐다. 탐색 방법 중 하나 인 것 같다. 강의에서 알려준 알고리즘 제대로 이해하기)
 */
public class String10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        char x = scanner.next().charAt(0);
        personal02(text, x);
    }

    /**
     * 강의 전 풀기❌
     * 풀이: 각 문자 반복 -> 좌/우로 가면서 문자 비교 후 같으면 break(i=0~length, j=1~length)
     */
    public static void personal01(String text, final char x) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int minDistance = 0;
            if (x != text.charAt(i)) {
                for (int j = 1; j < text.length(); j++) {
                    char leftChar = 0;
                    char rightChar = 0;
                    if (i - j > 0) {
                        leftChar = text.charAt(i - j);
                    }
                    if (i + j < text.length()) {
                        rightChar = text.charAt(i + j);
                    }
                    if (leftChar == x || rightChar == x) {
                        minDistance = j;
                        break;
                    }
                }
            }
            stringBuilder.append(minDistance + " ");
        }
        System.out.println(stringBuilder.toString().trim());
    }

    /**
     * 강의 해설 들은 후 & 코드 보기 전 ⭕ ️
     * 결과: 정답. but 일부 java 함수를 사용해서 간단하게 표현 가능
     */
    private static void personal02(String text, final char x) {
        int[] answer = new int[text.length()];
        int P = 1000;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != x) P++;
            else P = 0;
            answer[i] = P;
        }
        P = 1000;
        for (int i = text.length() - 1; i >= 0; i--) {
            if (text.charAt(i) != x) P++;
            else P = 0;
            if (answer[i] > P) answer[i] = P; // Math.min()함수 이용하자
        }
        Arrays.stream(answer).forEach(e -> System.out.print(e + " "));
    }

    /**
     * 강의 풀이
     */
    public static void solution(String text, char x) {
        for (int answerOne : solution_in(text, x)) {
            System.out.print(answerOne + " ");
        }
    }

    private static int[] solution_in(String text, char x) {
        int[] answer = new int[text.length()];
        int p = 1000;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == x) {
                p = 0;
            } else {
                p++;
            }
            answer[i] = p;
        }
        p = 1000;
        for (int i = text.length() - 1; i >= 0; i--) {
            if (text.charAt(i) == x) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p); // 둘 중 작은 값을 answer[i]에 넣는다. Math.min() 함수!
            }
        }
        return answer;
    }
}
