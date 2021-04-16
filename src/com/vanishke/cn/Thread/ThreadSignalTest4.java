package com.vanishke.cn.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadSignalTest4 {


	public static void main(String[] args) {
		Callable<Integer> callable = new Callable<Integer>()
				{

					@Override
					public Integer call() throws Exception {
						System.out.println(" Task starts ");
						int result = 0;
						for(int i=1;i<=10000;i++)
						{
							result = result + i;
						}
						System.out.println(" Task finished and return results ");
						return result;
					}
				};
				FutureTask<Integer> fatureTask = new FutureTask<>(callable);
				new Thread(fatureTask).start();
				try
				{
					System.out.println(" Before fatureTask.get() ");
					System.out.println(" Result:" + fatureTask.get());
					System.out.println("After fatureTask.get()");
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				catch(ExecutionException e)
				{
					e.printStackTrace();
				}
	}

}
