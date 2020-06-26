package com.spring.study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring.study.sequence.SequenceGenerator;
import com.spring.study.sequence.config.SequenceGeneratorConfiguration;

public class Main {
  public static void main(String[] args) {
    /*
     * IoC 컨테이너를 초기화하고 어노테이션 스캐닝 - 아래와 같이 IoC 컨테인를 인스턴스화해야 어노테이션을 붙인 자바 클래스를 탐색할 수 있다. 스프링은 기본 구현체인
     * bean factory와 고급 구현체인 application context의 두 가지 IoC 컨테이너를 제공한다. application context는 기본 기능에
     * 충실하며 bean factory보다 발전된(애플릿이나 모바일 환경에서 실행하는 등의) 기능을 가진다.
     *
     * ApplicationContext 인터페이스를 구현한 여러 구현체가 있다. 최근에 사용하는 것은 아래와 같은
     * AnnotationConfigApplicationContext 구현체이다.
     */
    ApplicationContext context =
        new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class);

    /*
     * IoC 컨테이너에서 POJO 인스턴스/빈 가져오기 해당 빈의 이름으로 getBean() 메서드를 호출한다. getBean() 메서드는 java.lang.Object를
     * 반환하므로 실제 타입에 맞게 형변환이 필요하다. 하지만 두 번째 인자로 class를 지정하는 경우 형변환이 필요없다.
     */
    SequenceGenerator generator = (SequenceGenerator) context.getBean("sequenceGenerator");
    // SequenceGenerator generator = (SequenceGenerator) context.getBean("sequenceGenerator",
    // SequenceGenerator.class);

    System.out.println(generator.getSequence());
    System.out.println(generator.getSequence());
  }
}
