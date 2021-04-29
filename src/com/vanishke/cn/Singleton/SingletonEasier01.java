package com.vanishke.cn.Singleton;
//饱汉模式
public class SingletonEasier01 {

	private static  SingletonEasier01 singleton = null;

	public synchronized static SingletonEasier01 getInstance ()
	{
		if(singleton == null)
		{
			singleton = new SingletonEasier01();
			System.out.println("饱汉模式初始化");
			System.out.println(singleton);
		}
		return singleton;
	}
	public static void main(String[] args) {
		SingletonEasier01.getInstance();



	}

}
