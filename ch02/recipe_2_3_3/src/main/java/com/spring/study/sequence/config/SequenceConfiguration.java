package com.spring.study.sequence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.spring.study.sequence.DatePrefixGenerator;
import com.spring.study.sequence.NumberPrefixGenerator;
import com.spring.study.sequence.SequenceGenerator;


@Configuration
public class SequenceConfiguration {

  // 현재 SequenceGenerator.java에서 배열 변수에 @Autowried를 명시했다.
  // 이 클래스에서 @Bean 순서를 아래와 같이 구현했기 때문에
  // datePrefixGenerator()가 먼저 추가되고 numberPrefixGenerator()가 이후에 추가된다.
  // 두 Bean의 위치를 바꾸면 출력 결과가 달라질 것이다.
  @Bean
  public DatePrefixGenerator datePrefixGenerator() {
    DatePrefixGenerator dpg = new DatePrefixGenerator();
    dpg.setPattern("yyyyMMdd");
    return dpg;
  }

  @Bean
  public NumberPrefixGenerator numberPrefixGenerator() {
    return new NumberPrefixGenerator();
  }

  @Bean
  public SequenceGenerator sequenceGenerator() {
    SequenceGenerator sequence = new SequenceGenerator();
    sequence.setInitial(100000);
    sequence.setSuffix("A");
    return sequence;
  }
}
