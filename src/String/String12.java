package String;

import java.util.Scanner;

public class String12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String fullText = scanner.next();
        //personal(count, fullText);
        solution(count, fullText);
    }

    /**
     * 내가 풀기 ⭕
     * 1.1,0으로 바꾼다 : #=1, *=0
     * 2.한 문자씩 나눈다 : fullText/count = 1문자
     * 3.10진수로 바꾼다 : Integer.parse(변환전문자열, 변환전문자열의진수숫자) 사용
     * 4.문자(char)로 바꾼다 : 쉽다. 명시적 형변환 해주면 됨. (char) 65 -> A
     * 5.문자를 조합해서 출력한다.
     */
    private static void personal(int count, String fullText) {
        fullText = fullText.replaceAll("\\*", "0").replaceAll("#", "1");
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < count; i++) {
            String binaryStr = fullText.substring(i * 7, i * 7 + 7); // begin, end 인덱스 계산에서 시간 많이 씀
            int ten = Integer.parseInt(binaryStr, 2);       // 10진수 만드는 방법
            answer.append((char) ten);   // 명시적 형변환
        }
        System.out.println(answer);
    }

    /**
     * 강의 풀이
     * 내 풀이보다 연산은 더 많지만, 코드이해는 더 쉬울 것 같다.
     */
    private static void solution(int count, String fullText) {
        String answer = "";
        for (int i = 0; i<count; i++) {
            String tmp = fullText.substring(0, 7).replaceAll("#", "1").replaceAll("\\*", "0");
            int num = Integer.parseInt(tmp, 2);
            answer += (char) num;
            fullText = fullText.substring(7);
        }
        System.out.println(answer);
    }
}
