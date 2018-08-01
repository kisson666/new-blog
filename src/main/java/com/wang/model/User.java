package com.wang.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + ", password=" + password + ", time=" + time + ", i=" + i + "]";
  }

  public String id;
  public String name;
  public String password;
  public Timestamp time;
  public int k;//数据库中有个K，但是这个字段有什么用我已经忘了……但是我也不敢删掉 所以加上来了

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }

  public int i = 0;      //用i来判断用户是否为管理员，默认值0表示不是管理员，若是管理员，则把该值赋值为1.

  public int getI() {
    return i;
  }

  public void setI(int i) {
    this.i = i;
  }

  public User() {
    super();
  }

  public User(String id, String name, String password) {
    super();
    this.id = id;
    this.name = name;
    this.password = password;
  }

  @Id
  //@GeneratedValue(strategy = GenerationType.AUTO)  加了这个不能插入  这个是主键生成策略 由于我数据库没设计好 这个表的主键我定义成字符串了 hibernate提供的生成策略我不知道哪个适合我，所以干脆不要了
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


}
