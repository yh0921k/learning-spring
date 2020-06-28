package com.spring.study.shop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring.study.shop.config.ShopConfiguration;

public class Main {
  public static void main(String[] args) {
    // IoC 컨테이너에서 상품을 제대로 가져오는지 테스트하기 위한 코드
    ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);

    Product aaa = context.getBean("aaa", Product.class);
    Product cdrw = context.getBean("cdrw", Product.class);

    System.out.println(aaa);
    System.out.println(cdrw);
  }
}
