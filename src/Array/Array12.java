package Array;

import java.util.Scanner;

/**
 * 02-12. 멘토링
 * 2022-04-07: ❌ (회고 읽어보기.)
 */
public class Array12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        solution(scanner);
    }

    /**
     * 전) 내가풀기: ❌ (11번과 비슷한 문제. 둘 다 이해가 안된다.)
     * i 반복 -> 한 명씩 멘티가 되는 경우를 검사해서 count 한다
     * i의 등수 아래에 항상 있었다면 -> count한다
     */
    private static void personal(Scanner scanner) {
        // 입력
        int personCnt = scanner.nextInt();
        int testCnt = scanner.nextInt();
        int[][] arr = new int[testCnt][personCnt];
        for (int i=0; i<testCnt; i++) {
            for (int j=0; j<personCnt; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        // 입력값 분석: i-index=테스트, j-index=등수(낮을수록 높은점수), value=학생 번호

        // Set 에 배열을 넣으면 중복제거가 안되나보다.. 엄청 많이 나온다.
        //Set<Integer[]> answer = new HashSet<>(); // 아님

        // i-index=멘토번호, j-index=멘티번호, value=0:안됨, 1=됨
        int[][] answer = new int[personCnt + 1][personCnt + 1];

        // 컨셉: 시험별로 각 등수의 학생을 멘토로 지정하고 멘티를 매치한다
        for (int test=0; test<testCnt; test++) {
            for (int score=0; score< personCnt-1; score++) {
                // 멘토 지정
                int mento = arr[test][score];

                for (int t=0; t<personCnt; t++) {
                    // 멘티 지정
                    int menti = arr[test][t];
                    //answer.add(new Integer[]{mento, menti});

                    // 멘토의 점수가 높을때(=수치로는 낮을 때) 카운트에 포함한다
                    if (score < t) {
                        answer[mento][menti] = 1;
                    } else {
                        answer[mento][menti] = 0;
                    }
                }
            }
        }

        int result = 0;//answer.size();
        for (int i=1; i<personCnt+1; i++) {
            for (int j=1; j<personCnt+1; j++) {
                if (answer[i][j] == 1) result++;
            }
        }
        System.out.println(result);
    }


    /**
     * 후) 구현해보기
     * 4중 for 문 문제다
     * 모든 경우의수=학생수*학생수 만큼 반복하면서 멘토, 멘티를 정해놓고,
     * 시험별 점수를 비교해서 -> 멘토가 항상 등수가 높다면 카운트 한다.
     *
     * 회고) 1.반복문을 어떤 기준으로 얼마나 해야하는지 아직 잘 모르겠다.
     *      모든 학생들의 경우의 수를 구해야 하므로 모든 조합을 반복하면서 조건을 검사해야 한다!
     *      2. 반복문 변수에 i,j 대신 의미있는 이름을 붙이는게 헷갈리지 않는다.
     */
    public static void solution(Scanner scanner) {
        // 입력값 분석: i-index=테스트, j-index=등수(낮을수록 높은점수), value=학생 번호
        // 입력
        int personCnt = scanner.nextInt();
        int testCnt = scanner.nextInt();
        int[][] arr = new int[testCnt][personCnt];
        for (int i=0; i<testCnt; i++) {
            for (int j=0; j<personCnt; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int answer = 0;
        for (int mento=1; mento<personCnt+1; mento++) {
            for (int menti=1; menti<personCnt+1; menti++) { // 모든 경우의 수 반복

                boolean flag = true;

                for (int test=0; test<testCnt; test++) { // 모든 시험을 반복
                    int mentoScore = 0;
                    int mentiScore = 0;

                    for (int score=0; score<personCnt; score++) { // 모든 점수를 반복
                        // 멘토와 멘티의 점수를 구한다.
                        if (mento == arr[test][score]) mentoScore = score;
                        if (menti == arr[test][score]) mentiScore = score;
                    }

                    // 멘토 등수가 멘티보다 낮은 경우(시스템적으로 같거나 높은 경우)
                    // 바로 break(다음 경우의수 검사)
                    if (mentoScore >= mentiScore) {
                        flag = false;
                        break;
                    }
                }

                // 모든 테스트에서 앞선 경우에만 카운트
                if (flag) answer++;
            }
        }
        System.out.println(answer);
    }
}
