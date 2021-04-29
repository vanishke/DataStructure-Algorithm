package com.vanishke.cn.Thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
//CyclicBarriers实现
public class ThreadSignalTest3 {


	public static void main(String[] args) {
		int runner = 3;
		final Random random = new Random();
		final CyclicBarrier cyclicBarrier = new CyclicBarrier(runner);

		for(char threadName='A';threadName <= 'C';threadName++)
		{
			final String name = String.valueOf(threadName);
			new Thread(new Runnable()
					{

						@Override
						public void run()
						{
							long prepareTime = random.nextInt(1000) +1000;
							System.out.println(name+" is preparing time:"+prepareTime);
							try
							{
								Thread.sleep(1000);
							}catch(Exception e)
							{
								e.printStackTrace();
							}
							try
							{
								System.out.println(name+ " is prepared ,waitting for others ");
								cyclicBarrier.await();
							} catch (InterruptedException e) {
								e.printStackTrace();
							} catch (BrokenBarrierException e) {
								e.printStackTrace();
							}
							System.out.println(name + " starts running ");
						}

					}).start();

		}
	}

}
