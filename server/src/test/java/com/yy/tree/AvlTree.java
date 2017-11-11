package com.yy.tree;

import java.nio.BufferUnderflowException;

/**
 * AVL 树
 * @author PYF
 *
 * @param <T>
 */
public class AvlTree<T extends Comparable<? super T>> {
	

	/*----------------------- internal class --------------------------------*/
	/**
	 * AVL树节点类
	 * @author PYF
	 *
	 * @param <T>
	 */
	public static class AvlNode<T> {

		T element;

		AvlNode<T> left;
		AvlNode<T> right;
		int height;	// 高度

		AvlNode(T element) {
			this(element, null, null);
		}

		AvlNode(T element, AvlNode<T> left,
				AvlNode<T> right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}
		
		

	}

	/*----------------------- member variable ------------------------------*/
	/** 树根 */
	private AvlNode<T> root;
	

	/*----------------------- construction method ---------------------------*/
	public AvlTree() {
		root = null;
	}

	
	/*----------------------- member method ---------------------------------*/
	/** 设置根为空 */
	public void makeEmpty() {
		root = null;
	}

	/** 是否为空 */
	public boolean isEmpty() {
		return root == null;
	}
	
	/** 获取高度 */
	private int height(AvlNode<T> t){
		return t == null ? -1 : t.height;
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
	private boolean contains(T x, AvlNode<T> t) {
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
	
	private AvlNode<T> findMin(AvlNode<T> t){
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
	private AvlNode<T> findMax(AvlNode<T> t){
		if(t != null){
			while(t.right != null)
				t = t.right;
		}
		return t;
	}
	
	public AvlNode<T> findNode(T x){
		return findNode(x, root);
	}
	
	/**
	 * 查找节点对象
	 * @param x
	 * @param t
	 * @return
	 */
	private AvlNode<T> findNode(T x, AvlNode<T> t){
		
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
	
	public int compare(T x, T y){
		return x.compareTo(y);
	}
	
	public void insert(T x){
		root = insert(x, root);
	}
	
	private AvlNode<T> insert(T x, AvlNode<T> t){
		if( t == null)
			return new AvlNode<T>(x, null, null);
		
		int compareResult = compare(x, t.element);
		
		if(compareResult < 0){
			t.left = insert(x, t.left);
			if(height(t.left) - height(t.right) == 2)
				if(compare(x, t.left.element) < 0)
					t = rotateWithLeftChild(t);
				else 
					t = doubleWithLeftChild(t);
		} else if(compareResult > 0){
			t.right = insert(x, t.right);
			if(height(t.right) - height(t.left) == 2)
				if( compare(x, t.right.element) > 0 )
					t =  rotateWithRightChild(t);
				else
					t = doubleWithRightChild(t);
						
		} else
			;
		
		t.height = Math.max(height(t.left), height(t.right)) + 1;
		return t;
	}
	
	/** 单旋转 (左-左情况)*/
	private AvlNode<T> rotateWithLeftChild(AvlNode<T> t) {
		AvlNode<T> leftNode = t.left;
		t.left = leftNode.right;
		leftNode.right = t;
		t.height = Math.max(height(t.left), height(t.right)) + 1;
		leftNode.height = Math.max(height(leftNode.left), t.height) + 1;
		return leftNode;
	}
	
	/** 单旋转 (右-右情况)*/
	private AvlNode<T> rotateWithRightChild(AvlNode<T> t){
		AvlNode<T> rightNode = t.right;
		t.right = rightNode.left;
		rightNode.left = t;
		t.height = Math.max(height(t.right), height(t.left)) + 1;
		rightNode.height = Math.max(height(rightNode.right), t.height) + 1;
		return rightNode;
	}

	/** 双旋转 (左-右情况)*/
	private AvlNode<T> doubleWithLeftChild(AvlNode<T> t) {
		t.left = rotateWithRightChild(t.left);
		return rotateWithLeftChild(t);
	}
	
	/** 双旋转 (右-左情况) */
	private AvlNode<T> doubleWithRightChild(AvlNode<T> t) {
		t.right = rotateWithLeftChild(t.right);
		return rotateWithRightChild(t);
	}

	public void remove(T x){
		root = remove(x, root);
	}
	
	private AvlNode<T> remove( T x, AvlNode<T> t){
		if(t == null)
			return t;
		int compareResult = compare(x, t.element);
		
		if(compareResult < 0) {
			t.left = remove(x, t.left);
			if(height(t.right) - height(t.left)  == 2)
				if(t.right!=null){
					//一字型失衡，单旋转
					if (height(t.right.right)>=height(t.right.left)) {
						t = rotateWithRightChild(t);
					} else {//之字形失衡，双旋转
						t = doubleWithRightChild(t);
					}
				}
			
		} else if(compareResult > 0){
			t.right = remove(x, t.right);
			if(height(t.left) - height(t.right) == 2)
				if(t.left!=null){
					//一字型失衡，单旋转
	                if (height(t.left.left)>=height(t.left.right)) {
	                    t = rotateWithLeftChild(t);
	                } else { //之字形失衡，双旋转
	                    t = doubleWithLeftChild(t);
	                }
	            }
			
		} else if(t.left != null && t.right != null) { // 删除节点是当前节点, 且有两个儿子时
			//特殊情况，当右子树的最小节点就是右儿子并且右儿子的右子树为空
            boolean iooo=(t.right==findMin(t.right) && t.right.right == null);//判定结果
            t.element=findMin(t.right).element;//用右子树的最小节点替换该节点
            t.right=remove(t.element, t.right);//删除右子树的最小节点
            if(iooo){//特殊情况成立，则节点已经失衡，左单旋转
                t=rotateWithLeftChild(t);
            }
			
			
		} else  // // 删除节点是当前节点, 且只有一个儿子时
			t = (t.left != null) ? t.left : t.right;
			
		if (t != null) {//更新高度
		 	t.height = Math.max(height(t.left), height(t.right)) + 1;
		}
		
		return t;
	}
	
	
	
	public static void main(String[] args){
		
		AvlTree<Integer> avlTree = new AvlTree<Integer>();
		
		
//		Integer[] arr = new Integer[] {10, 6, 14, 4, 8, 12, 16, 3, 5, 7, 9, 11, 13, 15, 17};
		Integer[] arr = new Integer[] {1,2,3,4,5,6,7,8,9};
		
		for(Integer el : arr){
			avlTree.insert(el);
		}
		
		avlTree.remove(5);
	
		avlTree.printTree();
		
		
	}
	
	public void printTree(){
		if(isEmpty())
			System.out.println("Empty tree");
		else
			printTree(root);
	}
	
	public void printTree(AvlNode<T> t){
		if(t != null){
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}
	
	
}



