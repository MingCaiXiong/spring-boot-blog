package top.xiongmingcai.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.xiongmingcai.blog.model.pojo.Tag;

import java.util.List;

/**
 * Service：标签表
 *
 * @author
 * @date 2021-05-14 09:47:16
 */
public interface TagService extends IService<Tag> {
  String CACHE_NAME = "tag";

  List<Tag> selectTagArticleByAid(Long articleId);
}
