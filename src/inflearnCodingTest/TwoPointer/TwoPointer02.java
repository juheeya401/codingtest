package inflearnCodingTest.TwoPointer;

import java.util.*;

/**
 * todo 강의해설 확인하기
 * 03-02. 공통원소 구하기
 * 2022-04-07: ❌
 * 2022-04-08: ⭕️
 * #inflearnCodingTest.TwoPointer
 */
public class TwoPointer02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        personal(scanner);
    }

    /**
     * 전) 내가하기-01: ❌
     * 결과: Time Limit Exceeded
     */
    private static void personal01(Scanner scanner) {
        // 입력
        int aCnt = scanner.nextInt();
        int[] aArr = new int[aCnt];
        for (int i = 0; i < aCnt; i++) {
            aArr[i] = scanner.nextInt();
        }
        int bCnt = scanner.nextInt();
        int[] bArr = new int[bCnt];
        for (int i = 0; i < bCnt; i++) {
            bArr[i] = scanner.nextInt();
        }

        // 알고리즘
        // a * b 만큼 반복문 돌림 (찾으면 바로 break)
        List<Integer> answer = new ArrayList<>();
        for (int a = 0; a < aCnt; a++) {
            for (int b = 0; b < bCnt; b++) {
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
     * 전) 내가하기-02: ❌
     * 컨셉: 두번째 for 문에서 한 번 찾은 원소는 배열(list)에서 제거했다. -> 반복이 계속될 수록 반복할 갯수가 줄어드는 효과 기대
     * 결과: Time Limit Exceeded
     */
    private static void personal02(Scanner scanner) {
        // 입력
        int aCnt = scanner.nextInt();
        int[] aArr = new int[aCnt];
        for (int i = 0; i < aCnt; i++) {
            aArr[i] = scanner.nextInt();
        }
        int bCnt = scanner.nextInt();
        List<Integer> bArr = new LinkedList<>();
        for (int i = 0; i < bCnt; i++) {
            bArr.add(scanner.nextInt());
        }

        // 알고리즘
        List<Integer> answer = new ArrayList<>();
        for (int a = 0; a < aCnt; a++) {
            for (int b = 0; b < bArr.size(); b++) {
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


    /**
     * 후) 내가 하기: ⭕️
     * 컨셉: inflearnCodingTest.TwoPointer 를 이용한다. + 두 배열을 정렬한다 => ⭐️ inflearnCodingTest.TwoPointer 문제는 정렬이 필요한 것 같다.
     */
    private static void personal(Scanner scanner) {
        // 입력
        int aCnt = scanner.nextInt();
        int[] aArr = new int[aCnt];
        for (int i = 0; i < aCnt; i++) {
            aArr[i] = scanner.nextInt();
        }
        int bCnt = scanner.nextInt();
        int[] bArr = new int[bCnt];
        for (int i = 0; i < bCnt; i++) {
            bArr[i] = scanner.nextInt();
        }

        // 우선 정렬! 중요!
        Arrays.sort(aArr);
        Arrays.sort(bArr);

        List<Integer> answer = new LinkedList<>();
        int aP = 0, bP = 0;
        while (aP < aCnt && bP < bCnt) {
            int a = aArr[aP];
            int b = bArr[bP];
            if (a == b) {
                answer.add(a);
                aP++;
                bP++;
            } else if (a < b) {
                // 작은 쪽을 증가시킴
                aP++;
            } else {
                // 역시 작은 쪽을 증가시킴
                bP++;
            }
        }

        answer.stream().forEach(e -> System.out.print(e + " "));
    }
}
