package com.vanishke.cn.Singleton;

public class SingletonEasier03 {

	private static SingletonEasier03 singleton = null;

	public  SingletonEasier03()
	{

	}
	public static SingletonEasier03 getInstance()
	{
		if(singleton == null)
		{
			synchronized (singleton) {
				if(singleton == null)
				{
					singleton = new SingletonEasier03();
					System.out.println(" 饱汉-变种2模式  ");
					System.out.println(singleton);
				}
			}
		}
		return singleton;
	}
	public static void main(String[] args) {
		SingletonEasier03.getInstance();

	}

}
