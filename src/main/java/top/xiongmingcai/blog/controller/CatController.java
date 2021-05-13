package top.xiongmingcai.blog.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import org.springframework.web.bind.annotation.*;
import top.xiongmingcai.blog.model.pojo.Cat;
import top.xiongmingcai.blog.service.CatService;

import javax.annotation.Resource;

/**
 * Controller：
 *
 * @author
 * @date 2021-05-12 19:46:27
 */
@RestController
@RequestMapping("/catalogs")
public class CatController extends ApiController {
  @Resource private CatService catService;

  @GetMapping
  public Object allDemo() {
    Cat catalog = catService.getCatalog();
    return success(catalog);
  }
}
