package Sum;

import java.util.*;

/**
 * 2022-03-30: ❌
 */
public class Sum01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        personal(scanner);
    }

    /**
     * 사전풀이: ❌
     * 원인분석:
     */
    private static void personal(Scanner scanner) {
        int firstCount = scanner.nextInt();
        Integer[] firstArray = new Integer[firstCount];
        for (int i = 0; i < firstCount; i++) {
            firstArray[i] = scanner.nextInt();
        }

        int secondCount = scanner.nextInt();
        Integer[] secondArray = new Integer[secondCount];
        for (int i = 0; i < secondCount; i++) {
            secondArray[i] = scanner.nextInt();
        }

        Set<Integer> sortedList = new LinkedHashSet<>();

        // start------------------------------------
        List<Integer> firstList = Arrays.asList(firstArray);
        List<Integer> secList = Arrays.asList(secondArray);

        sortedList.addAll(firstList);
        sortedList.addAll(secList);
        sortedList.stream().sorted().forEach(e -> System.out.print(e + " "));
    }
}
