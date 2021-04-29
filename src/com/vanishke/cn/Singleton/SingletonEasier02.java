package com.vanishke.cn.Singleton;
//饱汉-变种1模式
public class SingletonEasier02 {

	private static SingletonEasier02 singletonDCL_1 = null;

	public SingletonEasier02()
	{

	}
	public synchronized static  SingletonEasier02 getInstance()
	{
		if(singletonDCL_1 == null)
		{
			singletonDCL_1 = new SingletonEasier02();
			System.out.println("饱汉-变种1模式");
			System.out.println(singletonDCL_1);
		}
		return singletonDCL_1;

	}
	public static void main(String[] args) {
		SingletonEasier02.getInstance();

	}

}
