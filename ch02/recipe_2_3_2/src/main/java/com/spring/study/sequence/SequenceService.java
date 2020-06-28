package com.spring.study.sequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // Spring bean으로 초기화
public class SequenceService {

  // SequenceDaoImpl 빈이 이 프로퍼티에 자동으로 연결됨
  // 배열에 붙이면 매치되는 빈(타입이 호환되는)을 모두 찾아 자동으로 연결
  // List<XXX> (type-safe collection)에 붙이면 해당 컬렉션과 타입이 호환되는 빈을 모두 찾아 연결
  // Map<XXX, XXX>도 위와 동일
  @Autowired
  private SequenceDao sequenceDao;

  public SequenceDao getSequenceDao() {
    return sequenceDao;
  }

  public void setSequenceDao(SequenceDao sequenceDao) {
    // 호출안됨 - private형 변수에 바로 대입(객체지향 위배)
    System.out.println("setSequenceDao() called");
    this.sequenceDao = sequenceDao;
  }

  public String generate(String sequenceId) {
    Sequence sequence = sequenceDao.getSequence(sequenceId);
    int value = sequenceDao.getNextValue(sequenceId);
    return sequence.getPrefix() + value + sequence.getSuffix();
  }
}
