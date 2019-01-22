package com.idrools.droolsexamples.db;

import com.idrools.droolsexamples.helloworld.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;

/**
 * 说明
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(DbExample.class)
public class DbExampleTest {
    @Autowired
    DbExample dbExample;
    @Test
    public void getKieSessiionByString() throws UnsupportedEncodingException {
        String rules = "package rules;\n" +
                "import com.idrools.droolsexamples.helloworld.Message;\n" +
                "dialect  \"mvel\"\n" +
                "\n" +
                "rule \"Hello World\"\n" +
                "    when\n" +
                "        m : Message( status == Message.HELLO, message : message )\n" +
                "    then\n" +
                "        System.out.println( message );\n" +
                "//        modify ( m ) { setMessage( \"Goodbyte cruel world\" ),\n" +
                "//                       setStatus( Message.GOODBYE ) };\n" +
                "    modify ( m ) { message = \"Goodbye cruel world\",\n" +
                "                   status = Message.GOODBYE };\n" +
                "end\n" +
                "\n" +
                "rule \"Good Bye\"\n" +
                "    dialect \"java\"\n" +
                "    when\n" +
                "        Message( status == Message.GOODBYE, message : message )\n" +
                "    then\n" +
                "        System.out.println( message );\n" +
                "end\n";
        KieSession kieSession = dbExample.getKieSessiionByString(rules);
        Message message = new Message();
        message.setMessage("hello world");
        message.setStatus(Message.HELLO);
        kieSession.insert(message);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

}