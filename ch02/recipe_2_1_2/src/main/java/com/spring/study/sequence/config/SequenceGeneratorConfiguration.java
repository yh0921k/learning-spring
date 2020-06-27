package com.spring.study.sequence.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 현재 클래스가 구성 클래스임을 스프링에 알림
// 아래 어노테이션을 보면 일단 그 안에서 빈 인스턴스 정의부, 즉 @Bean을 붙인(빈 인스턴스를 생성하여 반환하는) 자바 메서드를 찾는다.
@Configuration
// 아래의 설정은 Dao 혹은 Service가 포함된 것들은 포함시키고 @Controller를 붙인 클래스는 제외시킨다.
@ComponentScan(
    includeFilters = {@ComponentScan.Filter(type = FilterType.REGEX,
        pattern = {"com.spring.study.sequence.*Dao", "com.spring.study.sequence.*Service"})},
    excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = {org.springframework.stereotype.Controller.class})})
public class SequenceGeneratorConfiguration {

}
