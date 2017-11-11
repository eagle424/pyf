package com.yy.util;

import java.util.HashMap;
import java.util.Map;

public class BinarySearch {

	public static <T extends Comparable<? super T>> int binarySearch(T[] a,
			int low, int high, T dist) {
		high--;
		int mid = (low + high) / 2;

		// if(dist.compareTo(a[low]) < 0 || dist.compareTo(a[high]) > 0 || low >
		// high)
		// return -1;
		if (dist.compareTo(a[mid]) < 0)
			return binarySearch(a, low, mid - 1, dist);
		else if (dist.compareTo(a[mid]) > 0)
			return binarySearch(a, mid + 1, high, dist);
		else
			return mid;

	}

	private static int fac(int n) {
		if (n <= 2)
			return 1;
		else
			return fac(n - 1) + fac(n - 2);
	}

	public static void main(String[] args) {
		Map<String, String> a = new HashMap<String, String>();
		int size = 100;
		// Integer[] arr = CollectionUtil.getArray(0, size - 1, size);
//		Integer[] arr = new Integer[] { 0, 2, 5, 6, 9, 8 };
//		QuickSort.quick(arr);
//		int idx = binarySearch(arr, 0, arr.length - 1, 2);
		for(int i=1; i < 10; i++){
			System.out.println(fac(i));
			
		}
		a.notify();
//		System.out.println(idx);
	}

}
