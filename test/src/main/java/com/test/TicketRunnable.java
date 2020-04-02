/**
 * @Title: TicketRunnable.java Create on 2020年1月9日 下午3:38:14
 * @author: jiangyuanquan
 * @Description: TODO(用一句话描述该文件做什么)
 * @Package com.test
 * Copyright <a href="mailto:www.ekezhan.com">www.ekezhan.com</a> Corporation 2020
*/
	
package com.test;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

/**@Description: TODO
 * @author: jiangyuanquan 
 * @version: 2020年1月9日 下午3:38:14
*/
public class TicketRunnable implements Runnable {

	private Boolean working = true;
	
	private int num = 20;
	
	private RedissonClient redissonClient;
	
	public TicketRunnable(RedissonClient redissonClient) {
		this.redissonClient = redissonClient;
	}
	
	private void grabTicket() {
		String name = Thread.currentThread().getName();
		System.out.println(name+"准备抢票");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!working) {
			return;
		}
		if (num > 0) {
			num--;
			System.out.println(name+"抢到一张票！");
		}
		if (num != 0) {
			System.out.println("================" + Thread.currentThread().getName() + "=================  售出票号"
					+ (num + 1) + ",还剩" + num + "张票--");
		} else {
			System.out.println("================" + Thread.currentThread().getName() + "=================  售出票号"
					+ (num + 1) + "，票已经票完!--");
			working = false;
		}
	}


	@Override
	public void run() {
		
		

		while (working) {
			
			  RLock lock = redissonClient.getLock("ticket"); lock.lock(); String name =
			  Thread.currentThread().getName(); System.out.println(name+"获得锁");
			 
			   grabTicket();
			
			  lock.unlock(); System.out.println(name+"释放锁");
			 
		}

		
	}

}
