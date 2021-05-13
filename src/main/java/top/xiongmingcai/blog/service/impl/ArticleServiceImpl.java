package top.xiongmingcai.blog.service.impl;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import top.xiongmingcai.blog.model.dao.ArticleMapper;
import top.xiongmingcai.blog.model.pojo.Article;
import top.xiongmingcai.blog.model.vo.ArticleVo;
import top.xiongmingcai.blog.service.ArticleService;

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

  /**
   * 得到一篇文章
   *
   * @param uuid
   * @return 一篇文章数据
   */
  @Override
  public ArticleVo getOneArticle(Long uuid) {
    Article article = getArticle(uuid);
    return toVo(article);
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
    String filedate = null;
    if (article != null) {
      filedate = readMDFile(article.getUuid());
    }
    articleVo.setArticleSource(article);
    articleVo.setContent(getContent(filedate));
    articleVo.setTitle(getTitle(filedate));
    return articleVo;
  }

  private String getTitle(String content) {
    String a = content.substring(0, content.indexOf("\n"));

    String substring = a.substring(a.lastIndexOf(32) + 1);

    return substring;
  }

  private String getContent(String content) {
    String substring = content.substring(content.indexOf("\n"));
    return substring;
  }

  private Article getArticle(Long uuid) {
    return articleMapper.selectCatArtocleAid(uuid);
  }

  public String readMDFile(Long uuid) {

    ClassLoader classLoader = getClass().getClassLoader();
    File file =
        new File(
            Objects.requireNonNull(classLoader.getResource("docs/" + String.valueOf(uuid) + ".md"))
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
