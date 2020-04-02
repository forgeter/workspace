package com.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@Component
@SpringBootTest
public class SpringRetryTest {
    @Test
    public void helloSpringRetry(){
        System.out.println("hello spring retry");
        System.out.println("hello spring retry");
    }
}
