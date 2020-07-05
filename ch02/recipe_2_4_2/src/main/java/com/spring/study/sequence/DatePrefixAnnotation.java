package com.spring.study.sequence;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

// 아래의 @Qualifier는 스프링에서 사용하는 어노테이션과 다른 어노테이션이다.
// 해당 어노테이션을 작성한 이후 빈 인스턴스를 생성하는 DateprefixGenerator에 해당 어노테이션을 붙인다.
@Qualifier

// 어노테이션이 사용하게될 자바 요소 설정
// TYPE : 클래스, 인터페이스, enum
// FIELD : 클래스 필드 변수
// PARAMETER : 메서드의 파라미터
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER})

// 문서에도 어노테이션 정보 표현
@Documented

// 컴파일 이후에도 JVM에 의해서 참조 가능(자바 리플렉션에 의해 사용)
@Retention(RetentionPolicy.RUNTIME)

// 아래의 @interface는 자바 컴파일러에게 해당 소스가 어노테이션임을 정의
public @interface DatePrefixAnnotation {
}
