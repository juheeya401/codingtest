package inflearnCodingTest.DfsDfs;

/**
 * 07-08. 송아지 찾기1(BFS)
 * #최단거리구하기 #BFS
 *
 * 반성: 문제를 이해하지 못했음. BFS를 배웠는데 컨셉을 못잡음.
 *      문제 언뜻 읽으면 배열문제같기도 함.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 8. 송아지 찾기 1(BFS : 상태트리탐색)
 * 설명
 * 현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
 * 현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
 * 송아지는 움직이지 않고 제자리에 있다.
 * 현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
 * 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.
 * 입력
 * 첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000까지이다.
 * 출력
 * 점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재합니다.
 * 예시 입력 1
 * 5 14
 * 예시 출력 1
 * 3
 */
public class Bfs08 {
    int answer = 0;
    int[] distance = {1, -1, 5}; // 경우의수 저장
    int[] checked; // 메모리저장소. 이미 구한 최단위치는 미리 저장해 놓기 위함. 캐싱
    Queue<Integer> Q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int S = scanner.nextInt(); // 현수의 현재 위치
        int E = scanner.nextInt(); // 송아지의 위치 (목표지점)

        Bfs08 tree = new Bfs08();
        System.out.println(tree.bfs(S, E));
    }

    private int bfs(int s, int e) {
        checked = new int[10000 + 1]; // 캐싱 사이즈 정함 (문제에서 말한 범위)
        checked[s] = 1; // 현수의 현재위치니까 일단 1 넣고 시작
        Q.offer(s); // 현수의 현재위치 = root 노드이므로 Q에 첫번째 입력값으로 넣음
        int Level = 0; // 현수의 현재위치 레벨은 0이니까 레벨 초기화 (Top down)

        while(!Q.isEmpty()) {
            // 현재 레벨에 있는 노드 갯수
            int length = Q.size();

            // 현재 레벨에 있는 모든 노드를 처리한다.
            for (int i=0; i<length; i++) {
                // 큐에서 노드 하나 꺼낸다 = 현재위치
                Integer currentP = Q.poll();

                // 송아지 찾았다! 현재 위치가 송아지 위치랑 같으면 반환.
                //if (currentP == e) return Level;

                // 모든 경우의 수를 체크하면서 큐에 자식노드들을 저장한다.(다음 레벨에 체크할 애들)
                for (int d : distance) {
                    // 큐의 말단에 저장할 다음 노드값(위치값)
                    int nx = currentP + d;

                    // 송아지 찾았다! 큐에 저장할 위치가 송아지 위치랑 같으면 바로 반환한다.
                    if (nx == e) return Level + 1; // 큐에 넣기 전에 반환한다. 좀 더 빨리 반환한다.
                    // 큐의 말단에 '자식노드'를 저장하는 거니까, 다음레벨이다. 따라서 다음레벨이 정답이다.(Level + 1)

                    // 노드를 끝도없이 찾을 수는 없다. 문제에서 주어진 범위 내에서만 찾는다.
                    // checked[nx] == 0 :: 이미 체크한 위치라서 큐에 넣지 않는다(제외)
                    if (nx >= 1 && nx <=10000 && checked[nx] == 0) {
                        checked[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }// 현재 레벨 다 돌았음

            Level++;
        }
        return 0;
    }
}
