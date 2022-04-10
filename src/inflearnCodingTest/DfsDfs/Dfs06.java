package inflearnCodingTest.DfsDfs;

/**
 * 07-06. 부분집합 구하기(DFS)
 * #DFS #부분집합
 * ⭐️ 전위순회의 기본!
 *
 * 선생님 말: 스택과 상태트리 그리는거 중요하다. 초보자들은 꼭 그리면서 이해하길 바란다.
 */

/**
 * 문제: 자연수 N이 주어지면 1부터 N 까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요
 * 입력설명
 * 첫 줄에 자연수 N(1<=N<=10)이 주어집니다.
 * 출력설명
 * 첫 줄부터 각 줄에 하나씩 부분집합을 아래 출력예제와 같은 순서로 출력한다.
 * 단, 공집합은 출력하지 않는다.
 * 입력예제
 * 3
 * 출력예제
 * 1 2 3
 * 1 2
 * 1 3
 * 1
 * 2 3
 * 2
 * 3
 *
 * 공집합? = 원소가 하나도 없는 집합
 */
public class Dfs06 {

    static int N;
    static int[] ch;

    public static void main(String[] args) {
        Dfs06 tree = new Dfs06();
        N = 3;
        ch = new int[N +1];

        // 1레벨부터 시작하라는 뜻
        tree.dfs(1);
    }

    private void dfs(int Level) {
        if (Level == N +1) { // 레벨 끝남
            // 모든 말단까지 모든 경우의 수를 다 ch에 저장했기 때문에
            // 가장 말단에서 구해진 데이터 -> 조건에 맞게 처리
            String temp = "";
            for (int i = 1; i<= N; i++) {
                // 스택에서 하나씩 넣을지말지 조건을 꺼내보고 처리한다.
                if (ch[i] == 1) temp += (i + " ");
            }

            // 공집합은 제외하라고 했기 때문에 temp에 값이 있을 때만 출력
            if (temp.length() > 0) System.out.println(temp);

        } else { // 아직 레벨 계속 됨

            ch[Level] = 1; // 포함한다
            dfs(Level + 1); // 왼쪽 방향 = 포함O

            ch[Level] = 0; // 포함하지 않는다.
            dfs(Level + 1); // 오른쪽 방향 = 포함X
        }
    }
}
