package programers.완전탐색;

import utils.ArrayUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 완전탐색 > 소수 찾기 (Lv.2)
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
public class BruteForce02 {
    public static void main(String[] args) {
        BruteForce02 main = new BruteForce02();

        String sample1 = "17";
        String sample2 = "011";

        //System.out.println("sample1: " + main.solution(sample1));
        System.out.println("sample2: " + main.solution(sample2));
    }

    char[] array;
    int[] stack;
    int arrCnt;

    Set<Integer> sosus = new HashSet<>();

    /**
     * 2022-04: 실패.
     * 컨셉: dfs로 모든 경우의수를 구하면서 동시에 소수 여부를 체크하여 결과를 반환한다.
     *
     * 실패원인:
     */
    public int solution(String numbers) {
        array = numbers.toCharArray();
        arrCnt = array.length;
        stack = new int[array.length];
        sosus.clear();

        // 원인2 아무리 찍어도 101이 나오지 않는다.
        for (int i=0; i<array.length; i++) {
            System.out.println("i = " + i + ", arr[i]=" + array[i]);
            dfs(i);
        }

        for (Integer x : sosus) {
            System.out.println(x);
        }
        return sosus.size();
    }

    // root는 chars[0]부터 시작한다.
    private void dfs(int Level) {

        if (Level == arrCnt) {
            String tempStr = "";
            for (int i = 0; i < arrCnt; i++) {
                if (stack[i] == 1) {
                    tempStr += (array[i]);
                }
            }

            System.out.println("tempStr = " + tempStr);

            if (!tempStr.equals("")) {

                System.out.println(tempStr);
                // 원인1 "011"를 입력했을 때, 내가 예상한 것은 모든 경우의 수가 여기서 찍혀야 되는데 101이 찍히지 않는다. => DEF로 부분집합 구하는 것은 원소의 위치는 상관없이 포함여부만 체크되기 때문이다.
                // 만약 모든 경우의 수를 구하고 싶다면 -> 루트를 항상 바꿔서 또 실행해 줘야 한다. -> 아니다, 아무리 찍어봐도 101이 안나온다. 왜인지 모르겠다.(원인2 보기)
                //011
                //01
                //01
                //0
                //11
                //1
                //1
                //0
                //11
                //sample2: 2

                if (tempStr.length() > 1) {
                    StringBuilder reverse = new StringBuilder(tempStr).reverse();
                    int tempInt = Integer.parseInt(reverse.toString());

                    // 소수체크
                    if (isSosu(tempInt)) {
                        //System.out.println(tempInt);
                        sosus.add(tempInt);
                    }
                }

                int tempInt = Integer.parseInt(tempStr);
                // 소수체크
                if (isSosu(tempInt)) {
                    //System.out.println(tempInt);
                    sosus.add(tempInt);
                }
            }
        } else {
            stack[Level] = 1;
            dfs(Level + 1);

            stack[Level] = 0;
            dfs(Level + 1);
        }
    }

    Map<Integer, Boolean> sosuMemory = new HashMap<>();
    private boolean isSosu(int tempInt) {
        if (!sosuMemory.containsKey(tempInt)) {
            if (tempInt == 1) sosuMemory.put(tempInt, false);
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
}
