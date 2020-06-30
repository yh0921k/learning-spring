package com.spring.study.sequence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

  public static void main(String[] args) {

    // 기존 src/main/resources의 appContext.xml 위치를 src/main/java로 이동
    // resources 폴더를 이용하기 위해서는 gradle 설정파일에 eclipse-wtp로 지정해야 하는것으로 보임
    ApplicationContext context = new GenericXmlApplicationContext("appContext.xml");


    SequenceGenerator generator = (SequenceGenerator) context.getBean("sequenceGenerator");

    System.out.println(generator.getSequence());
    System.out.println(generator.getSequence());
  }
}
