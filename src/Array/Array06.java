package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Array06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] array = new int[count];
        for (int i=0; i<count; i++) {
            String temp = scanner.next();
            int parseInt = Integer.parseInt(new StringBuilder(temp).reverse().toString());
            array[i] = parseInt;
        }

        // 뒤짚고
        // 정렬한 다음에
        // 최대값까지 소수 배열을 만들어 놓고
        // 소수인지 여부 체크해서 리턴
    }

    public void personal(int[] array) {
        Arrays.sort(array);
        int max = array[array.length-1];
        int[] sosuArray = new int[max+1];
        // 소수
    }
}
