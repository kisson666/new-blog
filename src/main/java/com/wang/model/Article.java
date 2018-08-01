package com.wang.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Table(name = "article")
@Entity
public class Article implements Serializable {


  public ArticlePK apk = null;
  public String content = null;
  public int cid;

  @Override
  public String toString() {
    return "Article{" +
        "apk=" + apk +
        ", content='" + content + '\'' +
        ", cid=" + cid +
        ", name='" + name + '\'' +
        ", time='" + time + '\'' +
        ", privatesee=" + privatesee +
        '}';
  }

  //public String getIsread() {
  //	return isread;
  //}

  //public void setIsread(String isread) {
  //	this.isread = isread;
  //}

  public String name = null;
  public String time;
  public int privatesee = 0;    //是否设置只有自己可见 0表示所有人可见 1表示只有自己可见 默认为0

  //public String isread="未读"; //后来加的 标记是否浏览过  还是注释掉了 因为这么多用户 我读了 把它改成已读 但是其他用户没读怎么办
  public int getPrivatesee() {
    return privatesee;
  }

  public void setPrivatesee(int privatesee) {
    this.privatesee = privatesee;
  }

  public String getTime() {
    return time;
  }

  @EmbeddedId
  public ArticlePK getApk() {
    return apk;
  }//封装了article表中作为复合主键的两个属性 title和id

  public void setApk(ArticlePK apk) {
    this.apk = apk;
  }

  public void setTime(String time) {

    this.time = time;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Article() {
    super();
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getCid() {
    return cid;
  }

  public void setCid(int cid) {
    this.cid = cid;
  }

}