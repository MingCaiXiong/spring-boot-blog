package top.xiongmingcai.blog.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import org.springframework.web.bind.annotation.*;
import top.xiongmingcai.blog.model.pojo.Cat;
import top.xiongmingcai.blog.model.vo.ArticleVo;
import top.xiongmingcai.blog.service.ArticleService;
import top.xiongmingcai.blog.service.CatService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Controller：
 *
 * @author
 * @date 2021-05-12 19:46:27
 */
@RestController
public class CatController extends ApiController {
  @Resource private CatService catService;
  @Resource private ArticleService articleService;

  @GetMapping("/cat/all")
  public Object allDemo() {
    Cat catalog = catService.getCatalog();
    return success(catalog);
  }

  @GetMapping("/cats/{rid}")
  public Object findCatlist(@PathVariable("rid") Long rid) {
    List<ArticleVo> articleList = articleService.selectCatArticleByRid(rid);
    return success(articleList);
  }
}
