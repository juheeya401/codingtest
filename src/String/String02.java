package String;

import java.util.*;

/**
 * 01-02
 * 2022-03-04 : 걸린시간 5분 : 통과
 */
public class String02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        //String result = personal(text);
        String result = solution(text);
        System.out.println(result);
    }

    public static String personal(String text) {
        StringBuilder answer = new StringBuilder(); // 인텔리J의 가르침! -> StringBuilder!! 처음에는 String 으로 선언 &  answer += Character.toLowerCase(one); 이렇게 썼다.
        for (char one : text.toCharArray()) {
            if (Character.isUpperCase(one)) {
                answer.append(Character.toLowerCase(one));
            } else {
                answer.append(Character.toUpperCase(one));
            }
        }
        return answer.toString();
    }

    // 강의 내용 : Character.isUpperCase() 나 isLowCase()를 이용하는 방법도 있다.
    // 그리고 아스키코드를 이용하는 방법도 있다. 아래는 아스키 코드를 이용하는 방법.
    public static String solution(String text) {
        StringBuilder answer = new StringBuilder();
        for (char one : text.toCharArray()) {
            if (one >= 97 && one <= 122) {      // 영어 대문자의 범위 체크
                answer.append((char) (one - 32));   // 영어 대문자와 소문자의 차이만큼 계산한다.
            } else {
                answer.append((char) (one + 32));   // 계산 후 반드시 char 로 캐스트 해주지 않으면 숫자로 나온다.
            }
        }
        return answer.toString();
    }
}
