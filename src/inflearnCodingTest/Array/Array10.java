package inflearnCodingTest.Array;

import java.util.Scanner;

/**
 * 02-10. 봉우리 (사방체크)
 * 2022-04-06: ⭕ - 후기: 강의 듣고 풀었다. 어렵지 않으나 익숙하지 않으면 생각이 안날 수 있다.
 */
public class Array10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        personal(scanner);
    }

    /**
     * 우선 다 입력받는다
     * 상,하,좌,우 공식을 찾는다
     * 전체를 탐색하면서 비교하여 count 한다.
     * 위: (-1, 0)
     * 오: (0, 1)
     * 아: (1, 0)
     * 왼: (0, -1)
     */
    private static void personal(Scanner scanner) {
        // 입력
        int count = scanner.nextInt();
        int[][] arr = new int[count][count];
        for (int i=0; i<count; i++) {
            for (int j=0; j<count; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        // 시계방향(위오아왼)
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};

        int answer = 0;

        // 한 칸씩 나아가면서 사방을 체크한다.
        for (int i=0; i<count; i++) {
            for (int j=0; j<count; j++) {
                boolean isTop = true;

                // 사방을 확인한다.
                for (int t=0; t<4; t++) {
                    int x = i + dx[t];
                    int y = j + dy[t];

                    // 만약 가장자리 넘어가면 다음 사방 체크
                    if (x < 0 || y < 0 || x == count || y == count) continue;

                    int stand = arr[x][y];

                    // 봉우리가 아니면 바로 사방체크 중지 & isTop=false 로 입력
                    if (arr[i][j] <= stand) {
                        isTop = false;
                        break;
                    }
                }

                // 봉우리가 맞을 때만 결과값 +1
                if (isTop) answer++;
            }
        }

        // 출력
        System.out.println(answer);
    }
}
