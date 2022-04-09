package inflearnCodingTest.HashmapTreeset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * todo 강의
 * 04-01. 학급 회장(해쉬)
 * 2022-04-08: ⭕️ -> 맞긴한데 찜찜.
 */
public class HashmapTreeset01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        personal(scanner);
    }

    private static void personal(Scanner scanner) {
        int cnt = scanner.nextInt();
        scanner.nextLine();
        char[] users = scanner.nextLine().toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<cnt; i++) {
            Character key = users[i];
            Integer value = map.get(key) != null ? map.get(key) : 0;
            map.put(key, value + 1);
        }

        int max = 0;
        Character person = null;
        for (Character key : map.keySet()) {
            Integer integer = map.get(key);
            if (integer > max) {
                max = integer;
                person = key;
            }
        }

        System.out.println(person);
    }
}
