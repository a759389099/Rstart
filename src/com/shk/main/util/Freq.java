package com.shk.main.util;

import java.util.*;

/*
给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
*/
public class Freq {

    public static void main(String[] args) {
        System.out.println(sortStr("tree"));
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums).forEach(System.out::println);

    }

    public static String sortStr(String originStr) {

        HashMap<Character, Integer> map = new HashMap<>();
        int length = originStr.length();
        for (int i = 0; i < length; i++) {
            char c = originStr.charAt(i);
            Integer frequent = map.getOrDefault(c, 0) + 1;
            map.put(c, frequent);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));
        StringBuilder sb = new StringBuilder();
        list.forEach(character -> {
            for (int i = 0; i < map.get(character); i++)
                sb.append(character);
        });
        return sb.toString();
    }


    /**
     * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        HashSet<List<Integer>> resultset = new HashSet<>();
        List<List<Integer>> resultList =new ArrayList<>(resultset);

        int length = nums.length;
        if (length < 3) {
            // 数组长度不能小于3
            return resultList;
        }
        // 先冒泡排序
        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = i; j < nums.length - 1; j++) {
                if (nums[i] > nums[j + 1]) {
                    int k = nums[i];
                    nums[i] = nums[j + 1];
                    nums[j + 1] = k;
                }
            }

        }


        // 第一个指针
        for (int i = 0; i < length - 2; i++) {
            // 左指针
            int j = i + 1;
            // 右指针
            int k = length - 1;
            while (j < k) {
                List<Integer> integerList = new ArrayList<>();
                if (nums[i] + nums[j] + nums[k] == 0) {
                    // 存到集合里
                    integerList.add(nums[i]);
                    integerList.add(nums[j]);
                    integerList.add(nums[k]);
                    resultset.add(integerList);
                    // 左移,右移皆可
                    j++;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    // 小于0 左指针右移
                    j++;
                } else {
                    // 大于0 右指针左移
                    // nums[i] +nums[j] +nums[k]>0
                    k--;
                }
            }
        }
        resultList =new ArrayList<>(resultset);

        return resultList;
    }
}
