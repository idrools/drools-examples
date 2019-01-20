package com.idrools.droolsexamples.helloworld;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 说明
 */

public class HelloWorldExample {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldExample.class);
    @Autowired
    private KieSession kieSession;

    @Autowired
    private KieContainer kieContainer;

    private KieServices kieServices=KieServices.Factory.get();

    public void helloWorldKieSession() {

        Message message = new Message();
        message.setMessage("hello world");
        message.setStatus(Message.HELLO);
        kieSession.insert(message);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
    public void helloWorldbyKieContainer() {

        kieSession = kieContainer.newKieSession("HelloWorld");
        Message message=new Message();
        message.setMessage("hello kieContainer ");
        message.setStatus(Message.HELLO);
        kieSession.insert(message);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
    public void helloWorldbyKieServices() {
        kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
        kieSession = kieContainer.newKieSession("HelloWorld");
        Message message=new Message();
        message.setMessage("hello kieContainer ");
        message.setStatus(Message.HELLO);
        kieSession.insert(message);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

}


