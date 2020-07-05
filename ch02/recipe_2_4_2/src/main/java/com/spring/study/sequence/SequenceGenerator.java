package com.spring.study.sequence;

import javax.inject.Inject;

public class SequenceGenerator {

  // @Inject도 @Autowired나 @Resource와 마찬가지로 타입으로 POJO를 찾는다.
  // 하지만 타입이 여러 개인 경우 @Inject를 이용해 빈 이름으로 연결하려면 다른 방법을 사용한다.
  // - POJO 주입 클래스와 주입 지점을 구별하기 위해 커스텀 어노테이션 작성이 필요하다.
  // - DatePrefixAnnotation.java 확인
  @Inject
  @DatePrefixAnnotation
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
