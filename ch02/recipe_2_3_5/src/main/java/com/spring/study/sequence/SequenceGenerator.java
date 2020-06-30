package com.spring.study.sequence;

import org.springframework.beans.factory.annotation.Autowired;

public class SequenceGenerator {

  // 아래 부분이 배열 타입이 아니기 때문에 문제가 발생해야 정상
  // 현재 PrefixGenerator 타입의 bean은 @Component가 붙은 두 가지 클래스가 있음
  // 두 개의 클래스 중 @Primary 어노테이션을 설정한 빈이 연결됨.
  @Autowired
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
