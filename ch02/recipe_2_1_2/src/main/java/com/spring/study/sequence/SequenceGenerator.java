package com.spring.study.sequence;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceGenerator {
  private String prefix;
  private String suffix;
  private int initial;

  // AtomicInteger
  // - int 자료형을 가지는 wrapping class
  // - 멀티쓰레드 환경에서 동시성을 보장(여러 쓰레드에서 데이터를 write 해도됨)
  private final AtomicInteger counter = new AtomicInteger();

  public SequenceGenerator() {}

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }

  public void setInitial(int initial) {
    this.initial = initial;
  }

  public String getSequence() {
    StringBuilder builder = new StringBuilder();

    // getAndIncrement() 는 variable++ 과 같은 역할
    builder.append(prefix).append(initial).append(counter.getAndIncrement()).append(suffix);
    return builder.toString();
  }
}
