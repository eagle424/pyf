package com.yy.util;

import java.util.Arrays;

public class Test {
	public static <T extends Comparable<? super T>> int binarySearch(T[] a, int from, int to, T key){
		Arrays.sort(a);
		int mid;
		int rtn;
		to--;
//		if(key.compareTo(a[from]) < 0 || key.compareTo(a[to]) > 0 )
//			return -1;
		while(from <= to){
			mid = (from + to) >>> 1;
			rtn = key.compareTo(a[mid]);
			if(rtn == 0)
				return mid;
			else if (rtn < 0)
				to = mid - 1;
			else
				from = mid + 1;
			
		}
		return -1;
	}
	
	public static void main(String[] args){
		int size = 100;
		Integer[] a = CollectionUtil.getArray(0, size, size);
		int idx = 0;
		idx = binarySearch(a, 0, 100, 999);
		System.out.println(idx);
		
	}
}
