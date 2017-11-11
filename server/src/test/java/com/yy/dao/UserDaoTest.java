package com.yy.dao;

import org.dom4j.CDATA;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;

import com.yy.AbstractTest;

public class UserDaoTest extends AbstractTest {

	@Test
	public void Test001() {
		System.out.println("ok");
	}
	
	public static void main(String[] args){
		Document doc = DocumentHelper.createDocument();
		Element element = DocumentHelper.createElement("el01");
		CDATA cdata = DocumentHelper.createCDATA("bbb");
		element.add(cdata);
		System.out.println(element.asXML());
	}

}
