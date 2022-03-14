package String;

import java.util.Locale;
import java.util.Scanner;

/**
 * 01-08 유효한 팰린드롬
 * 2022-03-08:⭕️ & ⭐️(정규표현식 이용하기)
 */
public class String08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String answer = personal(text);
        System.out.println(answer);
    }

    /**
     * String07처럼 풀면 알파벳만 검사할 수 없다. String.String05 처럼 좌/우 포인터를 두고 알파벳인지 체크하면서 검사해야 한다.
     */
    private static String personal(String text) {
        text = text.toLowerCase(Locale.ROOT);
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (!Character.isAlphabetic(text.charAt(left))) {
                left++;
            } else if (!Character.isAlphabetic(text.charAt(right))) {
                right--;
            } else {
                if (text.charAt(left) != text.charAt(right)) {
                    return "NO";
                }
                left++;
                right--;
            }
        }
        return "YES";
    }

    /**
     * 강의 풀이
     * 문자열에서 알파벳 외 모든 문자를 replace 해서 비교한다
     * -> ⭐️ 내가 푼 것 보다 단순하다. 나는 정규표현식을 잘 못쓴다.
     */
    public static String solution(String text) {
        text = text.toUpperCase();
        // 대문자 A-Z가 아닌 것들은 ""로 replace
        text = text.replaceAll("[^A-Z]", ""); // replaceAll()에서만 표현식 사용 가능. replace()에서는 표현식 쓰지 못함
        String reversedText = new StringBuilder(text).reverse().toString();
        return text.equals(reversedText) ? "YES" : "NO";
    }
}
