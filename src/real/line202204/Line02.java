package real.line202204;

import java.util.*;

/**
 * 입력
 * 1,2,3
 * 2552551235
 */
public class Line02 {

    public static void main(String[] args) {
        String d = "123";
        String text = "2552551235";

        Set<String> set = new LinkedHashSet<>();
        permutation("", d, set);

        for (String level : set) {
            //System.out.println("level = " + level);
            //System.out.println(joinText(text, level));
            joinText(text, level);
        }
    }

    private static List<Integer[]> joinText(String text, String level) {
        List<Integer[]> answer = new ArrayList<>();

        int[] levels = new int[level.length()];
        for (int i=0; i<level.length(); i++) {
            levels[i] = Character.getNumericValue(level.charAt(i));
        }

        int levelPointer = 0;

        //Integer[] temp = new Integer[4];
        String newIp = "";
        for (int i = 0; i < 4; i++) {
            int tempSize = levels[levelPointer];
            String temp = text.substring(newIp.length());

            // 조건에 맞지 않으면 바로 null 반환
            if (temp.length() < tempSize) return null; // 마지막 자릿수 부족할 때

            String tempIp = temp.substring(0, tempSize);
            System.out.println("temp= " + temp + ", tempSize= " + tempSize + " ==> tempIp = " + tempIp);
            if (Integer.parseInt(tempIp) > 255 || Integer.parseInt(tempIp) < 0) return null; // 범위가 맞지 않을

            newIp += tempIp;

            //int prePointer = levelPointer - 1 >= 0 ? levelPointer - 1 : levels.length-1;
            //temp[i] = Integer.valueOf(text.substring(i + levels[prePointer], i + levels[levelPointer]));
            if (++levelPointer == levels.length) levelPointer = 0;
        }

        //if (newIp.length() != text.length()) return null;

        System.out.println(newIp);
        return answer;
    }


    public static void permutation(String prefix, String str, Set<String> set) {
        int n = str.length();
        if (!prefix.equals("") && prefix.length() == 3) {
            set.add(prefix);
        }
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
    }
}

