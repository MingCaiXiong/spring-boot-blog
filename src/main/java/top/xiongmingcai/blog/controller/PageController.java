package top.xiongmingcai.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.xiongmingcai.blog.model.vo.ArticleVo;
import top.xiongmingcai.blog.service.ArticleService;
import top.xiongmingcai.blog.service.CatService;
import top.xiongmingcai.blog.utils.MarkdownUtils;

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
    // MarkDown文本转成HTML文本
    String HTMLContent = MarkdownUtils.markdownToHtmlExtensitons(article.getContent());
    article.setContent(HTMLContent);

    modelMap.addAttribute("article", article);
    modelMap.addAttribute("articleVoList", articleVoList);
    return "index";
  }
}
