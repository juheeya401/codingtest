package Sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * todo 강의풀이
 * 03-01. 두 배열 합치기
 * 2022-04-07: ⭕️
 */
public class Sum01 {
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


    private static void personal(Scanner scanner) {
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

            if (a < b) {
                answer.add(a);
                aP++;
            } else {
                answer.add(b);
                bP++;
            }
        }

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
}
