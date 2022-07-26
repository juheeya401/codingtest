package real.line202204;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

// todo 구분자가 원하는 순서대로 출력해야 함.
public class Line01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String d = sc.nextLine();
        String text = sc.nextLine();

        Line01 main = new Line01();
        Set<String> separatorStringSet = new LinkedHashSet<>();
        main.makeSeparatorStringSet("", d, separatorStringSet);

        for (String separatorString : separatorStringSet) {
            System.out.println(joinText(text, separatorString));
        }
    }

    private static String joinText(String text, String separatorString) {
        StringBuilder answer = new StringBuilder();
        char[] separators = separatorString.toCharArray();
        int separatorPointer = 0;
        for (int i = 0; i < text.length() - 1; i++) {
            answer.append(text.charAt(i));
            answer.append(separators[separatorPointer]);
            if (++separatorPointer == separators.length) separatorPointer = 0;
        }
        answer.append(text.charAt(text.length() - 1));
        return answer.toString();
    }

    // todo 구분자가 원하는 순서대로 출력해야 함.
    public void makeSeparatorStringSet(String prefix, String str, Set<String> set) {
        int n = str.length();
        if (!prefix.equals("")) {
            set.add(prefix);
        }
        for (int i = 0; i < n; i++) {
            makeSeparatorStringSet(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
        }
    }
}
