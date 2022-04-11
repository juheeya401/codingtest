package programers.완전탐색;

import java.util.*;

/**
 * 완전탐색 > 소수 찾기 (Lv.2)
 * 쉬운줄 알았는데 안쉽네;;;
 * <p>
 * 문제 설명
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 * 제한사항
 * numbers는 길이 1 이상 7 이하인 문자열입니다.
 * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 * "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 * 입출력 예
 * numbers	return
 * "17"	    3
 * "011"	2
 * 입출력 예 설명
 * 예제 #1
 * [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
 * 예제 #2
 * [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
 * 11과 011은 같은 숫자로 취급합니다.
 */
public class BruteForce02re {
    public static void main(String[] args) {
        BruteForce02re main = new BruteForce02re();

        String sample1 = "17";
        String sample2 = "011";

        System.out.println("sample1: " + main.solution(sample1));
        System.out.println("sample2: " + main.solution(sample2));
    }

    /**
     * 2022-04: 시도2 -> 실패
     * 컨셉: 그냥 반복문으로 모든 경우의 집합을 구한뒤 소수여부를 체크한다.
     * <p>
     * 실패분석:
     * all = 1,17,71
     * sosu = 17, 71  <= 7이 나오지 않았음... 아놔..  반복문을 한 번 더 써야 하나봄..
     * sample1: 2 <= 답도 틀림 3이 나와야 함.
     */
    public int solution(String numbers) {
        List<String> all = new ArrayList<>();

        Set<Integer> sosus = new HashSet<>();
        char[] chars = numbers.toCharArray();

        for (int j = 1; j <= chars.length; j++) {
            int length = j;
            for (int i = 0; i < length; i++) {
                StringBuilder temp = new StringBuilder();
                int pointer = i;
                do {
                    //temp += chars[pointer];
                    temp.append(chars[pointer]);
                    if (++pointer == length) pointer = 0;
                } while (pointer != i);
                all.add(temp.toString());

                // 숫자로 변환
                int parseInt = Integer.parseInt(temp.toString());
                if (isSosu(parseInt)) sosus.add(parseInt);
            }
        }

        System.out.println(String.join(",", all));
        sosus.forEach(e -> System.out.print(e + ", "));
        return sosus.size();
    }

    Map<Integer, Boolean> sosuMemory = new HashMap<>();

    private boolean isSosu(int tempInt) {
        if (!sosuMemory.containsKey(tempInt)) {
            if (tempInt == 1 || tempInt == 0) sosuMemory.put(tempInt, false);
            else {
                boolean sosu = true;
                for (int i = 2; i < tempInt; i++) {
                    if (tempInt % i == 0) {
                        sosu = false;
                        break;
                    }
                }
                sosuMemory.put(tempInt, sosu);
            }
        }
        return sosuMemory.get(tempInt);
    }





    public int solutionSample(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int count = 0;
        while (set.iterator().hasNext()) {
            int a = set.iterator().next();
            set.remove(a);
            if (a == 2) count++;
            if (a % 2 != 0 && isSosu(a)) {
                count++;
            }
        }
        return count;
    }

    public void permutation(String prefix, String str, HashSet<Integer> set) {
        int strLen = str.length();
        if (!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < strLen; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, strLen), set);

    }
}
