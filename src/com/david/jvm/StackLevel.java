package com.david.jvm;

import com.david.tree.binary_tree.BinaryTree;
import com.david.tree.binary_tree.Node;

public class StackLevel {
	public static int counter=0;//stackLevel()ִ�д���
//	private int level = 1;
//	int a;
//	String str="";
//	BinaryTree tree=new BinaryTree(new Node(1));
	
	public void stackLevel() {
		counter=counter+1;
		
		//������ִ�л���ջ��ÿ����һ�η�������ջ�д���һ��frame(ջ֡)��frame�Ĵ�Сȡ���ڷ����еľֲ������Ͳ�����ջ�Լ���ǰ��ĳ����ص����ã�
		//Ϊջ����Ķ��ڴ�һ��ʱ��frameԽ��ջԽ�������
		//int a=1,b=2,c=3;
		//int a=1+2+3+4+5+6+7;
		String s1="",s2="",s3="";
		
//		System.out.println("stackLevel() executed");
//		System.out.println("counter:"+counter);
		//tree.add(new Node(1));//

		
//		for(int i=0;i<=0;i++){	
//		}
		
//		if(level==10000){
//			return;
//		}
		stackLevel();
	}
	
	public void f(){
		
	}

	public static void main(String[] args) throws Throwable {
		StackLevel sl = new StackLevel();
		try {
			sl.stackLevel();
		} catch (StackOverflowError e) {
			System.out.println(e.toString());
		}
		
		finally{
			System.out.println("counter:"+StackLevel.counter);
		}
	}
}
