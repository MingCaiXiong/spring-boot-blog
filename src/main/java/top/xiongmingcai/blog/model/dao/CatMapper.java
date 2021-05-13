package top.xiongmingcai.blog.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.xiongmingcai.blog.model.pojo.Cat;

import java.util.List;

/**
 * 存储库：
 *
 * @author
 * @date 2021-05-12 19:46:27
 */
@Mapper
@Repository
public interface CatMapper extends BaseMapper<Cat> {}
