package com.spring.study.sequence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.spring.study.sequence.SequenceGenerator;

// 현재 클래스가 구성 클래스임을 스프링에 알림
// 아래 어노테이션을 보면 일단 그 안에서 빈 인스턴스 정의부, 즉 @Bean을 붙인(빈 인스턴스를 생성하여 반환하는) 자바 메서드를 찾는다.
@Configuration
public class SequenceGeneratorConfiguration {

  // 아래 어노테이션을 붙이면 해당 메서드와 동일한 이름의 빈이 생성된다.
  // 빈 이름을 따로 명시하려면 @Bean(name="myBean")과 같이 name 속성을 이용한다.
  // 빈 이름을 따로 지정하면 메서드명은 무시된다.
  @Bean
  public SequenceGenerator sequenceGenerator() {
    SequenceGenerator seqgen = new SequenceGenerator();
    seqgen.setPrefix("30");
    seqgen.setSuffix("A");
    seqgen.setInitial(100000);
    return seqgen;
  }
}
