package String;

import java.util.*;

/**
 * 01-07 회문 문자 검사하기
 * 2022-03-07: ❌(내 풀이와 강의 풀이 다름)
 */
public class String07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();        
        //String answer = personal(text);
        String answer = solution02(text);
        System.out.println(answer);
    }
    
    public static String personal(String text) {
        String answer = "YES";
        char[] texts = text.toLowerCase().toCharArray();
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (texts[left] != texts[right]) return "NO";
            else {
                left++;
                right--;
            }
        }
        return answer;
    }

    /**
     * 강의 방법1
     * 1/2만 for 문 돌리기 : 내가 푼 거랑 비슷함. 변수선언이 줄고, 반복문이 while 이 아니라 for 이라는게 다름
     */
    public static String solution(String text) {
        text = text.toUpperCase();
        int length = text.length();
        for (int i = 0; i < length / 2; i++) {
            if (text.charAt(i) != text.charAt(length - i - 1)) return "NO";
        }
        return "YES";
    }
    /**
     * 강의 방법2
     * ⭐️ 완전! 단순 : StringBuilder 의 reverse() 함수 사용 & String 객체의 equalsIgnoreCase() 함수 사용
     */
    public static String solution02(String text) {
        String reversedText = new StringBuilder(text).reverse().toString();
        return reversedText.equalsIgnoreCase(text) ? "YES" : "NO";
    }
}