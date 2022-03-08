import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 01-05
 * 2022-03-07: ❌
 * 특수문자 제외하고 알파벳만 가공하기 -> 혼자풀기 실패
 * 문제해결 할 로직을 제대로 생각해야한다!!!!
 */
public class String05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        personal_re02(text);
    }

    // 내가 푼 것 ; 실패!!!
    // 문제1 : 알파벳을 검사하는 함수를 몰랐다 -> Character 의 isAlphabetic() 함수 있음.
    // 문제2 : 문제를 풀 수 있는 로직을 잘못 이해했다. -> 왼쪽/오른쪽 각각 알파벳이 아니면 다음으로 넘어가야 하는데 내 로직에서는 왼쪽만 검사함
    public static void personal(String text) {
        int left = 0;
        int right = text.length() - 1;
        char[] texts = text.toCharArray();

        while(left < right) {
            char temp = texts[left];
            if (Character.isAlphabetic(temp)) {
                texts[left] = texts[right];
                texts[right] = temp;
            }
            left++;
            right--;
        }
    }
    // 다시풀기 : 틀림
    // 테스트 결과 : 입력=a#b!!GE*T@@S
    // 정답=S#T!!EG*b@@a
    // 오답=S#@!TEG*!b@a
    public static void personal_re01(String text) {
        int left = 0;
        int right = text.length() - 1;
        char[] texts = text.toCharArray();

        while(left < right) {
            // 원인 : left/right 한 번만 검사하고
            if (!Character.isAlphabetic(texts[left])) left++;
            if (!Character.isAlphabetic(texts[right])) right--;
            // 각각 증가 후에는 검사하지 않고 진행했기 때문이다.
            // 따라서 이 반복문 내에서는 검사 후 문자가 알파벳이아니더라도 교체된다.
            char temp = texts[left];
            texts[left] = texts[right];
            texts[right] = temp;
            left++;
            right--;
        }
        System.out.println(String.valueOf(texts));
    }

    // 다시풀기2. 정답..;;
    // ⭐️ 강의의 정답
    public static void personal_re02(String text) {
        int left = 0;
        int right = text.length() - 1;
        char[] texts = text.toCharArray();

        while(left < right) {
            // 아래 로직을 보면 left/right 둘 중 하나라도 조건에 맞지 않으면 index 증가 후 다음 반복문으로 넘어간다.!! 이게 핵심!
            if (!Character.isAlphabetic(texts[left])) left++;
            else if (!Character.isAlphabetic(texts[right])) right--;
            else {
                char temp = texts[left];
                texts[left] = texts[right];
                texts[right] = temp;
                left++;
                right--;
            }
        }
        System.out.println(String.valueOf(texts));
    }
}
