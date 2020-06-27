package com.spring.study.sequence;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Component;

// 이름 붙이지 않으면 sequenceDaoImpl이 사용됨
// 컴포넌트 어노테이션을 붙이면 스프링은 이 클래스를 이용해 POJO 생성
// POJO의 쓰임새가 명확하지 않다면 @Component 사용
// 쓰임새에 따라 @Repository, @Service, @Controller 사용
@Component("sequenceDao")
public class SequenceDaoImpl implements SequenceDao {

  private final Map<String, Sequence> sequences = new HashMap<>();
  private final Map<String, AtomicInteger> values = new HashMap<>();

  public SequenceDaoImpl() {
    sequences.put("IT", new Sequence("IT", "30", "A"));
    values.put("IT", new AtomicInteger(10000));
  }

  @Override
  public Sequence getSequence(String sequenceId) {
    return sequences.get(sequenceId);
  }

  @Override
  public int getNextVlaue(String sequenceId) {
    AtomicInteger value = values.get(sequenceId);
    return value.getAndIncrement();
  }

}
