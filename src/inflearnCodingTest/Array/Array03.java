package inflearnCodingTest.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 02-03 가위 바위 보
 * 2022-03-11: ⭕
 */
public class Array03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //personal01_main(scanner);
        //solution_main(scanner);
        personal02_main(scanner);
    }

    // 이김=1, 비김=0, 짐=-1
    private static int isWin(int a, int b) {
        switch (a){
            case 1:
                return b == 1 ? 0 : b == 2 ? -1 : 1;
            case 2:
                return b == 1 ? 1 : b == 2 ? 0 : -1;
            case 3:
                return b == 1 ? -1 : b == 2 ? 1 : 0;
            default:
                return 0;
        }
    }

    /**
     * 내가 풀기 1
     * 객체지향으로 풀려고 했으나 애매함....
     */
    private static void personal01_main(Scanner scanner) {
        int count = Integer.parseInt(scanner.nextLine());
        Person A = new Person("A", scanner.nextLine().split(" "));
        Person B = new Person("B", scanner.nextLine().split(" "));

        // 싸움자 class 'Person'를 만든다. 가위바위보 배열 array, 이름 name 을 저장한다
        // 가위바위보 함수를 만든다
        // 가위바위보 승패를 연산하는 getWinner(Person, Person) 메서드를 만든다. return은 Person의 name을 리턴한다.
        // 결과를 저장하고 출력한다

        for (int i=0; i<count; i++) {
            System.out.println(getWinner(i, A, B));
        }
    }

    private static String getWinner(int index, Person personA, Person personB) {
        int isWin = isWin(personA.getArray().get(index), personB.getArray().get(index));
        if (0 == isWin) {
            return "D";
        } else if (1 == isWin){
            return "A";
        } else {
            return "B";
        }
    }

    static class Person {
        String name;
        List<Integer> array = new ArrayList<>();

        public Person(String name, String[] input) {
            this.name = name;
            for (String s : input) {
                this.array.add(Integer.parseInt(s));
            }
        }

        public String getName() {
            return name;
        }

        public List<Integer> getArray() {
            return array;
        }
    }

    /**
     * 내가 풀기 2
     * 객체지향으로 풀지 않기 -> isWin() 메서드만 만들면 굳이 객체지향으로 안해도 됨.
     */
    private static void personal02_main(Scanner scanner) {
        int count = Integer.parseInt(scanner.nextLine());
        String[] aStr = scanner.nextLine().split(" ");
        String[] bStr = scanner.nextLine().split(" ");
        for (int i=0; i<count; i++) {
            String winner = personal02(Integer.parseInt(aStr[i]), Integer.parseInt(bStr[i]));
            System.out.println(winner);
        }
    }
    private static String personal02(int a, int b) {
        int isWinA = isWin(a, b);
        if (isWinA == 0) return "D";
        else if (isWinA == 1) return "A";
        else return "B";
    }

    /**
     * 강의 풀이
     * 이건.. 좀 아닌듯.. 단순히 for/if 문만 조합해서 만드는 전형적인 실무에서 하면 짜증나는 타입의 개발
     * 개발하기는 쉽겠다.
     */
    private static void solution_main(Scanner scanner) {
        int count = scanner.nextInt();
        int[] a = new int[count];
        int[] b = new int[count];
        for (int i=0; i<count; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i=0; i<count; i++) {
            b[i] = scanner.nextInt();
        }
        char[] chars = solution(count, a, b).toCharArray();
        for (char c : chars) {
            System.out.println(c);
        }
    }

    private static String solution(int count, int[] a, int[] b) {
        String answer = "";

        for (int i=0; i<count; i++) {
            if (a[i] == b[i]) {
                answer += "D";
            } else if (a[i] == 1 && b[i] == 3) {
                answer += "A";
            } else if (a[i] == 2 && b[i] == 1) {
                answer += "A";
            } else if (a[i] == 3 && b[i] == 2) {
                answer += "A";
            } else {
                answer += "B";
            }
        }
        return answer;
    }
}
