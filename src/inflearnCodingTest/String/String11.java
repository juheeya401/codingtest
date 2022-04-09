package inflearnCodingTest.String;

import java.util.Scanner;

/**
 * 01-11 문자열 압축
 * 생각치 못한 알고리즘! ⭐
 */
public class String11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        //System.out.println(personal(text));
        System.out.println(personal02(text));
        System.out.println(solution(text));
    }

    /**
     * 내가풀기1 ⭕
     * 지저분, 알고리즘따위 없음. 그냥 for/if 문 조합으로 짠 전형적인 떨어지는 코드 ㅎ
     */
    public static String personal(String text) {
        char target = text.charAt(0);
        int count = 0;
        StringBuilder answer = new StringBuilder();
        for (char x : text.toCharArray()) {
            if (target == x) {
                count++;
            } else {
                answer.append(target);
                if (count > 1) answer.append(count);
                target = x;
                count = 1;
            }
        }
        answer.append(target);
        if (count > 1) answer.append(count);
        return answer.toString();
    }

    /**
     * 강의 듣고 & 소스 안보고 ⭕⭐
     */
    public static String personal02(String text) {
        StringBuilder answer = new StringBuilder();
        text += " ";    // i와 다음값(i+1)과 비교하기 때문에 반드시 length를 1개 늘려야 한다!⭐️
        int count = 1;  // i와 다음값(i+1)과 비교하기 떄문에 count의 시작값은 1부터 시작한다(현재값(i)이 기준이까 현재값인 1을 추가하는 것임)
        for (int i = 0; i < text.length() - 1; i++) {   // 실제 반복은 임의로 늘린길이-1 이여야 하기 떄문에 -1을 한다
            if (text.charAt(i) == text.charAt(i + 1)) {
                count++;
            } else {
                answer.append(text.charAt(i));
                if (count > 1) answer.append(count);
                count = 1;
            }
        }
        return answer.toString();
    }

    /**
     * 강의풀이
     */
    public static String solution(String text) {
        StringBuilder answer = new StringBuilder();
        text += " ";
        int count = 1;
        for (int i=0; i<text.length() - 1; i++) {
            if (text.charAt(i) == text.charAt(i+1)) count++;
            else {
                answer.append(text.charAt(i));
                if (count >1) answer.append(count);
                count = 1;
            }
        }
        return answer.toString();
    }
}
