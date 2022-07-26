package real.kakaozigzag202207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class KakaoStyleTest3 {
    public static void main(String[] args) {
        KakaoStyleTest3 kakaoStyleTest = new KakaoStyleTest3();

        int[][] arr = {{10, 100000}, {4, 35000}, {1, 15000}};
        int result = kakaoStyleTest.solution2(50, arr);
        System.out.println("result = " + result);

        int[][] arr2 = {{6, 30000}, {3, 18000}, {4, 128000}, {1, 9500}};
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
        int minIndex = 0;
        int minOnePrice = Integer.MAX_VALUE;
        List<Integer> restPrice = new ArrayList<>();

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
            if (rest % unit > 0) {
                calculatedPrice = calculatedPrice + unitPrice;
            }
            restPrice.add(calculatedPrice);

            rest = rest - setCnt * unit;
        }

        Integer minPrice = restPrice.get(minIndex);
        battery.remove(minIndex);
        if (rest > 0) {
            minPrice = getMinPriceIndex(rest, battery);
        }
        return minPrice;
    }
}
