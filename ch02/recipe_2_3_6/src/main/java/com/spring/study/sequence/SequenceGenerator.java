package com.spring.study.sequence;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SequenceGenerator {

  // @Qualifier 설정으로 후보 빈을 명시할 수 있다.
  // 아래와 같이 설정하면 IoC 컨테이너에서 datePrefixGenerator 빈을 찾아 프로퍼티에 연결한다.
  @Autowired
  @Qualifier("datePrefixGenerator")
  private PrefixGenerator prefixGenerator;
  private String suffix;
  private int initial;
  private final AtomicInteger counter = new AtomicInteger();

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

  // @Qualifier를 사용해 메서드 파라미터를 연결할 수 있다.
  // @Autowired
  // public void myOwnCustomInjectionName(
  // @Qualifier("datePrefixGenerator") PrefixGenerator prefixGenerator) {
  // this.prefixGenerator = prefixGenerator;
  // }

  // synchronized 키워드의 사용
  // - 쓰레드의 동기화 목적으로 사용한다.
  // - 현재 데이터를 사용하고 있는 쓰레드를 제외하고 나머지 쓰레드는 데이터에 접근할 수 없다.
  public synchronized String getSequence() {
    return prefixGenerator.getPrefix() + initial + counter.getAndIncrement() + suffix;
  }
}
