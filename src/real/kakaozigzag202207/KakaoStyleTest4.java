package real.kakaozigzag202207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 제출X - 두번째샘플 답이 아님
public class KakaoStyleTest4 {
    public static void main(String[] args) {
        KakaoStyleTest4 kakaoStyleTest = new KakaoStyleTest4();

        /*int[][] arr = {{10, 100000}, {4, 35000}, {1, 15000}};
        int result = kakaoStyleTest.solution2(50, arr);
        System.out.println("result = " + result);*/

        int[][] arr2 = {{6, 30000}, {3,18000}, {4,28000}, {1, 9500}};
        int result2 = kakaoStyleTest.solution2(20, arr2);
        System.out.println("result2 = " + result2);
    }

    // 목표 : n개 살 때 최소 비용
    // n = 사고싶은 갯수
    // [][] : 판매단위, 단위 가격
    public int solution2(int n, int[][] battery) {
        int answer = 0;
        List<int[]> batteryList = new ArrayList<>(Arrays.asList(battery));
        answer = getMinPriceIndex(n, batteryList);
        return answer;
    }

    private int getMinPriceIndex(int rest, List<int[]> battery) {
        System.out.println("rest = " + rest + ", battery=" + battery.size());
        int minIndex = 0;
        int minOnePrice = Integer.MAX_VALUE;
        List<Integer> restPrice = new ArrayList<>();
        //int resultRest = rest;

        for (int i = 0; i < battery.size(); i++) {
            int[] oneBattery = battery.get(i);
            int unit = oneBattery[0];
            int unitPrice = oneBattery[1];
            int onePrice = unitPrice / unit;
            if (minOnePrice > onePrice) {
                minOnePrice = onePrice;
                minIndex = i;
            }
            int setCnt = rest / unit;
            int calculatedPrice = setCnt * unitPrice;
            restPrice.add(calculatedPrice);
        }

        Integer minPrice = restPrice.get(minIndex);
        rest = rest - (rest / battery.get(minIndex)[0]) * battery.get(minIndex)[0];
        battery.remove(minIndex);
        if (rest > 0) {
            minPrice = minPrice + getMinPriceIndex(rest, battery);
        }
        return minPrice;
    }
}
