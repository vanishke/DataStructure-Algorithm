package com.vanishke.cn.Singleton;
//饱汉-变种3-volatile-doubleCheck
public class SingletonEasier04 {

	private static volatile SingletonEasier04 singleton  = null;

	public  SingletonEasier04()
	{

	}

	public static  SingletonEasier04 getInstance()
	{
		if(singleton == null)
		{
			synchronized (singleton) {
				if(singleton == null)
				{
					singleton = new SingletonEasier04();
					System.out.println(" 饱汉-变种3-volatile-doubleCheck ");
					System.out.println(singleton);
				}
			}
		}
		return singleton;

	}
	public static void main(String[] args) {
		SingletonEasier04 singleton = SingletonEasier04.getInstance();
	}

}
