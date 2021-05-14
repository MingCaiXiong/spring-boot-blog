package top.xiongmingcai.blog.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CatVo {

  /** */
  private Long pid;
  /** */
  private Long uuid;

  /*排序*/
  private Long sort;
  /*类型*/
  private Long cattype;

  private String name;

  public CatVo() {}

  public CatVo(Long pid, Long uuid, Long sort, Long cattype, String name) {
    this.pid = pid;
    this.uuid = uuid;
    this.sort = sort;
    this.cattype = cattype;
    this.name = name;
  }
}
