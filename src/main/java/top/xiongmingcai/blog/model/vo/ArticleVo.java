package top.xiongmingcai.blog.model.vo;

import lombok.Data;
import top.xiongmingcai.blog.model.pojo.Article;
import top.xiongmingcai.blog.model.pojo.Tag;

import java.util.List;

@Data
public class ArticleVo {
  /*文章的标题，通常为第一行*/
  private String title;
  /*文章的HTML格式的描述，如果文档中没有 <!-- more --> 则跟 content 一样*/
  private String desContent;
  /*文章的纯文字描述，不带 HTML*/
  private String desContentTextOnly;
  /*文章的内容*/
  private String content;

  private String markdown;
  /*源数据*/
  private Article articleSource;

  private List<Tag> tags;
}
