package com.vanishke.cn.Thread;

import java.util.concurrent.CountDownLatch;
//countDownLatch实现
public class ThreadSignalTest2 {


	public static void main(String[] args) {
		int worker = 3;
		final CountDownLatch countDownLatch = new CountDownLatch(worker);
		new Thread(new Runnable() {
			@Override
			public void run() {

					System.out.println("D is waitting other three process");
					try
					{
						countDownLatch.await();
						System.out.println("All done ,D starts working");
					}catch(InterruptedException e)
					{
						e.printStackTrace();
					}



			}
		}).start();
		for(char threadName='A';threadName <= 'C';threadName++)
		{
			final String name = String.valueOf(threadName);
			new Thread(new Runnable()
					{

						@Override
						public void run()
						{

							System.out.println(name+" is working ");
							try
							{
								Thread.sleep(1000);
							}catch(InterruptedException e)
							{
								e.printStackTrace();
							}
							System.out.println(name+ " finished ");
							countDownLatch.countDown();
						}

					}).start();

		}
	}

}
