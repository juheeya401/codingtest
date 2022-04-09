package DfsDfs;

/**
 * 07-01. 재귀함수
 * #DFS #재귀함수_기본개념설명 #스택프레임 #Stack
 */

/**
 * 문제: 자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요.
 * 입력설명: 첫 줄은 정수N(3<=N<=10)이 입력된다.
 * 입력예제
 * 3
 * 출력예제
 * 1 2 3
 */
public class DfsBfs01 {

    public static void main(String[] args) {
        dfs(3);
    }

    /**
     * 강의내용
     * 재귀함수는 깊이우선탐색(dfs)과 같은 말.
     * 재귀함수는 스택 프레임에 저장된! 따라서 선입후출이다.
     */
    private static void dfs(int n) {
        if (n == 0) return;
        System.out.print(n + " "); // 재귀호출 앞에 처리 = 역순
        dfs(n-1);
        //System.out.print(n + " "); // 재귀호출 뒤에 처리 = 입력순
    }
}
