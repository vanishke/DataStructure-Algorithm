package com.vanishke.cn.Singleton;

public class SingletonEager01 {
	private final static SingletonEager01 singletonEager = new SingletonEager01();
	public SingletonEager01()
	{

	}
	public static SingletonEager01 getInstance()
	{
		System.out.println("饿汉模式");
		System.out.println(singletonEager);
		return singletonEager;
	}

	public  static void main(String args[])
	{
		SingletonEager01.getInstance();
	}
}
