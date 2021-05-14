package top.xiongmingcai.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.xiongmingcai.blog.model.dao.TagMapper;
import top.xiongmingcai.blog.model.pojo.Tag;
import top.xiongmingcai.blog.service.TagService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service：标签表
 *
 * @author
 * @date 2021-05-14 09:47:16
 */
@CacheConfig(cacheNames = {TagServiceImpl.CACHE_NAME})
@Transactional(rollbackFor = Exception.class)
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {
  @Resource private TagMapper tagMapper;

  @Override
  public List<Tag> selectTagArticleByAid(Long articleId) {
    List<Tag> tags = tagMapper.selectTagArticleByAid(articleId);
    return tags;
  }
}
