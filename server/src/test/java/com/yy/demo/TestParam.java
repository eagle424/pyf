package com.yy.demo;

public class TestParam {
	public static class Person{
		private String name ;
		Person(String name){
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
	public void method(String s, int i, Person p){
		s = "222";
		i = 2;
		p = new Person("小李");
	}
	
	public static void main(String[] args){
		String s = "111";
		int i = 1;
		Person p = new TestParam.Person("piaoyongfan");
		TestParam c = new TestParam();
	
		c.method(s, i, p);
		System.out.println(s);
		System.out.println(i);
		System.out.println(p.name);
	}
}
