package Sum;

import java.util.Arrays;
import java.util.Scanner;

/**
 * todo 강의풀이
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
    private static void personal(Scanner scanner) {
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
}
