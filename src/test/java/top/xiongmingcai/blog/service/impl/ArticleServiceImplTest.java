package top.xiongmingcai.blog.service.impl;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class ArticleServiceImplTest {

  private String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
  private Function<Integer, String> randomStringFunction =
      length -> {
        StringBuilder stringBuffer = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < length; i++) {
          // 0-字符串长度随机长度
          int position = random.nextInt(chars.length());

          stringBuffer.append(chars.charAt(position));
        }
        return stringBuffer.toString();
      };

  public static void strFilter(List<String> list, Predicate<String> predicate) {
    for (String s : list) {
      if (predicate.test(s)) {
        System.out.println("s = " + s);
      }
    }
  }

  public static void output(Consumer<String> consumer) {

    String text = "桃李不言下自成蹊";

    consumer.accept(text);
  }

  @Test
  void testPredicate() {

    Predicate<Integer> predicate = n -> n > 4;
    boolean test = predicate.test(10);
    System.out.println("test = " + test);
  }

  @Test
  void name() {
    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    for (Integer num : integers) {
      if (num % 2 == 1) {
        System.out.println(num);
      }
    }
  }

  @Test
  void testFilter() {
    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    Predicate<Integer> odd = n -> n % 2 == 1;
    Predicate<Integer> even = n -> n % 2 == 0;

    System.out.println(filter(integers, even)); // 获取或有奇数；
    // [2, 4, 6, 8]
    System.out.println(filter(integers, odd)); // 获取所有偶数；
    // [1, 3, 5, 7, 9]
    System.out.println(filter(integers, n -> n > 5 && n % 2 == 0)); // 获取数列中大于5的奇数
    // [6, 8]
  }

  private List<Integer> filter(List<Integer> integers, Predicate<Integer> even) {
    return integers.stream().filter(even).collect(Collectors.toList());
  }

  @Test
  void testStrFilter() {
    List<String> strings = Arrays.asList("java", "python", "php", "HTML");

    strFilter(strings, s -> s.contains("a"));
  }

  @Test
  void testConsumer() {

    output(s -> System.out.println("向控制台输出：" + s));

    output(
        s -> {
          System.out.println("向XXX网站发送数据包：" + s);
        });
  }

  @Test
  void randomStringFunction() {
    String randomString = randomStringFunction.apply(16);

    System.out.println(randomString);
    // out: wyrx3o6bzz4bj0h7b4u3awed8abdkqzj
  }

  @Test
  void testMax() {

    List<Integer> list = Arrays.asList(1, 7, 8, 1000, 9, 2, 3, 4, 5, 6);

    BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a > b ? a : b;

    Function<List<Integer>, Integer> maxNum =
        list1 -> {
          Integer max = 0;
          for (Integer item : list1) {
            max = biFunction.apply(max, item);
          }
          return max;
        };
    Integer result = maxNum.apply(list);

    System.out.println("result = " + result);
  }

  @Test
  void testMaxNum() {
    List<Integer> list = Arrays.asList(1, 7, 8, 1000, 9, 2, 3, 4, 5, 6);

    Function<List<Integer>, Integer> maxNum =
        list1 -> {
          Integer max = 0;
          for (Integer ignored : list1) {
            if (ignored > max) {
              max = ignored;
            }
          }
          return max;
        };
    Integer result = maxNum.apply(list);

    System.out.println("result = " + result);
  }
}
