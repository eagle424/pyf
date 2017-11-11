package com.yy.tree;



public class BinaryNode<Integer> {
	
	Integer element;
	
	BinaryNode<Integer> left;
	BinaryNode<Integer> right;

	BinaryNode(Integer element){
		this(element, null, null);
	}
	
	BinaryNode(Integer element, BinaryNode<Integer> left, BinaryNode<Integer> right){
		this.element = element;
		this.left = left;
		this.right = right;
	}
	
}
