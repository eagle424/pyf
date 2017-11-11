package com.yy;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"classpath:config/applicationContext.xml"
		})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public abstract class AbstractTest {
	@Resource
	protected BeanFactory beanFactory;

	
}
