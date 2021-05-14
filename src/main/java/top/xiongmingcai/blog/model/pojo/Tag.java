package top.xiongmingcai.blog.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 实体类：标签表
 *
 * @author
 * @date 2021-05-14 09:47:16
 */
@Data
@TableName("tag")
public class Tag implements Serializable {

  /** */
  @TableId(type = IdType.AUTO)
  private Long id;

  /** */
  private String name;
}
