package top.xiongmingcai.blog.service.impl;

import org.junit.jupiter.api.Test;

class ILambdaTest {
  @Test
  void testLambdaOperator() {
    // 标准写法
    MathOperation add =
        (a, b) -> {
          System.out.println("加法运算");
          return a + b;
        };
    // 简洁写法
    MathOperation subtruction = (a, b) -> a - b;

    System.out.println("add = " + add.operator(1, 3));
    System.out.println("subtruction = " + subtruction.operator(1, 3));
  }
}
