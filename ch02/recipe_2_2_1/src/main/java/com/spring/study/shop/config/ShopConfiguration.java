package com.spring.study.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.spring.study.shop.Battery;
import com.spring.study.shop.Disc;
import com.spring.study.shop.Product;

// IoC 컨테이너에 POJO 인스턴스를 정의하기 위해 구성 클래스 작성
// 생성자로 POJO 인스턴스를 생성하는 구성 클래스
@Configuration
public class ShopConfiguration {

  @Bean
  public Product aaa() {
    Battery p1 = new Battery("AAA", 2.5);
    p1.setRechargeable(true);
    return p1;
  }

  @Bean
  public Product cdrw() {
    Disc p2 = new Disc("CD-RW", 1.5);
    p2.setCapacity(700);
    return p2;
  }
}
