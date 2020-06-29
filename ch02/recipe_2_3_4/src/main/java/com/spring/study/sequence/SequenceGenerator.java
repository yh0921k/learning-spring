package com.spring.study.sequence;

import org.springframework.beans.factory.annotation.Autowired;

public class SequenceGenerator {
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

  // setter 메서드에 @Autowired 적용 가능(생성자도 마찬가지)
  // 아래의 경우 prefixGenerator와 타입이 호환되는 빈이 연결됨
  // 스프링은 기본적으로 주입에 필요한 빈을 찾지 못하면 예외가 발생
  // 아래와 같이 required 속성값을 사용해 해당 예외를 무시할 수 있음
  // @Autowired
  // @Autowired(require=false)
  public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
    this.prefixGenerator = prefixGenerator;
  }

  // @Autowired 메서드는 메서드의 이름과 파라미터 개수에 상관없이 적용 가능
  @Autowired
  public void myOwnCustomInjectionName(PrefixGenerator prefixGenerator) {
    this.prefixGenerator = prefixGenerator;
  }

  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }

  public void setInitial(int initial) {
    this.initial = initial;
  }

  public synchronized String getSequence() {
    StringBuilder builder = new StringBuilder();
    builder.append(prefixGenerator.getPrefix());
    builder.append(initial + counter++);
    builder.append(suffix);
    return builder.toString();
  }
}
