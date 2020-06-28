package com.spring.study.sequence;

public interface SequenceDao {

  // 주어진 ID로 DB 테이블을 찾아 POJO나 Sequence 객체를 로딩
  public Sequence getSequence(String sequenceId);

  // 다음 시퀀스값을 추출
  public int getNextVlaue(String sequenceId);
}
