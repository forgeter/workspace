package com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;
import org.redisson.RedissonMultiLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import com.alibaba.druid.sql.dialect.oracle.ast.expr.OracleSizeExpr.Unit;
@Component
@SpringBootTest
class TestApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("hello ");
	}
	
	   @Autowired
	    private AuthorDao authorDao;
	   @Autowired
	   private AuthorMapper authorMapper;

	    @Test
	    public void testInsert() {
	        Author author = new Author();
	        author.setId(1L);
	        author.setRealName("莫言");
	        author.setNickName("疯子");
	        
	        authorDao.add(author);
	        System.out.println("插入成功！");
	    }
	    @Test
	    public void queryById() {
	    	Author author = authorMapper.queryById(1L);
	    	System.out.println(author);
	    }
	    
	    @Autowired
	    private AuthorMapper mapper;

	    @Test
	    public void testInserttt() {
	        Author author = new Author();
	        author.setId(4L);
	        author.setRealName("唐钰");
	        author.setNickName("小宝");
	        mapper.insertAuthor(author);
	        System.out.println("成功!");
	    }
	    
	    @Autowired
	    private RedissonClient redissonClient;  
	      
		@Test
	    public void test(){
		    RLock lock= redissonClient.getLock("test");  
		    //RLock flock= redissonClient.getFairLock("asd");
		    //redissonClient.get
	         try {  
	        	 lock.lock();
	        	 //flock.lock(leaseTime, unit);
	        	// flock.lock();
	        	// flock.tryLock();
	              //  lock.lock();  
	              //  lock.lock();
	                System.out.println(12);
	         } catch (Exception ex) {  
	                System.out.println("同步数据到中心失败 :"+ex+"");  
	            } finally {  
	            	lock.unlock();  
	            }  
	  
	    } 
		
		@Test
	    public void test2(){
		    RLock lock= redissonClient.getLock("test");  
		    //RLock flock= redissonClient.getFairLock("asd");
		    //redissonClient.get
	         try {  
	        	 lock.lock();
	              //  lock.lock();  
	              //  lock.lock();
	                System.out.println(13);
	         } catch (Exception ex) {  
	                System.out.println("同步数据到中心失败 :"+ex+"");  
	            } finally {  
	            	lock.unlock();  
	            }  
	  
	    }




	@Test
	public void  grabMain() {
		int threadNum = 5;    //模拟多个窗口 进行售票
    
       TicketRunnable tickets = new TicketRunnable(redissonClient);
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) {   //此处 设置数值  受限于 线程池中的数量
            executorService.submit(tickets);
        }
        try {
            executorService.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("结束");
    }
			     
}
