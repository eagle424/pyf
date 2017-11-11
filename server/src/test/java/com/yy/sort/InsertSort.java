package com.yy.sort;

import java.util.Arrays;
import java.util.Date;

import com.yy.util.CollectionUtil;

public class InsertSort {
	/**
	 * 插入排序
	 * 
	 * @param arr
	 */
	public static <T extends Comparable<? super T>> void insertSort(T[] arr) {
		int j;

		for (int p = 1; p < arr.length; p++) {
			T temp = arr[p];
			for (j = p; j > 0 && temp.compareTo(arr[j - 1]) < 0; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = temp;
		}
	}
	
	/**
	 * Shell排序
	 * @param a
	 */
	public static <T extends Comparable<? super T>> void shellSort(T[] a) {
		int j;
		
		for (int gap = a.length / 2; gap > 0; gap >>= 1) {
			for (int i = gap; i < a.length; i++) {
				T temp = a[i];
				for (j = i; j >= gap && temp.compareTo(a[j - gap]) < 0; j -= gap) {
					a[j] = a[j - gap];
				}
				a[j] = temp;
			}
		}

	}
	
	public static <T extends Comparable<? super T>> void shellSort2(T[] a) {
		int k = 1;
		while(a.length > Math.pow(2, k+1) - 1){
			k++;
		}
		int j;
		for (; k > 0; k--) {
			int gap = (int) (Math.pow(2, k) - 1);
			for (int i = gap; i < a.length; i++) {
				T temp = a[i];
				for (j = i; j >= gap && temp.compareTo(a[j - gap]) < 0; j -= gap) {
					a[j] = a[j - gap];
				}
				a[j] = temp;
			}
		}

	}


	public static void main(String[] args) {
		
		int size = 10000*1000;
		Integer[] arr = CollectionUtil.getArray(0, size - 1, size);
		System.out.println("Array is created.");
		Date begin = new Date();
		QuickSort.quick(arr);
//		InsertSort.shellSort(arr);
		System.out.println(new Date().getTime() - begin.getTime());
		
//		System.out.println(Arrays.toString(arr));
	}

}
