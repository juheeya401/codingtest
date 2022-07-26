package real.line202204;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Line03 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[][] arr = new int[a][2];
        for (int i = 0; i < a; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Set<String> set = getStrings(a, arr);

        System.out.println(set.size());
    }

    private static Set<String> getStrings(int a, int[][] arr) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (i == j) continue;
                if (isContain(arr[i], arr[j])) {
                    int[] newArr = new int[4];
                    System.arraycopy(arr[i], 0, newArr, 0, arr[i].length);
                    System.arraycopy(arr[j], 0, newArr, arr[i].length, arr[j].length);

                    String s = Arrays.stream(newArr)
                            .mapToObj(String::valueOf)
                            .sorted()
                            .collect(Collectors.joining());
                    set.add(s);
                }
            }
        }
        return set;
    }

    private static boolean isContain(int[] aArray, int[] bArray) {
        for (int a : aArray) {
            for (int b : bArray) {
                if (a == b) return true;
            }
        }
        return false;
    }
}
