import java.util.Scanner;

/**
 * 01-09 숫자만 추출
 * 입력예시 : g0en2T0s8eSoft
 * 2022-03-08: ❌
 */
public class String09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        //int answer = personal(text);
        int answer = solution02(text);
        System.out.println(answer);
    }

    /**
     * 내가 푼 방식❌
     *  => 알파벳 대문자, 소문자만 "" 로 replace() 했음 -> 입력받은 문자에 특수문자 등이 들어갔을 때는 숫자로 파싱 시 오류 난다.
     */
    private static int personal(String text) {
        text = text.replaceAll("[A-Z,a-z]","");
        int answer = Integer.parseInt(text);
        return answer;
    }

    /**
     * 강의 풀이01
     * 숫자의 아스키코드 범위를 기준으로 문자열을 체크(숫자 0=48, 숫자 9=57. 숫자범위=48~57)
     * & 아스키코드 계산으로 입력받은 숫자 누적한다(answer = answer * 10 + (숫자 -48)
     */
    public static int solution01(String text) {
        int answer = 0;
        for (char x : text.toCharArray()) {
            // 숫자면
            if (x >= 48 && x <= 57) {
                // 계산 실행해서 누적
                System.out.println("answer1 = " + answer);
                answer = answer * 10 + (x - 48);
                System.out.println("answer2 = " + answer);
            }
        }
        return answer;
    }

    /**
     * 강의 풀이2
     * 훨씬 깔끔하다!!!!!
     * Character.isDigit() 이용 & String 으로 누적하고 마지막에 parseInt() 한다
     */
    public static int solution02(String text) {
        StringBuilder answer = new StringBuilder();
        for (char x : text.toCharArray()) {
            if (Character.isDigit(x)) { // ⭐️Character.isDigit(x) 로 숫자여부를 체크할 수 있다.
               answer.append(x);
            }
        }
        return Integer.parseInt(answer.toString());
    }
}
