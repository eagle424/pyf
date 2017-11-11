package com.yy.demo;

import java.util.Comparator;
import java.util.GregorianCalendar;


public class GenericTest<T extends Comparable<? super T>> {

	public   void method1(T t){
		t.compareTo(t);
		
		
	}
	
	
	
	
	public static void main(String[] args){
		GenericTest<Person > g = new GenericTest<Person >();
		Person p = new Person();
		
		
	}
}

class Person extends Base {

	
	
}



class Base implements Comparable<Base>{

	@Override
	public int compareTo(Base o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
