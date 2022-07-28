package com.example.leetCode;

public class StandSolution {

    public static int minDays(int[] bloomDay, int m, int k) {
        if (m > bloomDay.length / k) {
            return -1;
        }
        int low = Integer.MAX_VALUE, high = 0;
        int length = bloomDay.length;
        for (int i = 0; i < length; i++) {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }
        while (low < high) {
            int days = (high - low) / 2 + low;
            if (canMake(bloomDay, days, m, k)) {
                high = days;
            } else {
                low = days + 1;
            }
        }
        return low;
    }

    public static boolean canMake(int[] bloomDay, int days, int m, int k) {
        int bouquets = 0;
        int flowers = 0;
        int length = bloomDay.length;
        for (int i = 0; i < length && bouquets < m; i++) {
            if (bloomDay[i] <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }

    public static void main(String[] args) {
        //制作 m 束花所需的最少天数
        int[] arr = new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
        int m = 4, k = 2;
        int[] arr4 = new int[]{1, 2, 10, 9, 3, 8, 4, 7, 5};
        int m4 = 4, k4 = 2;
        int[] arr1 = new int[]{5, 37, 55, 92, 22, 52, 31, 62, 99, 64, 92, 53, 34, 84, 93, 50, 28};
        int m1 = 8, k1 = 2;
        int[] arr2 = new int[]{7, 7, 7, 12, 7, 7, 7};
        int m2 = 2, k2 = 3;
        int[] arr3 = new int[]{7, 7, 7, 7, 12, 7, 7};
        int m3 = 2, k3 = 3;
        System.out.println(minDays(arr, m, k));
/*        System.out.println(minDays(arr4, m4, k4));
        System.out.println(minDays(arr1, m1, k1));
        System.out.println(minDays(arr2, m2, k2));
        System.out.println(minDays(arr3, m3, k3));*/
    }

}
