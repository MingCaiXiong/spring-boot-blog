package top.xiongmingcai.blog.service;

import top.xiongmingcai.blog.model.pojo.Article;
import top.xiongmingcai.blog.model.vo.ArticleVo;

import java.util.List;

/**
 * Service：文章表
 *
 * @author
 * @date 2021-05-13 00:15:29
 */
public interface ArticleService {

  Article getLastModifiedArticle();

  ArticleVo getOneArticle(Long uuid);

  List<ArticleVo> selectCatArticleByRid(Long catUuid);
}
