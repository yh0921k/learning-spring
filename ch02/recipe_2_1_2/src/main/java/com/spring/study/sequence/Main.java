package com.spring.study.sequence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext("com.spring.study.sequence");

    SequenceDao sequenceDao = context.getBean(SequenceDao.class);

    System.out.println(sequenceDao.getNextVlaue("IT"));
    System.out.println(sequenceDao.getNextVlaue("IT"));
  }
}
