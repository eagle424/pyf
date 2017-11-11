package com.yy.tree;

import java.nio.BufferUnderflowException;

public class BinarySearchTree<T extends Comparable<? super T>> {

	public static class BinaryNode<T> {

		T element;

		BinaryNode<T> left;
		BinaryNode<T> right;

		BinaryNode(T element) {
			this(element, null, null);
		}

		BinaryNode(T element, BinaryNode<T> left,
				BinaryNode<T> right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}

	}

	private BinaryNode<T> root;

	public BinarySearchTree() {
		root = null;
	}

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}
	
	/** 是否包含制定节点  */
	public boolean contains(T x) {
		return contains(x, root);
	}

	/**
	 * 是否包含制定节点
	 * @param x
	 * @param t
	 * @return
	 */
	private boolean contains(T x, BinaryNode<T> t) {
		if (t == null)
			return false;
		int compareResult = x.compareTo(t.element);
		
		if(compareResult < 0)
			return contains(x, t.left);
		else if(compareResult > 0)
			return contains(x, t.right);
		else
			return true;
	}
	
	public T findMin(){
		if (isEmpty()) throw new BufferUnderflowException();
		return findMin(root).element;
	}
	
	private BinaryNode<T> findMin(BinaryNode<T> t){
		if(t == null)
			return null;
		else if(t.left == null)
			return t;
		return findMin(t.left);
	}
	
	public T findMax(){
		if( isEmpty()) throw new BufferUnderflowException();
		return findMax(root).element;
	}
	
	/** 不适用递归实现 */
	private BinaryNode<T> findMax(BinaryNode<T> t){
		if(t != null){
			while(t.right != null)
				t = t.right;
		}
		return t;
	}
	
	public BinaryNode<T> findNode(T x){
		return findNode(x, root);
	}
	
	/**
	 * 查找节点对象
	 * @param x
	 * @param t
	 * @return
	 */
	private BinaryNode<T> findNode(T x, BinaryNode<T> t){
		
		if(t == null)
			return null;
		
		int compareResult = x.compareTo(t.element);
		if(compareResult < 0)
			return findNode(x, t.left);
		else if(compareResult > 0)
			return findNode(x, t.right);
		else
			return t;
		
	}
	
	public void insert(T x){
		root = insert(x, root);
	}
	
	private BinaryNode<T> insert(T x, BinaryNode<T> t){
		if( t == null)
			return new BinaryNode<T>(x, null, null);
		int compareResult = x.compareTo(t.element);
		if(compareResult < 0)
			t.left = insert(x, t.left);
		else if(compareResult > 0) 
			t.right = insert(x, t.right);
		else
			;
		return t;
	}
	
	public void remove(T x){
//		root = remove(x, root);
	}
	
	
	
	
	public static void main(String[] args){
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		BinaryNode<Integer> b = new BinaryNode<Integer>(1);
		
		Integer[] arr = new Integer[] {10, 6, 14, 4, 8, 12, 16, 3, 5, 7, 9, 11, 13, 15, 17};
		
		for(Integer i : arr){
			bst.insert(i);
		}
		
		
		BinaryNode<Integer> node = bst.findNode(3);
//		node.left = new BinaryNode<Integer>(2);
		System.out.println(bst.findMax());
		bst.printTree();
		
		
	}
	
	public void printTree(){
		if(isEmpty())
			System.out.println("Empty tree");
		else
			printTree(root);
	}
	
	public void printTree(BinaryNode<T> t){
		if(t != null){
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}
	
	
	
}



