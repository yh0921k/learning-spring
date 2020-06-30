package com.spring.study.sequence;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// @Primary 설정으로 후보 빈을 명시할 수 있다.
// 즉, 여러 개의 빈이 연결 대상일 때 특정한 빈에 우선권을 부여한다.
// PrefixGenerator 타입의 빈 인스턴스가 여럿이더라도
// 스프링은 @Primary를 붙인 클래스의 빈 인스턴스를 자동으로 연결한다.
@Component
@Primary
public class DatePrefixGenerator implements PrefixGenerator {

  @Override
  public String getPrefix() {
    DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
    return formatter.format(new Date());
  }
}
