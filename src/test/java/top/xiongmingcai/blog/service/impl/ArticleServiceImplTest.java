package top.xiongmingcai.blog.service.impl;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import top.xiongmingcai.blog.service.ArticleService;

import javax.annotation.Resource;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ArticleServiceImplTest {

  @Test
  void name() throws IOException {
    ArticleServiceImpl articleService = new ArticleServiceImpl();

    articleService.readMDFile(16174294104179L);
  }
}
