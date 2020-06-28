package com.spring.study.shop;

// 다양한 형태의 상품 구조를 만들기 위해 추상 클래스로 작성
// 여러 클래스가 이 추상 클래스를 상속하는 구조로 만들어질 예정
public abstract class Product {
  private String name;
  private double price;

  public Product() {

  }

  public Product(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Product [name=" + name + ", price=" + price + "]";
  }
}
