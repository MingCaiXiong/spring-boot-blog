package top.xiongmingcai.blog.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 实体类：文章表
 *
 * @author
 * @date 2021-05-13 00:15:29
 */
@Data
@TableName("article")
public class Article implements Serializable {

  /** */
  @TableId(type = IdType.AUTO)
  private Object id;

  /** 主键ID */
  private Long uuid;

  /** 关联表字段 */
  private Long rid;

  /** */
  private Object type;

  /** 是否显示 */
  private Object state;

  /** */
  private Long sort;

  /** */
  private Long dateadd;

  /** 文章修改的时间 */
  private Long datemodif;

  /** 文章新增的时间，格式按网站设定，默认为：2014/10/24 */
  private Long dateart;

  /** URL自定义名 */
  private Object docname;

  /** */
  private Object othermedia;

  /** */
  private Object buildresource;

  /** */
  private Object postextvalue;

  public Object getDateadd() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return simpleDateFormat.format(new Date(this.dateadd * 1000L));
  }
}
