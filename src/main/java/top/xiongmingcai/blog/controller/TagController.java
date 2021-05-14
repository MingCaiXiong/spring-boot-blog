package top.xiongmingcai.blog.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;

import org.springframework.web.bind.annotation.*;
import top.xiongmingcai.blog.model.pojo.Tag;
import top.xiongmingcai.blog.service.TagService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Controller：标签表
 *
 * @author
 * @date 2021-05-14 09:47:16
 */
@RestController
@RequestMapping("/tag")
public class TagController extends ApiController {
  @Resource private TagService tagService;

  /** 获取全部的 <strong>标签表</strong> 列表 */
  @GetMapping("all")
  public Object listAll() {
    List<Tag> list = tagService.list();
    return success(list);
  }

  /**
   * 获取一个 <strong>标签表</strong>
   *
   * @param id 主键ID
   */
  @GetMapping("{id}")
  public Object info(@PathVariable Long id) {
    return success(tagService.getById(id));
  }
}
