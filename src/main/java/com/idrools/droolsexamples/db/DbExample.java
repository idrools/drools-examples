package com.idrools.droolsexamples.db;

import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderErrors;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * 说明
 */
@Component
public class DbExample {
    private static Logger logger = LoggerFactory.getLogger(DbExample.class);
    public KieSession  getKieSessiionByString(String rule)  throws UnsupportedEncodingException {


        KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        knowledgeBuilder.add(ResourceFactory.newByteArrayResource(rule.getBytes("utf-8")), ResourceType.DRL);
        KnowledgeBuilderErrors errors = knowledgeBuilder.getErrors();
        if (knowledgeBuilder.hasErrors()) {
            logger.warn(knowledgeBuilder.getErrors().toString());
        }
        InternalKnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        knowledgeBase.addPackages(knowledgeBuilder.getKnowledgePackages());
        return knowledgeBase.newKieSession();

    }
}
