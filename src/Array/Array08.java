package Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 02-08. 등수구하기
 * 2022-03-22: ❌
 * 02-08. 등수구하기
 * 2022-04-05: ❌
 */
public class Array08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        personal(scanner);
    }

    /**
     * 후) 강의 설명만 듣고 내가 풀기
     * 그냥 전부다 반복문으로 돌린다.
     * 한 명씩 1등으로 초기화 후 전체 학생들과 비교해서 -> 더 높은 학생이 등장하면 등수를 올려간다.
     */
    private static void personal(Scanner scanner) {
        // 입력
        int count = scanner.nextInt();
        int[] arr = new int[count];
        for (int i=0; i<count; i++) {
            arr[i] = scanner.nextInt();
        }

        // 알고리즘
        for (int i=0; i<count; i++) {
            int rank = 1;
            int iScore = arr[i];
            for (int j=0; j<count; j++) {
                if (iScore < arr[j]) { // 점수가 더 큰 학생이 등장했다 -> 내 등수는 1개 늘어났다
                    rank++;
                }

                // if (i == j) continue; // 제거: 같거나 낮은 점수가 등장하면 아무것도 안해도 되니까 내가 나랑 비교해도 상관 없음
            }

            // 출력
            System.out.print(rank + " ");
        }
    }


    /**
     * 전) 내가하기 -> 실패. 너무 복잡하게 생각함
     * 입력값 정렬하고
     * max 길이만큼 배열 만들어서
     * 점수=index, 값=등수로 저장한다
     * 1등부터 매기고, 다음 점수도 같다면 등수 유지한다.
     * 출력할 때는 원래 받은 값들을 갖고 인덱스 찾아서 등수를 입력한다
     */
    static void personal01(Scanner scanner) {
        int count = scanner.nextInt();
        int[] in = new int[count];
        for (int i=0; i<count;i++) {
            in[i] = scanner.nextInt();
        }

        int[] sort = Arrays.copyOf(in, count + 1);
        Arrays.sort(sort);

        int maxScore = sort[count-1];

        int[] ranking = new int[maxScore+1];
        for (int i=count-1; i<=0; i--) {
            int score = sort[i];// 점수
            if (score != sort[i+1]) {
                ranking[score] = count - i;
            }
        }

        // 출력
        for (int i=0; i<count; i++) {
            System.out.println(ranking[in[i]]);
        }

    }
}
