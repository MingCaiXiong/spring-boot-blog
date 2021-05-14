package top.xiongmingcai.blog.service.impl;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import top.xiongmingcai.blog.model.dao.ArticleMapper;
import top.xiongmingcai.blog.model.pojo.Article;
import top.xiongmingcai.blog.model.pojo.Tag;
import top.xiongmingcai.blog.model.vo.ArticleVo;
import top.xiongmingcai.blog.service.ArticleService;
import top.xiongmingcai.blog.service.TagService;
import top.xiongmingcai.blog.utils.MarkdownUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Service：文章表
 *
 * @author
 * @date 2021-05-13 00:15:29
 */
@Service
public class ArticleServiceImpl implements ArticleService {
  @Resource private ArticleMapper articleMapper;
  @Resource private TagService tagService;

  /**
   * 得到一篇文章
   *
   * @param uuid
   * @return 一篇文章数据
   */
  @Override
  public ArticleVo getOneArticle(Long uuid) {
    Article article = getArticle(uuid);
    ArticleVo articleVo = toVo(article);
    List<Tag> tags = tagService.selectTagArticleByAid(article.getUuid());
    // 设置标签
    articleVo.setTags(tags);
    return articleVo;
  }
  /**
   * 查找文章列表菜单
   *
   * @param catUuid
   * @return 文章列表
   */
  @Override
  public List<ArticleVo> selectCatArticleByRid(Long catUuid) {
    List<Article> articles = articleMapper.selectCatArticleByRid(catUuid);
    List<ArticleVo> articleVoList = new ArrayList<>();
    for (Article article : articles) {
      ArticleVo articleVo = toVo(article);

      articleVoList.add(articleVo);
    }
    return articleVoList;
  }

  private ArticleVo toVo(Article article) {
    ArticleVo articleVo = new ArticleVo();
    String markdown = null;
    if (article != null) {
      markdown = readMDFile(article.getUuid());
    }
    articleVo.setMarkdown(markdown);
    articleVo.setArticleSource(article);

    // MarkDown文本转成HTML文本
    String HTMLContent = MarkdownUtils.markdownToHtmlExtensitons(markdown);
    articleVo.setContent(HTMLContent);

    Document doc = Jsoup.parse(HTMLContent);
    String h1 = doc.getElementsByTag("h1").text();
    doc.select("h1").remove();
    String content = doc.getElementsByTag("body").html();
    articleVo.setContent(content);
    articleVo.setTitle(h1);
    return articleVo;
  }

  private Article getArticle(Long uuid) {
    return articleMapper.selectCatArtocleAid(uuid);
  }

  public String readMDFile(Long uuid) {

    ClassLoader classLoader = getClass().getClassLoader();
    File file =
        new File(
            Objects.requireNonNull(
                    classLoader.getResource("static/docs/" + String.valueOf(uuid) + ".md"))
                .getFile());
    String data = null;
    try {
      data = FileUtils.readFileToString(file, "UTF-8");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return data;
  }
}
