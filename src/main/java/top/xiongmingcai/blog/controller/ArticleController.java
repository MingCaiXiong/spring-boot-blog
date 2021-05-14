package top.xiongmingcai.blog.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import org.springframework.web.bind.annotation.*;
import top.xiongmingcai.blog.model.vo.ArticleVo;
import top.xiongmingcai.blog.service.ArticleService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Controller：文章表
 *
 * @author
 * @date 2021-05-13 00:15:29
 */
@RestController
public class ArticleController extends ApiController {
  @Resource private ArticleService articleService;

  @GetMapping("/article/{articleUuid}")
  public Object articleDetails(@PathVariable("articleUuid") Long articleUuid) throws IOException {
    ArticleVo articleVo = articleService.getOneArticle(articleUuid);
    return success(articleVo);
  }

  @GetMapping("/articles/{catUuid}")
  public Object articleList(@PathVariable("catUuid") Long catUuid) {
    List<ArticleVo> articleList = articleService.selectCatArticleByRid(catUuid);
    return success(articleList);
  }
}
