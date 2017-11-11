package com.yy.util;

public class EnumSet {
	public enum DepartmentType{
		DEPARTMENT_FIRST("一部",0),
		DEPARTMENT_SECOND("二部",1),
		DEPARTMENT_THIRD("三部",2);
		private String name;
		private int index;
		
		DepartmentType(String name, int index){
			this.name = name;
			this.index = index;
		}
		
		public static String getName(int index){
			for(DepartmentType ls : DepartmentType.values()){
				if(index == ls.index){
					return ls.name;
				}
			}
			return null;
		}
		
		public static DepartmentType getEnum(int index){
			for(DepartmentType ls : DepartmentType.values()){
				if(index == ls.index){
					return ls;
				}
			}
			return null;
		}
		
		public String getLabel(){
			return toString();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}
	}
	
	class Test{
		public void test(){
			
		}
	}
	
	public static void main(String[] args){
		String name = DepartmentType.getName(0);
		DepartmentType d = DepartmentType.getEnum(0);
		
		System.out.println(DepartmentType.DEPARTMENT_FIRST);
		System.out.println(name);
	}
}
