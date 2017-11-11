package com.yy.sort;

import java.util.Arrays;

public class QuickSort {
	/**
	 * 快速排序
	 */
	public void fastSort(int[] arr) {

		int i = 0;
		int j = arr.length - 1;
		int m = i;
		int temp = 0;
		while (true) {
			if (i == j)
				break;
			if (m == i) {
				while (arr[m] < arr[j]) {
					j--;
				}
				temp = arr[j];
				arr[j] = arr[m];
				arr[m] = temp;
				m = j;
				i++;

			} else if (m == j) {
				while (arr[m] > arr[i]) {
					i++;
				}
				temp = arr[i];
				arr[i] = arr[m];
				arr[m] = temp;
				m = i;
				j--;
			} else {
				break;
			}

		}
		System.out.println(arr);

	}

	/**
	 * 快速排序
	 * 
	 * @param numbers
	 *            带排序数组
	 */
	public static <T extends Comparable<? super T>> void quick(T[] numbers) {
		 // 查看数组是否为空
		if (numbers.length > 0) {
			quickSort(numbers, 0, numbers.length - 1);
		}
	}

	/**
	 * 
	 * @param numbers
	 *            带排序数组
	 * @param low
	 *            开始位置
	 * @param high
	 *            结束位置
	 */
	public static <T extends Comparable<? super T>> void quickSort(
			T[] numbers, int low, int high) {
		if (low < high) {
			int middle = getMiddle(numbers, low, high); // 将numbers数组进行一分为二
			quickSort(numbers, low, middle - 1); // 对低字段表进行递归排序
			quickSort(numbers, middle + 1, high); // 对高字段表进行递归排序
		}

	}

	/**
	 * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
	 * 
	 * @param numbers
	 *            带查找数组
	 * @param low
	 *            开始位置
	 * @param high
	 *            结束位置
	 * @return 中轴所在位置
	 */
	public static <T extends Comparable<? super T>> int getMiddle(T[] numbers,
			int low, int high) {
		T temp = numbers[low]; // 数组的第一个作为中轴
		
		while (low < high) {
			while (low < high && temp.compareTo(numbers[high]) <=0 ) {
				high--;
			}
			numbers[low] = numbers[high];// 比中轴小的记录移到低端
			while (low < high && temp.compareTo(numbers[low]) >= 0) {
				low++;
			}
			numbers[high] = numbers[low]; // 比中轴大的记录移到高端
		}
		numbers[low] = temp; // 中轴记录到尾
		return low; // 返回中轴的位置
	}

}
