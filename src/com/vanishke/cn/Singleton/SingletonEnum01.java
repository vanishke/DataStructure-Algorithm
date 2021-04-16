package com.vanishke.cn.Singleton;

public class SingletonEnum01 {

	private enum SingletonEnum{
		INSTANCE;
		private SingletonEnum01 singleton;

		SingletonEnum(){
			singleton = new SingletonEnum01();
		}
		public SingletonEnum01 getInstance()
		{
			return singleton;
		}

	}
	public SingletonEnum01()
	{

	}
	public static SingletonEnum01 getInstance()
	{
		System.out.println("单例枚举类实现");
		System.out.println(SingletonEnum.INSTANCE.getInstance());
		return SingletonEnum.INSTANCE.getInstance();

	}
	public static void main(String[] args) {
		SingletonEnum01.getInstance();

	}

}
