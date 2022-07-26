package real.kakaozigzag202207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class KakaoStyleTest2 {
    public static void main(String[] args) {
        KakaoStyleTest2 kakaoStyleTest = new KakaoStyleTest2();

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

        int minIndex = getMinPriceIndex(n, batteryList);
        int minUnit = batteryList.get(minIndex)[0];
        int setCnt = 0;
        if (n < minUnit) {
            batteryList.remove(minIndex);
            minIndex = getMinPriceIndex(n, batteryList);
            minUnit = batteryList.get(minIndex)[0];
        }
        setCnt = n / minUnit;
        answer = setCnt * batteryList.get(minIndex)[1];

        // 나머지는 반복문을 돌리면서 계산
        int rest3 = n - setCnt * battery[minIndex][0];
        int restMinPriceAsInt = getRestMinPriceAsInt(battery, rest3);
        return answer + restMinPriceAsInt;
    }

    private int getMinPriceIndex(int n, List<int[]> battery) {
        int minIndex = 0;
        int minOnePrice = Integer.MAX_VALUE;

        for (int i = 0; i < battery.size(); i++) {
            int[] oneBattery = battery.get(i);
            int unit = oneBattery[0];
            int unitPrice = oneBattery[1];
            int onePrice = unitPrice / unit;

            if (minOnePrice > onePrice) {
                minOnePrice = onePrice;
                minIndex = i;
            }
        }
        return minIndex;
    }

    private int getRestMinPriceAsInt(int[][] battery, int rest) {
        List<Integer> restPrice = new ArrayList<>();
        Arrays.stream(battery).forEach(e -> {
            int unit = e[0];
            int unitPrice = e[1];
            int calculatedPrice = rest / unit * unitPrice;
            if (rest % unit > 0) {
                calculatedPrice = calculatedPrice + unitPrice;
            }
            restPrice.add(calculatedPrice);
        });
        OptionalInt restMinPrice = restPrice.stream().mapToInt(e -> e).min();
        int restMinPriceAsInt = restMinPrice.getAsInt();
        System.out.println("rest=" + rest + ", restMinPriceAsInt = " + restMinPriceAsInt);
        return restMinPriceAsInt;
    }
}
