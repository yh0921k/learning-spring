package com.spring.study.shop;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// 레시피 2_5_1은 아래 어노테이션이 없고, 2_5_2에 있음
@Scope("prototype")
public class ShoppingCart {

  private List<Product> items = new ArrayList<>();

  public void addItem(Product item) {
    items.add(item);
  }

  public List<Product> getItems() {
    return items;
  }
}
