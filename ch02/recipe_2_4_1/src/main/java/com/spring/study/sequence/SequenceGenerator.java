package com.spring.study.sequence;

import javax.annotation.Resource;

public class SequenceGenerator {
  // @Autowired 대신 @Resource 사용
  // - 해당 어노테이션은 스프링에서만 사용 가능
  // - org.springframework.beans.factory.annotation 
  
  // 아래는 자바 표준 어노테이션
  // @Resource는 JSR-250에 규정된 어노테이션으로 이름으로 POJO 객체를 찾아 연결
  // @Inject는 JSR-330에 규정된 어노테이션으로 타입으로 POJO 객체를 찾아 연결
  
  // 타입이 같은 POJO가 다수일 때 @Autowired를 사용하면 가리키는 대상이 모호해진다.
  // 결국 @Qualifier를 써서 이름으로 다시 POJO를 찾아야한다.
  // @Resource는 결국 @Autowired + @Qualifier인 것이다.
  @Resource(name = "datePrefixGenerator")
  private PrefixGenerator prefixGenerator;
  private String suffix;
  private int initial;
  private int counter;

  public SequenceGenerator() {}

  public SequenceGenerator(PrefixGenerator prefixGenerator, String suffix, int initial) {
    this.prefixGenerator = prefixGenerator;
    this.suffix = suffix;
    this.initial = initial;
  }

  public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
    this.prefixGenerator = prefixGenerator;
  }

  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }

  public void setInitial(int initial) {
    this.initial = initial;
  }

  public synchronized String getSequence() {
    StringBuilder buffer = new StringBuilder();
    buffer.append(prefixGenerator.getPrefix());
    buffer.append(initial + counter++);
    buffer.append(suffix);
    return buffer.toString();
  }
}
