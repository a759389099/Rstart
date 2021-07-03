package com.shk.main.util;

import java.util.*;

/*
给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
*/
public class Freq {

    public static void main(String[] args) {
        System.out.println(sortStr("tree"));
    }

    public static String sortStr(String originStr) {

        HashMap<Character, Integer> map = new HashMap<>();
        Integer length = originStr.length();
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
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length - 2; i++) {
            int j = i + 1;
            int k = length - 1;


        }

        return null;
    }

        return null;
}

}
