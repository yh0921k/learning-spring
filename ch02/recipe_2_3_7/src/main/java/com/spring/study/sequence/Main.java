package com.spring.study.sequence;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring.study.sequence.config.SequenceConfiguration;

public class Main {

  public static void main(String[] args) {
    // 프로젝트의 규모가 커질수록 모든 빈 설정을 하나의 자바 구성 클래스에 담기 힘들다.
    // 보통 빈 기능에 따라 여러 자바 구성 클래스로 나누어 관리한다.
    // 자바 구성 클래스가 여러개일 때 상이한 클래스에 정의된 빈을 자동 연결하거나 참조하는 일은 어렵다.
    // 한 가지 방법은 자바 구성 클래스가 위치하는 경로마다 어플리케이션 컨텍스트를 초기화하는 것이다.
    // 아래와 같이 각 자바 구성 클래스에 선언된 빈을 컨텍스트와 레퍼런스로 읽으면 POJO 간 자동 연결이 가능하다.
    // AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
    // PrefixConfiguration.class, SequenceConfiguration.class);


    // 두 번째 방법은 @Import로 구성 파일을 나누어 설정하는 방법이 있다.
    // 아래와 같이 SequenceFonfiguration 구성 클래스를 등록한다.
    // 하지만 해당 구성 클래스를 살펴보면 @Import를 통해 PrefixConfiguration 클래스가 설정되어 있다.
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(SequenceConfiguration.class);
    context.refresh();

    SequenceGenerator generator = (SequenceGenerator) context.getBean("sequenceGenerator");

    System.out.println(generator.getSequence());
    System.out.println(generator.getSequence());
  }
}
