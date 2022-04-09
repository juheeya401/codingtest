package DfsDfs;

/**
 * 07-02. 이진수 출력(재귀)
 * #재귀함수 #이진수
 */

/**
 * 문제: 10진수 N이 입력되면 2짖ㄴ수로 변환하여 출력하는 프로그램을 작성하세요.
 * 단, 재귀함수를 이용해서 출력해야 합니다.
 * 입력설명: 철번째 줄에 10진수 N(1<=N<=1,000)이 주어집니다.
 * 입력예제
 * 11
 * 출력예제
 * 1011
 */
public class DfsBfs02 {
    public static void main(String[] args) {
        printtwo(11);

        System.out.println("");

        // Java 함수: 이진수 문자열 구하기
        System.out.println(Integer.toBinaryString(11));
    }

    /**
     * 강의해설
     * 2진수 만드는 방법: N == 0 때까지 2로 나눈 나머지를 역순으로 출력한다.
     */
    private static void printtwo(int N) {
        /*if (N < 2) { // 나는 이건 줄 알았는데 해설에서는 0을 조건으로 했다.
            System.out.print(N);
            return;
        }*/
        if (N==0) return;
        printtwo(N / 2);
        System.out.print(N % 2); // 재귀호출 뒤에 처리 시 입력 순서대로 출력
    }
}
