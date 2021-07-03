package com.shk.main.util;
import java.util.*;

/*
方法一：按照出现频率排序
        题目要求将给定的字符串按照字符出现的频率降序排序，因此需要首先遍历字符串，统计每个字符出现的频率，然后每次得到频率最高的字符，生成排序后的字符串。

        可以使用哈希表记录每个字符出现的频率，将字符去重后存入列表，再将列表中的字符按照频率降序排序。

        生成排序后的字符串时，遍历列表中的每个字符，则遍历顺序为字符按照频率递减的顺序。对于每个字符，将该字符按照出现频率拼接到排序后的字符串。例如，遍历到字符 cc，该字符在字符串中出现了 \textit{freq}freq 次，则将 \textit{freq}freq 个字符 cc 拼接到排序后的字符串。
        也可以使用优先队列或大根堆存储字符，读者可以自行尝试。*/
public class Freq {

    public static void main(String[] args) {
        System.out.println(sortStr("sortStr"));
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


        list.sort((o1, o2) -> o2 - o1);
        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        return sb.toString();
    }

}
