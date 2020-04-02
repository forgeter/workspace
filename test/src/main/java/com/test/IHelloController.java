package com.test;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.RequestParam;

public interface IHelloController {

    public String createOrder(@RequestParam int num) throws Exception;

    @Retryable(value = NullPointerException.class,maxAttempts = 3,backoff = @Backoff(delay = 2000,multiplier = 1.5))
    public int minGoodsnum(int num) throws Exception;
}
