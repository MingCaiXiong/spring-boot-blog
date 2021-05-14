package top.xiongmingcai.blog.service;

import top.xiongmingcai.blog.model.pojo.Cat;
import top.xiongmingcai.blog.model.vo.CatVo;

import java.util.List;

/**
 * Service：
 *
 * @author
 * @date 2021-05-12 19:46:27
 */
public interface CatService {

  Cat getCatalog();

  /**
   * 查找文章列表菜单
   *
   * @param rId rId
   * @return 文章列表
   */
  Cat getOneCat(Long rId);

  List<CatVo> catVoList();
}
