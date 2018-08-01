package com.wang.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Created by hppc on 2017/1/25.
 */
@Embeddable  //有这个类是因为article表中有个主键是两个字段一起作为复合主键的 这样搞在写repository方法的时候有点要注意的
public class ArticlePK implements Serializable {
  public ArticlePK() {
  }

  private String id = null;
  private String title = null;

  public String getId() {
    return id;
  }

  @Override
  public String toString() {
    return "ArticlePK{" +
        "id='" + id + '\'' +
        ", title='" + title + '\'' +
        '}';
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
