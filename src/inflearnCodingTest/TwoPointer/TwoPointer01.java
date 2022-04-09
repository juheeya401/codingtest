package inflearnCodingTest.TwoPointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 03-01. 두 배열 합치기
 * 2022-04-07: ⭕️
 */
public class TwoPointer01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        personal(scanner);
    }

    /**
     * 전) 내가 풀기
     * 방법: 자바에 있는 유틸을 사용했다.
     */
    private static void personal01(Scanner scanner) {
        int firstCount = scanner.nextInt();
        int[] firstArray = new int[firstCount];
        for (int i = 0; i < firstCount; i++) {
            firstArray[i] = scanner.nextInt();
        }

        int secondCount = scanner.nextInt();
        int[] secondArray = new int[secondCount];
        for (int i = 0; i < secondCount; i++) {
            secondArray[i] = scanner.nextInt();
        }

        // java.lang 의 System 객체 사용!
        int[] newArr = new int[firstCount + secondCount];
        System.arraycopy(firstArray, 0, newArr, 0, firstCount);
        System.arraycopy(secondArray, 0, newArr, firstCount, secondCount);
        Arrays.sort(newArr);
        Arrays.stream(newArr).forEach(e -> System.out.print(e + " "));
    }

    /**
     * 후) 내가 풀기
     * 강의 소스와 다른점: 구현의 디테일이 좀 다름 (직접 비교해보기
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

        List<Integer> answer = new LinkedList<>();
        int aP = 0, bP = 0;
        while (aP < aCnt && bP < bCnt) {
            int a = aArr[aP];
            int b = bArr[bP];

            // 다른 구간 A
            if (a < b) {
                answer.add(a);
                aP++;
            } else {
                answer.add(b);
                bP++;
            }
        }

        // 다른 구간 B
        if (aCnt < bCnt) {
            for (int i = bP; i < bCnt; i++) {
                answer.add(bArr[i]);
            }
        } else {
            for (int i = aP; i < aCnt; i++) {
                answer.add(aArr[i]);
            }
        }

        answer.stream().forEach(e -> System.out.print(e + " "));
    }


    private static void solution(Scanner scanner) {
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

        List<Integer> answer = new LinkedList<>();
        int aP = 0, bP = 0;
        while (aP < aCnt && bP < bCnt) {
            // 다른 구간 A - 강의 소스가 더 간결하네?(내 소스가 더 간결하다고 생각했는데.. 근데 이건 소스 컨벤션 문제도 있으니까..
            if (aArr[aP] < bArr[bP]) answer.add(aArr[aP++]);
            else answer.add(bArr[bP++]);
        }

        // 다른 구간 B - 여기도 강의소스가 더 간결한 것 같다 - 나는 while 문을 잘 쓰지 않는 경향이 있다. 익숙하지 않다.
        while(aP < aCnt) answer.add(aArr[aP++]);
        while(bP < bCnt) answer.add(bArr[bP++]);

        answer.stream().forEach(e -> System.out.print(e + " "));
    }
}
