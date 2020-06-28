package com.spring.study.sequence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring.study.sequence.config.SequenceConfiguration;

public class Main {

  public static void main(String[] args) {

    ApplicationContext context =
        new AnnotationConfigApplicationContext(SequenceConfiguration.class);

    SequenceGenerator generator = context.getBean(SequenceGenerator.class);

    System.out.println(generator.getSequence());
    System.out.println(generator.getSequence());
  }
}
