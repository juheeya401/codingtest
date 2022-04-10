package inflearnCodingTest.DfsDfs;

/**
 * 07-03 팩토리얼 (채점x)
 * #재귀함수 #!N
 */

/**
 * 문제: 자연수 N이 입력되면 N!을 구하는 프로그램을 작성하세요.
 * 예를 들어 5!=5*4*3*2*1=120 입니다.
 * 입력설명: 첫 줄에 자연수 N(1<=N<=100)이 주어집니다.
 * 입력예제
 * 5
 * 출력예제
 * 120
 */
public class DfsBfs03 {
    public static void main(String[] args) {
        Double answer = dfs(20);
        System.out.println(answer);
    }

    private static Double dfs(int N) {
        if (N == 1) return 1D;
        return N * dfs(N - 1);
    }
}
