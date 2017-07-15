package com.david.tree.balanced_binary_tree;

import java.math.BigDecimal;

public class Node<T> implements Comparable{
	
	private T value;
	private Node<T> father;
	private Node<T> left;
	private Node<T> right;
	/**
	 * �ڵ�㼶�����ڵ�㼶Ϊ1
	 */
	private int level;
	/**
	 * ��������ȡ����֧������㼶������ڵ�ǰ�ڵ���ԣ�û�����֧ʱֵΪ0��
	 */
	private int leftDeepestLevel;
	/**
	 * ��������ȡ��ҷ�֧������㼶������ڵ�ǰ�ڵ���ԣ�û���ҷ�֧ʱֵΪ0��
	 */
	private int rightDeepestLevel;
	
	public Node(){}
	public Node(T value){
		this.value=value;
	}
	public Node(T value, Node<T> left, Node<T>right){
		this.value=value;
		this.left=left;
		this.right=right;
	}
	
	/**
	 * С���ڸ��ڵ�����󣬴��ڵ��ڸ��ڵ������
	 * @return Node<T> :��������������321ʱ����3�������345ʱ����3
	 * (����ʱ���ܶ������е��������ܻ�ı���ڵ㣬tree����add�������صĽڵ��жϸ��ڵ��Ƿ��б�)û�е���ʱ����null
	 * @param node Ҫ��ӵĽڵ�
	 */
	public Node<T> add(Node<T> node){
		if(node.compareTo(this)==-1){//Ҫ��ӵĽڵ��ֵС�ڵ�ǰ�ڵ��ֵ
			if(this.left!=null){//���ӽڵ㲻Ϊ��
				return this.left.add(node);
			}else{//���ӽڵ�Ϊ��
				this.left=node;
				node.father=this;
				node.setLevel(this.level+1);//�ӽڵ�Ĳ㼶Ϊ��ǰ�ڵ�㼶+1
				
				Node<T> nodeReturned=null;
				
				/*
				//���������Ϊ2(�����������ӽڵ�)����������Ϊ0
				if(this.father!=null){
					if(this.father.right==null){//���������Ϊ2(�����������ӽڵ�)����������Ϊ0
						nodeReturned=this.father;
						if(this.father.getFather()==null){
							this.right=this.father;
							this.father.setLeft(null);
							this.father.setRight(null);
							this.father=null;
						}else{
							
						}
					}
				}
				*/
				
				//���ϸ��½ڵ���������
				this.setChildLevel(left,left.level);
				return nodeReturned;
			}
		}else{//Ҫ��ӵĽڵ��ֵ���ڵ��ڵ�ǰ�ڵ��ֵ
			if(this.right!=null){//���ӽڵ㲻Ϊ��
				return this.right.add(node);
			}else{//���ӽڵ�Ϊ��
				this.right=node;
				node.father=this;
				node.setLevel(this.level+1);//�ӽڵ�Ĳ㼶Ϊ��ǰ�ڵ�㼶+1
				
				Node<T> nodeReturned=null;
				
				//���������Ϊ2(�����������ӽڵ�)�������������Ϊ0
				if(this.father!=null){
					if(this.father.left==null){//���������Ϊ2(�����������ӽڵ�)�������������Ϊ0
						nodeReturned=this.father;
						if(this.father.getFather()==null){
							
						}else{
							
						}
					}
				}
				
				//���ϸ��½ڵ���������
				this.setChildLevel(right,right.level);
				
				return nodeReturned;
			}
		}
	}
	
	/**
	 * 
	 * @param node ֱ���ӽڵ�(�²���ڵ����ڵ��������ڵ�ǰ�ڵ���˵�Ķ��ӽڵ�)
	 * @param latestLevel �²���ڵ�Ĳ㼶
	 */
	public void setChildLevel(Node node,int latestLevel){
		if(node==this.left){//����������
			if(this.leftDeepestLevel<latestLevel-this.level){//������⣬�ɺ����Ż�
				this.leftDeepestLevel=latestLevel-this.level;//������⣬�ɺ����Ż�
			}else{
				return;
			}
		}else{//����������
			if(this.rightDeepestLevel<latestLevel-this.level){//������⣬�ɺ����Ż�
				this.rightDeepestLevel=latestLevel-this.level;//������⣬�ɺ����Ż�
			}else{
				return;
			}
		}
		
		if(this.father!=null){
			father.setChildLevel(this, latestLevel);
		}
	}
	
	public Node<T> popMin(){
		Node<T> minNode=null;
		if(this.left==null){//û�����ӽڵ�
			minNode=this;
			//System.out.println("��ǰ�����Ľڵ��ֵΪ��"+minNode.getValue());
			if(minNode.father!=null){
				if(minNode.right==null){//û�����ӽڵ�
					minNode.father.setLeft(null);
					//System.out.println("��ǰ�����Ľڵ�û�����ӽڵ㣬���õ����ڵ�ĸ��ڵ�����ӽڵ�Ϊnull,���ڵ��ֵΪ:"+minNode.getFather().getValue());
				}else{//�����ӽڵ�
					this.father.setLeft(this.right);
					this.right.setFather(this.father);
					this.right.setLevel(this.level);//���ӽڵ������ǰ�ڵ㣬�����ӽڵ�Ĳ㼶Ϊ��ǰ�ڵ�Ĳ㼶ֵ
					//System.out.println("��ǰ�����Ľڵ������ӽڵ�");
				}
			}
		}else{//�����ӽڵ�
			minNode=this.left.popMin();
		}
		return minNode;
	}
	
	public Node<T> popMax(){
		Node<T> maxNode=null;
		if(this.right==null){//û�����ӽڵ�
			maxNode=this;
			//System.out.println("��ǰ�����Ľڵ��ֵΪ��"+maxNode.getValue());
			if(maxNode.father!=null){
				if(maxNode.left==null){//û�����ӽڵ�
					maxNode.father.setRight(null);
					//System.out.println("��ǰ�����Ľڵ�û�����ӽڵ㣬���õ����ڵ�ĸ��ڵ�����ӽڵ�Ϊnull,���ڵ��ֵΪ:"+maxNode.getFather().getValue());
				}else{//�����ӽڵ�
					this.father.setRight(this.left);
					this.left.setFather(this.father);
					this.left.setLevel(this.level);//���ӽڵ������ǰ�ڵ㣬�����ӽڵ�Ĳ㼶Ϊ��ǰ�ڵ�Ĳ㼶ֵ
					//System.out.println("��ǰ�����Ľڵ������ӽڵ�");
				}
			}
		}else{//�����ӽڵ�
			maxNode=this.right.popMax();
		}
		return maxNode;
	}
	
	public void resetLevel(){
		if(father!=null){
			this.level=father.getLevel()+1;
		}else{
			this.level=1;
		}
		
		if(this.left!=null){
			left.resetLevel();
		}
		if(this.right!=null){
			right.resetLevel();
		}
	}
	
	
	
	//getters and setters
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	
	public Node<T> getLeft() {
		return left;
	}
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	
	public Node<T> getRight() {
		return right;
	}
	public void setRight(Node<T> right) {
		this.right = right;
	}
	
	public Node<T> getFather() {
		return father;
	}
	public void setFather(Node<T> father) {
		this.father = father;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLeftDeepestLevel() {
		return leftDeepestLevel;
	}
	public void setLeftDeepestLevel(int leftDeepestLevel) {
		this.leftDeepestLevel = leftDeepestLevel;
	}
	public int getRightDeepestLevel() {
		return rightDeepestLevel;
	}
	public void setRightDeepestLevel(int rightDeepestLevel) {
		this.rightDeepestLevel = rightDeepestLevel;
	}
	
	/**
	 * 1.compareTo(2) return -1
	 * 1.compareTo(1) return 0
	 * 1.compareTo(0) return 1
	 */
	public int compareTo(Object obj) {
		Node<T> node=(Node<T>)obj;
		Object comparedValue=node.getValue();
		if(value.getClass().equals(Integer.class)){
			return ((Integer)value).compareTo((Integer)comparedValue);
		}
		if(value.getClass().equals(Long.class)){
			return ((Long)value).compareTo((Long)comparedValue);
		}
		if(value.getClass().equals(Double.class)){
			return ((Double)value).compareTo((Double)comparedValue);
		}
		if(value.getClass().equals(BigDecimal.class)){
			return ((BigDecimal)value).compareTo((BigDecimal)comparedValue);
		}
		return -2;
	}
	
	/*
	public static void main(String[] args) {
		Node<BigDecimal> root=new Node<BigDecimal>();
		root.setValue(new BigDecimal(1.0));
		
		Node<BigDecimal> node1=new Node<BigDecimal>();
		node1.setValue(new BigDecimal(0.99));
		
		Node<BigDecimal> node2=new Node<BigDecimal>();
		node2.setValue(new BigDecimal(1.2));
		
		Node<BigDecimal> node3=new Node<BigDecimal>();
		node3.setValue(new BigDecimal(1.3));
		
		root.add(node1);
		root.add(node2);
		root.add(node3);
		
		System.out.println(root.getLeft());
		System.out.println(root.getRight());
		System.out.println(root.getRight().getRight());
		
	}
	*/
	
	
}
