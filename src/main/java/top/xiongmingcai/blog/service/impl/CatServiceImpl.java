package top.xiongmingcai.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import top.xiongmingcai.blog.model.dao.CatMapper;
import top.xiongmingcai.blog.model.pojo.Cat;
import top.xiongmingcai.blog.service.CatService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CatServiceImpl implements CatService {
  @Resource private CatMapper catMapper;

  public Cat getOneCat(Long id) {
    QueryWrapper<Cat> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("pid", id);
    return catMapper.selectOne(queryWrapper);
  }

  @Override
  public Cat getCatalog() {
    Cat select = getOneCat(0L);
    Long uuid = select.getUuid();
    List<Cat> children = getChildren(uuid);
    children.forEach(
        item -> {
          List<Cat> children1 = getChildren(item.getUuid());
          if (children1 != null) {
            item.setChildren(children1);
          }
        });

    select.setChildren(children);
    return select;
  }

  private List<Cat> getChildren(Long uuid) {
    QueryWrapper<Cat> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("pid", uuid);

    queryWrapper.orderByAsc("sort");
    return catMapper.selectList(queryWrapper);
  }
}
