package inflearnCodingTest.String;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 1-04. 개쉽
 * 방법1 : 내가 푼게 더 나음
 * 방법2 : ⭐️직접 리버스 구현 = 정독!!!!
 */
public class String04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        //personal(scanner, count);
        //solution_main(scanner, count);
        personal02(scanner, count);
    }

    /**
     * 방법1 : StringBuilder 의 reverse() 함수 사용
     */
    // 내가 푼거
    public static void personal(Scanner scanner, int count) {
        for (int i = 0; i < count; i++) {
            String text = scanner.next();
            StringBuilder answer = new StringBuilder(text);
            System.out.println(answer.reverse());       // StringBuilder 의 몰랐던 기능!
        }
    }

    // 강의에서 푼거 : 반복문 3번, reverse
    public static void solution_main(Scanner scanner, int count) {
        String[] str = new String[count];

        for (int i = 0; i < count; i++) {
            str[i] = scanner.next();
        }
        for (String x : solution(count, str)) {
            System.out.println(x);
        }
    }

    public static ArrayList<String> solution(int count, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }
        return answer;
    }

    /**
     * 방법2 : 직접 reverse() 구현
     *  단순 뒤짚기가 아닌, 대칭으로 변경하기 (ex. apple-> elppa | mobilePhones->senohPelibom)
     */
    public static void personal02(Scanner scanner, int count) {
        for (int i = 0; i < count; i++) {
            String text = scanner.next();
            char[] texts = text.toCharArray();
            String answers = getAnswer(texts);
            System.out.println(answers);
        }
    }

    // 내가 푼 것
    // 잘 한점 : 일단 설명듣기 전에 left/right 바꾸는 방법 생각한거 ok
    // 단점 : 소스가 복잡/지저분(알고리즘을 제대로 몰랐기 때문) & 굳이 별도의 char[]를 만들필요 없이 texts[]에 바로 결과 넣어도 됐음(메모리 절약)
    private static String getAnswer(char[] texts) {
        char[] answers = new char[texts.length];
        int halfCnt = texts.length / 2;
        for (int j=0; j<halfCnt; j++) {
            answers[texts.length - j - 1] = texts[j];
            answers[j] = texts[texts.length - j - 1];
        }
        if (texts.length % 2 != 0) {        // text[]에 직접 변경했으면 이 연산도 필요 없음
            answers[halfCnt] = texts[halfCnt];
        }
        return new String(answers);         // char[] -> Strnig으로 변환하는 방법1
    }

    // 강의 설명 : 직접 리버스를 구현하기 -> 내꺼보다 훨씬 간단하고 가독성 좋음
    private static String solution02(char[] texts) {
        int left = 0;
        int right = texts.length - 1;

        // ⭐️중요! 이정도는 알아야 할 리버스 코딩
        while (left < right) {
            char temp = texts[left];
            texts[left] = texts[right];
            texts[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(texts);       // char[] -> Strnig으로 변환하는 방법2
    }
}
/**
 * 힌트 : StringBuilder 의 reverse()
 * inflearnCodingTest.String 대신 StringBuilder를 사용하는 이유 => String은 문자를 수정할 때 마다 객체를 계속 새로 만든다(메모리 낭비). 근데 StringBuilder는 처음 생성한 객체를 수정한다. 따라서 문자열연산이 많은 경우 StringBuilder를 사용한다.
 */