package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Array06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        personal(scanner);
    }

    /** 혼자풀기(전) ⭕
     * 뒤짚고
     * 정렬한 다음에
     * 최대값까지 소수 배열을 만들어 놓고
     * 소수인지 여부 체크해서 리턴
     **/
    public static void personal(Scanner scanner) {
        int count = scanner.nextInt();
        int[] array = new int[count];
        for (int i=0; i<count; i++) {
            String temp = scanner.next();
            int parseInt = Integer.parseInt(new StringBuilder(temp).reverse().toString());
            array[i] = parseInt;
        }
        int[] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);
        int maxNum = sortedArray[count-1];
        // 소수배열 만들어 놓기
        int[] sosuArray = createSosuArray(maxNum);

        for (int num : array) {
            if (sosuArray[num] == 0) {
                System.out.print(num + " ");
            }
        }
    }

    /***
     * 소수 구하기
     * index = 숫자, 배열값 = 소수 여부(0=소수, 1=소수아님)
     */
    private static int[] createSosuArray(int maxNum) {
        int[] sosuArray = new int[maxNum+1];
        sosuArray[0] = 1;
        sosuArray[1] = 1;
        for (int i=2; i<=maxNum; i++) {
            if (sosuArray[i] == 0) {
                for (int j=i; j<=maxNum; j=j+i) {
                    if (j > i) {        // i 본인은 소수이므로 0 유지해야 함.
                        sosuArray[j] = 1;
                    }
                }
            }
        }
        return sosuArray;
    }
}
