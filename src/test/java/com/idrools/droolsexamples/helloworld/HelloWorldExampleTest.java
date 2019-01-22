package com.idrools.droolsexamples.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 说明
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(HelloWorldExample.class)
public class HelloWorldExampleTest {
    @Autowired
    HelloWorldExample helloWorldExample;

    @Test
    public void helloWorldKieSession() {
        helloWorldExample.helloWorldKieSession();


    }
    @Test
    public void helloWorldbyKieContainer() {
        helloWorldExample.helloWorldbyKieContainer();

    }
    @Test
    public void helloWorldbyKieServices() {
        helloWorldExample.helloWorldbyKieServices();

    }
}