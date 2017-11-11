package com.yy.dto;

import com.yy.dto.Condition.Relation;

public class ConditionUnit {
	private String name;
	private Object[] value;
	private Relation relation = Relation.EQUAL;

	public ConditionUnit(String name, Object value) {
		this(name, new Object[] { value }, Relation.EQUAL);
	}

	public ConditionUnit(String name, Object value, Relation relation) {
		this.name = name;
		this.value = new Object[] { value };
		this.relation = relation;
	}

	public ConditionUnit(String name, Object[] value, Relation relation) {
		this.name = name;
		this.value = value;
		this.relation = relation;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public Object[] getValue() {
		return value;
	}

	/**
	 * @param value
	 *            values to set
	 */
	public void setValue(Object[] value) {
		this.value = value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Object value) {
		this.value = new Object[] { value };
	}

	/**
	 * @return the relation
	 */
	public Relation getRelation() {
		return relation;
	}

	/**
	 * @param relation
	 *            the relation to set
	 */
	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	public boolean isDefaultRelation() {
		if (this.relation == Relation.BETWEEN
				|| this.relation == Relation.INCLUDE
				|| this.relation == Relation.LIKE) {
			return false;
		}
		return true;
	}
}
