package com.wang.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.model.Article;
import com.wang.model.User;
import com.wang.repository.ArticleRepository;
import com.wang.repository.MessageRepository;
import com.wang.repository.UserRepository;

/**
 * Created by hppc on 2017/1/25.
 */
@Service
public class AdminServiceImpl implements AdminService {
  @Autowired
  UserRepository userRepository;
  @Autowired
  MessageRepository messageRepository;
  @Autowired
  ArticleRepository articleRepository;
  private SimpleDateFormat bartDateFormat =
      new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //设置格式


  public User getuser(String id) {
    User user = userRepository.findById(id);
    if (user != null) {
      user.setPassword("");   //数据库有对应user记录的时候才能把密码置空
    }
    return user;
  }

  public User check(String id) {
    return userRepository.findById(id); //这个方法仅用来验证登陆 所以把密码封装在里面了
  }

  public List<Article> checkUnique(String title, String id) {
    return articleRepository.checkUnique(title, id);
  }

  public int updatetime(String id) {
    Date date = new Date();
    String nowtime = bartDateFormat.format(date);
    System.out.println("id为" + id + "的用户成功登陆" + "，登陆时间为" + nowtime);  //
    Timestamp timestamp = Timestamp.valueOf(nowtime);      //获取当前时间，并转换为timestamp类型注入数据库
    int i = userRepository.updatetime(timestamp, id);
    System.out.println(timestamp);
    return i;
  }

  /* public List<User> getranduser(){
       return null;
   }*/
  public String updatename(String name, String id) {
    int i = userRepository.updatename(name, id);
    if (i != 0) {
      return "修改成功";
    } else {
      return "修改失败";
    }
  }

  public String updatepassword(String newpassword1, String newpassword2, String oldpassword, String id) {
    if (newpassword1.equals(newpassword2) && newpassword1 != null && newpassword2 != "") {
      if (oldpassword.equals(userRepository.findById(id).getPassword())) {
        userRepository.updatepassword(newpassword1, oldpassword);
        return "修改成功";
      } else {
        return "原来的密码输入有误";
      }
    } else {
      return "两次输入的密码不一致";
    }
  }

  public String deleteaccount(String id, String password) {
    User user = userRepository.findById(id);
    if (user.getPassword().equals(password)) {
      userRepository.deleteByid(id);
      return "删除成功";
    } else {
      return "删除失败";
    }
  }

  public String register(String id, String name, String password) {
    User user = new User();
    user.setId(id);
    user.setName(name);
    user.setPassword(password);
    User user1 = userRepository.findById(id);
    if (user1 == null) {
      userRepository.save(user);
      return "注册成功";
    } else {
      return "注册失败，该ID已经被注册过";
    }
  }
}
