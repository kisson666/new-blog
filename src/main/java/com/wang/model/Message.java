package com.wang.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message {
  public int cid;
  public String content = null;

  @Override
  public String toString() {
    return "Message{" +
        "cid=" + cid +
        ", content='" + content + '\'' +
        ", isreadmessage='" + isreadmessage + '\'' +
        ", id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", mid=" + mid +
        ", articleauthorid='" + articleauthorid + '\'' +
        ", articleauthorname='" + articleauthorname + '\'' +
        ", articletitle='" + articletitle + '\'' +
        ", time='" + time + '\'' +
        '}';
  }

  public String isreadmessage = "未读";//这里必须指定未读 要不然即使数据库默认是未读 执行save方法的时候还是会赋值为null的

  public String getIsreadmessage() {
    return isreadmessage;
  }

  public void setIsreadmessage(String isreadmessage) {
    this.isreadmessage = isreadmessage;
  }

  public String id = null;
  public String name = null;//这是留言作者自己的昵称
  public int mid;
  public String articleauthorid = null;
  public String articleauthorname = null;
  public String articletitle = null;
  public String time;

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getArticletitle() {
    return articletitle;
  }

  public void setArticletitle(String articletitle) {
    this.articletitle = articletitle;
  }

  public String getArticleauthorid() {
    return articleauthorid;
  }

  public void setArticleauthorid(String articleauthorid) {
    this.articleauthorid = articleauthorid;
  }

  public String getArticleauthorname() {
    return articleauthorname;
  }

  public void setArticleauthorname(String articleauthorname) {
    this.articleauthorname = articleauthorname;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getMid() {
    return mid;
  }

  public void setMid(int mid) {
    this.mid = mid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Message() {
    super();
  }

  public Message(int cid, String content, String id) {
    super();
    this.cid = cid;
    this.content = content;
    this.id = id;
  }

  public int getCid() {
    return cid;
  }

  public void setCid(int cid) {
    this.cid = cid;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
