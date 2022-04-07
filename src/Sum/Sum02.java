package Sum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * todo
 * 03-02. 공통원소 구하기
 * 2022-04-07: ❌
 */
public class Sum02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        personal(scanner);
    }

    /**
     * 전) 내가하기-01
     * 결과: Time Limit Exceeded
     */
    private static void personal01(Scanner scanner) {
        // 입력
        int aCnt = scanner.nextInt();
        int[] aArr = new int[aCnt];
        for (int i=0; i<aCnt; i++) {
            aArr[i] = scanner.nextInt();
        }
        int bCnt = scanner.nextInt();
        int[] bArr = new int[bCnt];
        for (int i=0; i<bCnt; i++) {
            bArr[i] = scanner.nextInt();
        }

        // 알고리즘
        // a * b 만큼 반복문 돌림 (찾으면 바로 break)
        List<Integer> answer = new ArrayList<>();
        for (int a=0; a<aCnt; a++) {
            for (int b=0; b<bCnt; b++) {
                if (aArr[a] == bArr[b]) {
                    answer.add(aArr[a]);
                    break;
                }
            }
        }

        // 출력
        answer.stream().sorted().forEach(e -> System.out.print(e + " "));
    }

    /**
     * 전) 내가하기-02
     * 컨셉: 두번째 for 문에서 한 번 찾은 원소는 배열(list)에서 제거했다. -> 반복이 계속될 수록 반복할 갯수가 줄어드는 효과 기대
     * 결과: Time Limit Exceeded
     */
    private static void personal(Scanner scanner) {
        // 입력
        int aCnt = scanner.nextInt();
        int[] aArr = new int[aCnt];
        for (int i=0; i<aCnt; i++) {
            aArr[i] = scanner.nextInt();
        }
        int bCnt = scanner.nextInt();
        List<Integer> bArr = new LinkedList<>();
        for (int i=0; i<bCnt; i++) {
            bArr.add(scanner.nextInt());
        }

        // 알고리즘
        List<Integer> answer = new ArrayList<>();
        for (int a=0; a<aCnt; a++) {
            for (int b=0; b<bArr.size(); b++) {
                if (aArr[a] == bArr.get(b)) {
                    answer.add(aArr[a]);
                    bArr.remove(b); // 추가된 부분 => 한 번 찾은건 제거한다.
                    break;
                }
            }
        }

        // 출력
        answer.stream().sorted().forEach(e -> System.out.print(e + " "));
    }
}
