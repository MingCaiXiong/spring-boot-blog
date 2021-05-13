package top.xiongmingcai.blog.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.xiongmingcai.blog.model.pojo.Article;
import top.xiongmingcai.blog.model.pojo.Cat;

import java.util.List;

/**
 * 存储库：文章表
 *
 * @author
 * @date 2021-05-13 00:15:29
 */
@Mapper
@Repository
public interface ArticleMapper extends BaseMapper<Article> {

  /**
   * 根据 cat_article aid 找一篇文章
   *
   * @param aid
   * @return 找一篇文章
   */
  Article selectCatArtocleAid(@Param("aid") Long aid);

  /**
   * 根据 cat_article rid 找文章列表
   *
   * @param rid
   * @return 文章列表
   */
  List<Article> selectCatArticleByRid(@Param("rid") Long rid);
}
