import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
  private String content =
      "<ul>\n"
          + "    <l1>北京Beijing</l1>\n"
          + "    <l1>上海Shanghai</l1>\n"
          + "    <l1>新疆维吾尔自治区Xinjiang</l1>\n"
          + "</ul>";

  @Test
  void regex() {
    // 1 ,创建正则表达式对象
    Pattern compile = Pattern.compile("<l1>([\\u4e00-\\u9fa5]{2,})([A-Za-z]+)</l1>");
    // 2 , 匹配正则表达式（将整理的字符串按正则表达式规则选取）
    Matcher matcher = compile.matcher(content);
    // 3 , 查找匹配的结果
    while (matcher.find()) {
      String chs = matcher.group(1); // 第一组的内容
      String eng = matcher.group(2); // 第二组的内容
      System.out.println(chs + " - " + eng);
    }
  }
}
