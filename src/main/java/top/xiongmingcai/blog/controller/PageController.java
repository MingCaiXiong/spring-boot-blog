package top.xiongmingcai.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.xiongmingcai.blog.model.pojo.Article;
import top.xiongmingcai.blog.model.vo.ArticleVo;
import top.xiongmingcai.blog.model.vo.CatVo;
import top.xiongmingcai.blog.service.ArticleService;
import top.xiongmingcai.blog.service.CatService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class PageController {
  @Resource private ArticleService articleService;
  @Resource private CatService catService;

  @RequestMapping({"/post/{articleUuid}"})
  public String post(@PathVariable(value = "articleUuid") Long articleUuid, ModelMap modelMap) {

    ArticleVo article = articleService.getOneArticle(articleUuid);

    Long rid = article.getArticleSource().getRid();
    List<ArticleVo> articleVoList = articleService.selectCatArticleByRid(rid);

    List<CatVo> catVoList = catService.catVoList();

    modelMap.addAttribute("article", article);
    modelMap.addAttribute("articleVoList", articleVoList);
    modelMap.addAttribute("catVoList", catVoList);
    return "index";
  }

  @RequestMapping()
  public String post() {
    Article lastModifiedArticle = articleService.getLastModifiedArticle();

    return "redirect:/post/" + lastModifiedArticle.getUuid();
  }
}
