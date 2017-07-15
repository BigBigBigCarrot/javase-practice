package com.david.utils;

public class MyRandom//��Ҫ��������������������������
{
	public static int getARandomNumber(int smallestNum,int largestNum)//����һ��>=smallestNum��<=largestNum�������
	{
		int number;
		
		number=(int)(Math.random()*(largestNum-smallestNum+1))+smallestNum;
		
		return number;
	}
	
	public static int[] get_Non_repeated_1D_Array(int smallestNum,int largestNum,int arrayLength)//����һ�����ظ���int��һά���飬ǰ��������ָ����ֵ�ı����䣬���һָ�����鳤��
	{
		int[] randomArray;//����Ҫ���ص�����
		int[] naturalArray;//�����ñ������������Ȼ��������
		int colsedIntervalLength;//�����䳤��
		
		colsedIntervalLength=largestNum-smallestNum+1;
		randomArray=new int[arrayLength];
		naturalArray=new int[colsedIntervalLength];//�ñ������������Ȼ��
		
		if(colsedIntervalLength<arrayLength)//�������е���Ȼ�������Բ���length�����ظ�������ʱ����������Ԫ�ؾ�Ϊ�������
		{
			return randomArray;//��������Ԫ�ؾ�Ϊ�������
		}
		else
		{
			int ergodic=smallestNum;//���ڱ����������е�������Ȼ���ı���
			for(int i=0;i<=colsedIntervalLength-1;i++)
			{
				naturalArray[i]=ergodic;//���ñ������е�������Ȼ����С�������μ�¼��������
				ergodic++;
				//System.out.println(naturalArry[i]);
			}
		}
		
		int rRange=colsedIntervalLength;
		int arrayIndex;
		for(int i=0;i<=arrayLength-1;i++)
		{
			arrayIndex=(int)(Math.random()*rRange);
			rRange--;
			randomArray[i]=naturalArray[arrayIndex];
			naturalArray[arrayIndex]=naturalArray[rRange];//���Ѿ�ѡ�е����ŵ�arrayIndex����ĺ��棬֮����������ѡ�����
		}
		return randomArray;
	}
	
	public static int[][] get_Non_repeated_2D_Array(int smallestNum,int largestNum,int n,int m)//����һ�����ظ���int�Ͷ�άn*m����
	{
		int[][] matrix;
		int[] array;
		int tempArraryIndex;//���ڱ���һά�����е�ÿһ���±�
		matrix=new int[n][m];
		tempArraryIndex=0;
		
		array=get_Non_repeated_1D_Array(smallestNum,largestNum,n*m);//��ȡһ����ָ��������ָ�����ȵ�һά����
		for(int i=0;i<=matrix.length-1;i++)
		{
			for(int j=0;j<=matrix[0].length-1;j++)
			{
				matrix[i][j]=array[tempArraryIndex];
				tempArraryIndex++;
			}
		}
		return matrix;
		//�������е���Ȼ�������Բ���n*m�����ظ�������ʱ����������Ԫ�ؾ�Ϊ��ľ���
	}
	
	public static int random(int smallestNum,int largestNum)//����ָ�������ڵ�����һ����Ȼ��
	{
		int random;
		random=(int)(Math.random()*(largestNum+1-smallestNum));
		random=random+smallestNum;
		
		return random;
	}
	
	public static int[] get_1D_Array(int smallestNum,int largestNum,int arrayLength)//����һ�����ظ���int��һά���飬ǰ��������ָ����ֵ�ı����䣬���һָ�����鳤��
	{
		int[] array;
		array=new int[arrayLength];
		
		for(int i=0;i<=array.length-1;i++)
		{
			array[i]=MyRandom.getARandomNumber(smallestNum, largestNum);
		}
		
		return array;
	}
	public static void main(String[] agrs)
	{
		/* ����non_repeated_1D_Array����
		int[] a;
		a=MyRandom.non_repeated_1D_Array(-9,9,10);
		for(int i=0;i<=a.length-1;i++)
		{
			System.out.println(a[i]);
		}
		*/
		//System.out.println("OK");
		
		/*�����������
		int[][] matrix;
		matrix=MyRandom.non_repeated_2D_Array(1,16,4,4);
		
		for(int i=0;i<=matrix.length-1;i++)
		{
			for(int j=0;j<=matrix[0].length-1;j++)
			{
				System.out.print("\t"+matrix[i][j]+"\t");
			}
			System.out.print("\n");
		}
		*/
		
		//�����ڸ����������в���һ�������
		/*
		for(int i=0;i<=100;i++)
		{
			System.out.println(MyRandom.random(3,10));
		}
		*/
		//System.out.println(MyRandom.random(3,10));
		
		/*
		for(int i=0;i<=50;i++)
		{
			System.out.println(MyRandom.getARandomNumber(3, 17));
		}
		*/
		
		int[] array=MyRandom.get_1D_Array(0, 2, 20);
		for(int i=0;i<=array.length-1;i++)
		{
			System.out.println(array[i]);
		}
	}
}