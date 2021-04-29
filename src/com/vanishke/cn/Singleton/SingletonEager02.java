package com.vanishke.cn.Singleton;
//饿汉-Holder模式
public class SingletonEager02 {

	private static class SingletonHolder{
		private  static final SingletonEager02 singleton = new SingletonEager02();
		public SingletonHolder()
		{

		}
	}
	private  SingletonEager02()
	{

	}

	public static SingletonEager02 getInstance()
	{
		System.out.println("饿汉-Holder模式");
		System.out.println(SingletonHolder.singleton);
		return SingletonHolder.singleton;
	}
	public static void main(String[] args) {

		SingletonEager02.getInstance();
	}

}
