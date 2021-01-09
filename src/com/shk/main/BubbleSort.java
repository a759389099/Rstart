package com.shk.main;

public class BubbleSort {
/**
 * 主方法
 * @param args
 */
	public static void main(String[] args) {
		int[] sort = { -100, 2, 777, 6, -55, 8, 4, 155, 0 };
		int[] newSort = bubblesort(sort);
		for (int i = 0; i < newSort.length; i++) {
			System.out.println(newSort[i]);
		}
		
	}
/**
 * 冒泡排序
 * @param sort 
 * @return
 */
	private static int[] bubblesort(int[] sort) {
		// 冒泡排序法

		for (int i = 0; i < sort.length - 1; i++) {

			for (int j = i; j < sort.length - 1; j++) {
				if (sort[i] > sort[j + 1]) {
					int k = sort[i];
					sort[i] = sort[j + 1];
					sort[j + 1] = k;
				}
			}

		}

		return sort;
	}

}
