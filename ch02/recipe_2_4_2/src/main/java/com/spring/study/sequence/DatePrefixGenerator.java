package com.spring.study.sequence;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// 아래와 같이 붙인 후 주입해야 할 필드에 동일하게 설정하면 @Inject에서 타입이 같은 빈이 여러 개일 때 문제가 발생하지 않는다.
@DatePrefixAnnotation
public class DatePrefixGenerator implements PrefixGenerator {

  private DateFormat formatter;

  public void setPattern(String pattern) {
    this.formatter = new SimpleDateFormat(pattern);
  }

  @Override
  public String getPrefix() {
    return formatter.format(new Date());
  }
}
