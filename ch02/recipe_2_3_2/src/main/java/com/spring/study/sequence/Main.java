package com.spring.study.sequence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext("com.spring.study.sequence");

    SequenceService sequenceService = context.getBean(SequenceService.class);

    System.out.println(sequenceService.generate("IT"));
    System.out.println(sequenceService.generate("IT"));
  }
}
