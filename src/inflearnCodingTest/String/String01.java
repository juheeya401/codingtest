package inflearnCodingTest.String;

import java.util.Objects;
import java.util.Scanner;

/**
 * 01-01
 * 2022-03-04 : 걸린시간 10 : 통과
 */
public class String01 {
    //public static void main(inflearnCodingTest.String[] args) {
    //    Scanner in = new Scanner(System.in);
    //    inflearnCodingTest.String in1 = in.next();
    //    inflearnCodingTest.String in2 = in.next();
    //    int process = personal(in1, in2);
    //    System.out.println(process);
    //    return;
    //}

    // 강의 듣기 전 풀어본 나의 풀이
    private static int personal(String text, String one) {
        int result = 0;
        char inputOne = one.toUpperCase().toCharArray()[0];
        char[] inputText = text.toUpperCase().toCharArray();
        for (char textOne : inputText) {
            if (Objects.equals(inputOne, textOne)) {
                result++;
            }
        }
        return result;
    }

    // 강의에서 알려준 풀이
    public static void main(String[] args) {
        String01 T = new String01();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char c = in.next().charAt(0);  // char 로 입력받고 싶으면 charAt()을 이용한다
        System.out.println(T.solution(str, c));
        return;
    }

    public int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);   // char 타입을 대문자로 변환할 때는 Character 유틸 클래스를 사용한다
        for (char one : str.toCharArray()) {
            if (t == one) {     // 단순히 == 을 이용해서 비교하면 된다
                answer++;
            }
        }
        return answer;
    }
}
