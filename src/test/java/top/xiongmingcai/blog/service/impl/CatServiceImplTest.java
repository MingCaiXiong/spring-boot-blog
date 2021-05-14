package top.xiongmingcai.blog.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.xiongmingcai.blog.model.vo.CatVo;
import top.xiongmingcai.blog.service.CatService;

import javax.annotation.Resource;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CatServiceImplTest {
  @Resource private CatService catService;

  @Test
  void catVoList() {
    List<CatVo> catVos = catService.catVoList();
    System.out.println(catVos);
  }
}
