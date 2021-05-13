package top.xiongmingcai.blog.model.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 实体类： catalog 目录
 *
 * @author
 * @date 2021-05-12 19:46:27
 */
@Data
@TableName("cat")
public class Cat implements Serializable {

  @TableField(exist = false)
  List<Cat> children;
  /** */
  @TableId(type = IdType.AUTO)
  private Object id;
  /** */
  private Long pid;
  /** */
  private Long uuid;
  /** */
  private Object name;
  /** */
  private Object docname;
  /** */
  private Object cattype;
  /** */
  private Object sort;
  /** */
  private Object sorttype;
  /** 网站设置中的网站网址 */
  private Object siteurl;
  /** */
  private Object siteskinname;
  /** 网站最后生成时间 */
  private Object sitelastbuilddate;
  /** */
  private Object sitebuildpath;
  /** */
  private Object sitefavicon;
  /** */
  private Object sitelogo;
  /** */
  private Object sitedateformat;
  /** */
  private Object sitepagesize;
  /** */
  private Object sitelisttextnum;
  /** */
  private Object sitename;
  /** 网站的描述 */
  private Object sitedes;
  /** */
  private Object sitesharecode;
  /** */
  private Object siteheader;
  /** 网站设置中的 网站其它代码 */
  private Object siteother;
  /** */
  private Object sitemainmenudata;
  /** */
  private Object siteextdef;
  /** */
  private Object siteextvalue;
  /** */
  private Object sitepostextdef;
  /** */
  private Object siteenablelatex;
  /** */
  private Object siteenablechart;
}
