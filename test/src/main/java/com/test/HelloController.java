package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
public class HelloController implements IHelloController {

    private final int totalNum = 100000;
    @Autowired
    private IHelloController iHelloController;

    @GetMapping("/createOrder")
    @Override
    public String createOrder(@RequestParam int num) throws Exception{
        int remainingnum = iHelloController.minGoodsnum(num == 0 ? 1: num);
        System.out.println("剩余的数量==="+remainingnum);
        return "库库存成功";
    }


    @Override
    public int minGoodsnum(int num) throws Exception{
        System.out.println("minGoodsnum开始"+ LocalTime.now());
        System.out.println(num);
        if(num <= 3){
            num ++;
            throw new NullPointerException("数量不对");
        }
        System.out.println("minGoodsnum执行结束");
        return totalNum - num;
    }

    @Recover
    public int recover(NullPointerException e){
        System.out.println("减库存失败！！！");
        //记日志到数据库
        return totalNum;
    }
}
