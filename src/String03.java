import java.util.Scanner;

/**
 * 01-03
 */
public class String03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();       // 주의. next()는 띄어쓰기 기준으로 입력받는다. 한 라인을 다 받으려면 nextLing()을 쓴다.
        //String result = personal(text);
        //String result = solution01(text);
        String result = solution02(text);

        System.out.println(result);
    }

    private static String personal(String text) {
        String answer = "";
        int maxLength = 0;
        for (String one : text.split(" ")) {
            if (one.length() > maxLength) {
                maxLength = one.length();
                answer = one;
            }
        }
        return answer;
    }

    // 강의에서 알려준 정담1 : 내가 푼 답과 동일
    private static String solution01(String text) {
        String answer = "";
        int m = Integer.MIN_VALUE;          // 최소길이 초기화를 나는 0으로 했는데 선생님은 Integer.MIN_VALUE를 사용함
        String[] s = text.split(" ");
        for(String x : s) {
            int len = x.length();
            if (len > m) {
                m = len;
                answer = x;
            }
        }
        return answer;
    }

    // 강의에서 알려준 정답2 (indexOf()와 substring()으로 풀기)
    // => 후기 : 가독성도 안좋고 오류가 발생할 수 있음. 게다가 제대로 하려면 if문을 또 넣어줘야 함
    private static String solution02(String text) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos;
        while((pos = text.indexOf(' ')) != -1) {
            String temp = text.substring(0, pos);
            int len = temp.length();
            if (len > m) {
                m = len;
                answer = temp;
            }
            text = text.substring(pos+1);
        }
        if (text.length() > m) answer = text;
        return answer;
    }
}
