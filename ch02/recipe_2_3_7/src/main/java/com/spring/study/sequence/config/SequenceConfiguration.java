package com.spring.study.sequence.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.spring.study.sequence.PrefixGenerator;
import com.spring.study.sequence.SequenceGenerator;


@Configuration
@Import(PrefixConfiguration.class) // 해당 구성 클래스에 정의한 POJO를 모두 현재 구성 클래스의 스코프로 가져온다.
public class SequenceConfiguration {

  // 이후 @Value와 SpEL(스프링 표현식)을 사용해 해당 구성 클래스에 선언된 datePrefixGenerator 빈을 찾아 주입한다.
  // Value는 변수와 메서드의 파라미터에 기본값을 할당하는데 이용하는 어노테이션
  // @Value 어노테이션의 속성에서 $는 프로퍼티의 값을 읽을 때 사용하며, #은 스프링 표현식을 사용할 수 있다.
  @Value("#{datePrefixGenerator}")
  private PrefixGenerator prefixGenerator;

  @Bean
  public SequenceGenerator sequenceGenerator() {
    SequenceGenerator sequence = new SequenceGenerator();
    sequence.setInitial(100000);
    sequence.setSuffix("A");
    sequence.setPrefixGenerator(prefixGenerator);
    return sequence;
  }
}
