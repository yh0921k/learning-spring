package com.spring.study.shop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring.study.shop.config.ShopConfiguration;

public class Main {

  public static void main(String[] args) throws Exception {
    // @Component와 같은 어노테이션을 붙이는건 빈 생성에 관한 템플릿을 정의하는 것이다.
    // - 실제 인스턴스를 정의하는 것이 아니다.
    // - getBean() 메서드로 빈을 요청하거나 다른 빈에서 참조할 때 스프링은 스코프에 따라 어느 빈 인스턴스를 반환해야 할지 결정해야 한다.

    // @Scope는 빈 스코프를 지정하는 어노테이션이다.
    // - 스프링은 IoC 컨테이너에 선언한 빈마다 인스턴스 하나를 생성하고, 해당 인스턴스는 전체 컨테이너 스코프에 공유된다.
    // - 이러한 스코프가 기본 스코프인 singleton이다.

    // 스코프의 종류
    // - singleton : IoC 컨테이너당 빈 인스턴스 하나
    // - prototype : 요청할 때마다 빈 인스턴스를 새로 생성
    // - request : HTTP 요청마다 하나의 빈 인스턴스 생성(웹 어플리케이션 컨텍스트만 해당)
    // - session : HTTP 세션당 하나의 빈 인스턴스 생성(웹 어플리케이션 컨텍스트만 해당)
    // - globalSession : HTTP 전역 세션당 하나의 빈 인스턴스 생성(포털 어플리케이션 컨텍스트만 해당)
    ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);

    Product aaa = context.getBean("aaa", Product.class);
    Product cdrw = context.getBean("cdrw", Product.class);
    Product dvdrw = context.getBean("dvdrw", Product.class);

    // 1번 카트에 상품 두개를 담는다.
    ShoppingCart cart1 = context.getBean("shoppingCart", ShoppingCart.class);
    cart1.addItem(aaa);
    cart1.addItem(cdrw);
    System.out.println("Shopping cart 1 contains " + cart1.getItems());

    // 2번 카트에 같은 방법으로 카트를 가져와 다른 상품을 넣는다.
    ShoppingCart cart2 = context.getBean("shoppingCart", ShoppingCart.class);
    cart2.addItem(dvdrw);
    System.out.println("Shopping cart 2 contains " + cart2.getItems());

    // 결과를 확인하면 1번 카트에 담긴 두 개의 물품이 서로 다른 카트가 공유하고 있다.
    // 기본 스코프가 singleton이기 때문에 IoC 컨테이너당 카트 인스턴스가 하나만 생성된 문제이다.
    // ShoppingCart.java의 Scope를 portotype으로 지정하면 스프링은 getBean() 메서드 호출마다 새로운 인스턴스를 생성한다.

  }
}
