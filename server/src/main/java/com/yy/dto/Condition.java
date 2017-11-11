package com.yy.dto;

import java.util.List;
import java.util.Map;

public class Condition {
	
	public enum Relation {
		EQUAL("="),
		NOT_EQUAL("!="),
		NULL("IS"),
		NOT_NULL("IS NOT"),
		LESS("<"),
		LESS_EQUAL("<="),
		GREATER(">"),
		GREATER_EQUAL(">="),
		 /** in sql关键字ֵ */
		INCLUDE("IN"),
		 /** like sql关键字ֵ */
		LIKE("LIKE"),
		/** between sql关键字  */
		BETWEEN("BETWEEN");
		
		private final String value;

		private Relation(String value){
			this.value = value;
		}
		
		public String getValue(){
			return this.value;
		}
		
		public String toString(){
			return this.value;
		}
	}
	
	public List<ConditionUnit> ConditionUnitList;
	
	public List<Map<String,String>> orderByList;

	/**
	 * @return the conditionUnitList
	 */
	public List<ConditionUnit> getConditionUnitList() {
		return ConditionUnitList;
	}

	/**
	 * @param conditionUnitList the conditionUnitList to set
	 */
	public void setConditionUnitList(List<ConditionUnit> conditionUnitList) {
		ConditionUnitList = conditionUnitList;
	}

	/**
	 * @return the orderByList
	 */
	public List<Map<String, String>> getOrderByList() {
		return orderByList;
	}

	/**
	 * @param orderByList the orderByList to set
	 */
	public void setOrderByList(List<Map<String, String>> orderByList) {
		this.orderByList = orderByList;
	}


	
}
