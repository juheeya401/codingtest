package Sum;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Sum02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        personal(scanner);
    }

    private static void personal(Scanner scanner) {
        Set<Integer> answer = new LinkedHashSet<>();

        int[] array = new int[1000000000 + 1];

        int cntA = scanner.nextInt();
        for (int i=0; i<cntA; i++) {
            int temp = scanner.nextInt();
            array[temp] = 1;
        }

        int cntB = scanner.nextInt();
        for (int i=0; i<cntB; i++) {
            int temp = scanner.nextInt();
            if (array[temp] == 1) {
                answer.add(temp);
            }
        }

        answer.stream().sorted().forEach(e -> System.out.print(e + " "));
    }
}
