package com.example.leetCode;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int arrs[] = new int[map.size()];
        int p = 0;
        for (int a : map.keySet()) {
            arrs[p] = map.get(a);
            p++;
        }
        Arrays.sort(arrs);
        int sums = 0;
        int n = 0;
        for (int i = 0; i < arrs.length; i++) {
            sums = sums + arrs[i];
            if (sums > k) {
                n = arrs.length - i;
                break;
            }
        }
        return n;
    }


    public static int findLeastNumOfUniqueInt(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int count[] = new int[map.size()];
        int p = 0;
        for (int a : map.keySet()) {
            count[p] = map.get(a);
            p++;
        }
        Arrays.sort(count);
        for (int i = 0; ; i++) {
            k -= count[i];
            if (k == 0) {
                return count.length - i - 1;
            } else if (k < 0) {
                return count.length - i;
            }
        }
    }


    public static int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        if (m * k == bloomDay.length) {
            Arrays.sort(bloomDay);
            return bloomDay[bloomDay.length - 1];
        }
        int[] days = new int[bloomDay.length];
        for (int i = 0; i < bloomDay.length; i++) {
            int max = 0;
            if (k + i < bloomDay.length) {
                for (int j = i; j < k + i; j++) {
                    if (max < bloomDay[j]) {
                        max = bloomDay[j];
                    }
                }
                days[i] = max;
            }
            if (k + i >= bloomDay.length) {
                max = 0;
                for (int h = i; h < bloomDay.length; h++) {
                    if (max < bloomDay[h]) {
                        max = bloomDay[h];
                    }
                }
                days[i] = max;
            }
        }
        Arrays.sort(days);
        boolean falg = false;
        int maxNum = days[days.length - 1];
        for (int b = 0; b < bloomDay.length; b++) {
            if (maxNum == bloomDay[b] && b % k == 0) {
                falg = true;
            }
        }
        if (days.length % k > 0 && m >= 1 && falg) {
            return days[m * k - k];
        }
        return days[m * k - 1];
    }


    public static  int standMinDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
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
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss.SSS");
    /*
    //不同整数的最少数目
    int[] arr = new int[]{5,5,4};
    int k = 1;
    System.out.println(format.format(System.currentTimeMillis()));
    int n = findLeastNumOfUniqueInts(arr, k);
    System.out.println(n);
    System.out.println(format.format(System.currentTimeMillis()));*/

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
/*        System.out.println(minDays(arr, m, k));
        System.out.println(minDays(arr4, m4, k4));
        System.out.println(minDays(arr1, m1, k1));
        System.out.println(minDays(arr2, m2, k2));
        System.out.println(minDays(arr3, m3, k3));*/
        System.out.println(standMinDays(arr3, m3, k3));
    }


}
