package com.shk.main.util;

import java.util.*;

/*
给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
*/
public class Freq {

    public static void main(String[] args) {
//        System.out.println(sortStr("tree"));
        int[] nums = {-1, 0, 1, 6, 3, -4};
//        threeSum(nums).forEach(System.out::println);
//        String[] strArr = {"flower", "flow", "flight"};
//        String[] strArr = {"c", "acc", "ccc"};
//        longestCommonPrefix(strArr);

       /* int[] ints = buildArray(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }*/

        //System.out.println(lengthOfLastWord("Hello World"));
//        removeElement();

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
        List<List<Integer>> resultList = new ArrayList<>(resultset);

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
        resultList = new ArrayList<>(resultset);

        return resultList;
    }

    /*
    编写一个函数来查找字符串数组中的最长公共前缀。
    如果不存在公共前缀，返回空字符串 ""。
     */
    public static String longestCommonPrefix(String[] strs) {
        int minLength = -1;
        String minStr = null;
        if (strs.length == 1) {
            return strs[0];
        }

        for (int i = 0; i < strs.length - 1; i++) {

            for (int j = i; j < strs.length - 1; j++) {
                if (strs[i].length() > strs[j + 1].length()) {
                    String k = strs[i];
                    strs[i] = strs[j + 1];
                    strs[j + 1] = k;
                }
            }
        }
        minLength = strs[0].length();
        minStr = strs[0];

        String commonStr = "";
        for (int i = 0; i < minLength; i++) {
            int num = 0;
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].substring(0, i + 1).equals(minStr.substring(0, i + 1))) {
                    num++;
                }
            }
            if (num == strs.length) {
                //暂存这个公共前缀
                commonStr = minStr.substring(0, i + 1);
            }
        }
        return commonStr;
    }

    /**
     * 给你一个 从 0 开始的排列 nums（下标也从 0 开始）。请你构建一个 同样长度 的数组 ans ，其中，对于每个 i（0 <= i < nums.length），都满足 ans[i] = nums[nums[i]] 。返回构建好的数组 ans 。
     * 从 0 开始的排列 nums 是一个由 0 到nums.length - 1（0 和 nums.length - 1 也包含在内）的不同整数组成的数组。
     * 1 <= nums.length <= 1000
     * 0 <= nums[i] < nums.length
     * nums 中的元素 互不相同
     */
    public static int[] buildArray(int[] nums) {
        nums = BubbleSort.bubblesort(nums);
        int[] ans = new int[nums.length];


        return ans;
    }

    /**
     * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
     * <p>
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     */
    public static int lengthOfLastWord(String s) {
        String[] nums = s.split(" ");
        if (nums.length < 1) {
            return 0;
        }
        return nums[nums.length - 1].length();
    }

    /**
     * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
     * <p>
     * 子数组 是数组的一段连续部分。
     */
    public static int numSubarraysWithSum(int[] nums, int goal) {

        /*示例 1：
        输入：nums = [1,0,1,0,1], goal = 2
        输出：4
        解释：
        有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]

        示例 2：
        输入：nums = [0,0,0,0,0], goal = 0
        输出：15*/
        // 长度从1-长度
        // 遇事不决先排序
        nums = BubbleSort.bubblesort(nums);
        //

        return 0;
    }


    /**
     * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     */
    public static void removeElement(int val,int[] nums){



    }


}
