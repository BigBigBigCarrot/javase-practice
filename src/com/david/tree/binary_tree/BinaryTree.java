package com.david.tree.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> {
	private Node<T> root;
	private int size;
	
	
	public BinaryTree(){}
	public BinaryTree(Node<T> root){
		this.root=root;
	}
	
	public void add(Node<T> node) {
		if(root==null){
			this.root = node;
		}else{
			root.add(node);
		}
	}
	
	public Node<T> popMin(){
		Node<T> minNode=null;
		minNode=root.popMin();
		if(minNode==root){//�����Ľڵ�Ϊ���ڵ�
			if(root.getRight()==null){//���ڵ�û�����ӽڵ�
				root=null;
			}else{//���ڵ������ӽڵ�
				root=root.getRight();
			}
		}
		return minNode;
	}
	
	public Node<T> popMax(){
		Node<T> maxNode=null;
		maxNode=root.popMax();
		if(maxNode==root){//�����Ľڵ�Ϊ���ڵ�
			if(root.getLeft()==null){//���ڵ�û�����ӽڵ�
				root=null;
			}else{//���ڵ������ӽڵ�
				root=root.getLeft();
			}
		}
		return maxNode;
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
	
	/**
	 * ���򷵻ؽڵ�
	 * @return List<Node<T>>
	 */
	public List<Node<T>> getPreOrderList(){
		List<Node<T>> list;
		list=new ArrayList<Node<T>>();
		addToPreOrderList(root,list);
		return list;
	}
	private void addToPreOrderList(Node<T> node,List<Node<T>> list){
		if(node != null){
			list.add(node);
			addToPreOrderList(node.getLeft(),list);
			addToPreOrderList(node.getRight(),list);
		}
	}
	
	/**
	 * ���򷵻ؽڵ�
	 * @return List<Node<T>>
	 */
	public List<Node<T>> getPostOrderList(){
		List<Node<T>> list;
		list=new ArrayList<Node<T>>();
		addToPostOrderList(root,list);
		return list;
	}
	private void addToPostOrderList(Node<T> node,List<Node<T>> list){
		if(node != null){
			addToPostOrderList(node.getLeft(),list);
			addToPostOrderList(node.getRight(),list);
			list.add(node);
		}
	}
	
	/**
	 * ���򷵻ؽڵ�
	 * @return List<Node<T>>
	 */
	public List<Node<T>> getInOrderList(){
		List<Node<T>> list;
		list=new ArrayList<Node<T>>();
		addToInOrderList(root,list);
		
		return list;
	}
	private void addToInOrderList(Node<T> node,List<Node<T>> list){
		if(node != null){
			addToInOrderList(node.getLeft(),list);
			list.add(node);
			addToInOrderList(node.getRight(),list);
		}
	}
	
	/**
	 * ���ؽڵ���
	 * @param args
	 */
	public int size(){
		size=0;
		size(root);
		return size;
	}
	private void size(Node<T> node){
		if(node!=null){
			size++;
			size(node.getLeft());
			size(node.getRight());
		}
	}
	
	public static void main(String[] args){
		BinaryTree<Integer> tree=new BinaryTree<Integer>();
		String str="4,2,6,1,8,3,5,9";
		String[] strsArray=str.split(",");
		Node node;
		for(String item:strsArray ){
			node=new Node<Integer>(new Integer(item));
			tree.add(node);
		}
		
		//tree.preOrderTraverse();
		//tree.inOrderTraverse();
		//tree.postOrderTraverse();
		/*���� popMin()
		node=tree.popMin();
		node=tree.popMin();
		node=tree.popMin();
		node=tree.popMin();
		node=tree.popMin();
		node=tree.popMin();
		//System.out.println(node.getValue());
		tree.preOrderTraverse();
		*/
		
		/*���� popMax()
		node=tree.popMax();
		node=tree.popMax();
		node=tree.popMax();
		node=tree.popMax();
		node=tree.popMax();
		//System.out.println(node.getValue());
		tree.preOrderTraverse();
		*/
		
		/* ���Ա����õ�List
		List<Node<Integer>> list;
		
		node=tree.popMin();
		//node=tree.popMin();
		//node=tree.popMin();
		//node=tree.popMin();
		
		//list=tree.getPreOrderList();
		//list=tree.getInOrderList();
		list=tree.getPostOrderList();
		
		for(Node<Integer> item:list){
			System.out.println(item.getValue());
		}
		*/
		//tree.preOrderTraverse();
		
		/* ����size()
		tree.popMax();
		tree.popMax();
		System.out.println(tree.size());
		*/
		
		//ջ�������
		int i=0;
		BinaryTree<Double> tree2=new BinaryTree<Double>();
		try{
			while(true){
				i++;
				tree2.add(new Node(Math.random()));
				System.out.println(i);
			}
		}catch(Exception e){
			System.out.println(i+"���ڵ��ջ���");
		}
		
	}
}
