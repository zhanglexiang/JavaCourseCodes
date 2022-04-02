package com.xiang.bean;
import org.springframework.context.ApplicationContext;
import 
	org.springframework.context.support.ClassPathXmlApplicationContext;
public class XmlBeanAssembleTest {

	public static void main(String[] args) {

		// 加载配置文件
		ApplicationContext applicationContext = 
						new ClassPathXmlApplicationContext("application-xml.xml");
		// 输出结果
		System.out.println(applicationContext.getBean("user"));
	}


}

