package top.xiongmingcai.blog.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.xiongmingcai.blog.model.pojo.Tag;

import java.util.List;

/**
 * 存储库：标签表
 *
 * @author
 * @date 2021-05-14 09:47:16
 */
@Mapper
@Repository
public interface TagMapper extends BaseMapper<Tag> {

  List<Tag> selectTagArticleByAid(Long articleId);
}
