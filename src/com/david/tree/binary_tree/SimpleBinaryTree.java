package com.david.tree.binary_tree;

import java.util.Queue;

/**
* �������Ķ��壺��Ϊ�գ���ֻ�и��ڵ㣬��������������������5�ֻ�����̬��
* ���������ʣ�
* 1���ڶ������ĵ�i����������2^(i-1)����㣨i>=1��
* 2�����Ϊk�Ķ�����������2^(k) - 1����㣨k>=1��
* 3�������κ�һ�Ŷ�������������ն˽����Ϊn������Ϊ2�Ľ����Ϊm����n = m + 1
* 4������n��������ȫ�����������Ϊk = floor(log2(n)) + 1
* 5���ں���n�����Ķ�����������n+1��������
*
*/
public class SimpleBinaryTree<T>{
	private Node<T> root;
	
	public SimpleBinaryTree(){}
	public SimpleBinaryTree(Node<T> root){
		this.root=root;
	}
	
	/**getter and setter*/
	public Node<T> getRoot() {
		return root;
	}
	
	public void setRoot(Node<T> root) {
		this.root = root;
	}
	
	/**����ݹ����������*/
	public void preOrderTraverse(){
		preOrderTraverse(root);
	}
	private void preOrderTraverse(Node<T> node) {
		if(node != null){
			System.out.println(node.getValue());
			preOrderTraverse(node.getLeft());
			preOrderTraverse(node.getRight());
		}
	}
	
	/**����ݹ����������*/
	public void inOrderTraverse(){
		inOrderTraverse(root);
	}
	private void inOrderTraverse(Node<T> node) {
		if(node != null){
			inOrderTraverse(node.getLeft());
			System.out.println(node.getValue());
			inOrderTraverse(node.getRight());
		}
	}
	
	/**����ݹ����������*/
	public void postOrderTraverse(){
		postOrderTraverse(root);
	}
	private void postOrderTraverse(Node<T> node) {
		if(node != null){
			postOrderTraverse(node.getLeft());
			postOrderTraverse(node.getRight());
			System.out.println(node.getValue());
		}
	}
	
	public static void main(String[] args){
		BinaryTree<String> bt = new BinaryTree<String>();
		Node<String> root=new Node<String>("a",null,null);
		bt.setRoot(root);
		root.setLeft(new Node<String>("b",null,null));
		root.setRight(new Node<String>("c",null,null));
		root.getLeft().setLeft(new Node<String>("d",null,null));
		root.getLeft().setRight(new Node<String>("e",null,null));
		//bt.preOrderTraverse();
		//bt.inOrderTraverse();
		bt.postOrderTraverse();
	}
}
