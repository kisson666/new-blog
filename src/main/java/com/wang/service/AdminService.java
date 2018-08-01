package com.wang.service;

import java.util.List;

import com.wang.model.Article;
import com.wang.model.User;

/**
 * Created by hppc on 2017/1/25.
 */
public interface AdminService {
  User getuser(String id);

  int updatetime(String id);

  //List<User> getranduser();  随机查询
  String updatename(String name, String id);

  String updatepassword(String newpassword1, String newpassword2, String oldpassword, String id);

  String deleteaccount(String id, String password);

  String register(String id, String name, String password);//注册

  User check(String id);

  List<Article> checkUnique(String title, String id);//2017-5-28修同一用户写同题目的多篇文章时不能插入 只是更新的bug
}
