package com.wang.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wang.model.User;
import com.wang.repository.MessageRepository;
import com.wang.service.AdminService;
import com.wang.service.ArticleService;

/**
 * Created by hppc on 2017/1/26.
 */
@Controller
public class CheckLogin {
  @Autowired
  AdminService adminService;
  @Autowired
  MessageRepository messageRepository;

  @Autowired
  ArticleService articleService;

  @RequestMapping(value = "/check", method = RequestMethod.POST)
  public void check(@RequestParam String id, @RequestParam String password,
                    HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    HttpSession session = request.getSession();
    if (adminService.check(id) != null) {
      User user = adminService.check(id);
      System.out.println("数据库中的密码是" + user.password);
      if (user.password.equals(password)) {
        System.out.println("欢迎你" + user.name);
        adminService.updatetime(id);
        session.setAttribute("user", user);
        ServletContext application = request.getSession().getServletContext(); //获得application对象 记录网站访问人数
        String counter = (String) application.getAttribute("counter");
        int n;
        if (counter != null) {
          n = Integer.valueOf(counter);
          n++;           //这一段是后来加的 因为想用application统计访问量
        } else {
          n = 1;
        }
        counter = String.valueOf(n);
        application.setAttribute("counter", counter);
        if (!messageRepository.findnotReadMessage(id).isEmpty()) {
          session.setAttribute("isReadMessage", "1");  //代表有未读留言
        }
        session.setAttribute("recentArticles", articleService.recentArticle());  //添加最近的文章到session中
        response.sendRedirect("view/welcome.jsp");
      } else {
        System.out.println("密码错误");
        request.setAttribute("messages", "你输入的密码不对");
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
      }
    } else {
      System.out.println("账号输入有误");
      request.setAttribute("messages", "你输入的账号不对");
      RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
      rd.forward(request, response);
    }
  }

  @RequestMapping("/logoff")
  public void logoff(HttpServletRequest request, HttpServletResponse response) throws IOException {
    System.out.println("注销登陆");
    HttpSession session = request.getSession();
    session.removeAttribute("user");
    response.sendRedirect("login.jsp");
  }

  @RequestMapping(value = "/checkadministrator", method = RequestMethod.POST)
  public void checkadministrator(@RequestParam String id, @RequestParam String password,
                                 HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    System.out.println("管理员账号登陆");
    HttpSession session = request.getSession();
    //String checkcode=request.getParameter("checkcode");
    //Dao dao=new DaoImpl();
    //boolean isValid = CheckCode.isValid(request, checkcode); //这是判断验证码是否正确的方法
    //if(isValid){
    if (adminService.check(id) != null) {
      User user = adminService.check(id);      //从数据库中拿到密码再在这里进行比较
      if (user.i == 1) {
        System.out.println("数据库中管理员表的密码是" + user.password);
        if (user.password.equals(password)) {
          System.out.println("欢迎你,管理员" + user.name);
          adminService.updatetime(id);
          session.setAttribute("user", user);
          ServletContext application = request.getSession().getServletContext(); //获得application对象 记录网站访问人数
          String counter1 = (String) application.getAttribute("counter1");
          int n;
          if (counter1 != null) {
            n = Integer.valueOf(counter1);
            n++;           //这一段是后来加的 因为想用application统计访问量
          } else {
            n = 1;
          }
          counter1 = String.valueOf(n);
          application.setAttribute("counter1", counter1);
          response.sendRedirect("view/administrator/welcomeadministrator.jsp");
        } else {
          System.out.println("密码错误");
          request.setAttribute("messages", "你输入的密码不对哦，再试一次吧");
          RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
          rd.forward(request, response);
        }
      } else {
        System.out.println("此账号没有管理员权限");
        request.setAttribute("messages", "你还没有管理员权限，请选择普通用户登陆吧");
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
      }
    } else {
      System.out.println("账号输入有误");
      request.setAttribute("messages", "你输入的账号不对哦，再试一次吧");
      RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
      rd.forward(request, response);
    }
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public void register(@RequestParam String id, @RequestParam String name, @RequestParam String password, @RequestParam String password1,
                       HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("前端传来一个注册请求");
    System.out.println("注册ID" + id + "注册密码" + password);
    if (password.equals(password1) && password != null && password != "") {
      String judgeid = "[a-zA-Z]{1}[a-zA-Z0-9_]{6,12}";                            /**此正则表达式判断单词字符是否为：[a-zA-Z_0-9]**/
      Pattern pattern = Pattern.compile(judgeid);    //正则表达式判断用户输入的ID是否符合规范
      if (pattern.matcher(id).matches()) {  //id格式正确
        String result = adminService.register(id, name, password);
        if (result.equals("注册成功")) {   //id没有被注册过 且注册成功
          System.out.println("注册成功");
          User user = new User(id, name, password);
          HttpSession session = request.getSession();
          session.setAttribute("user", user);
          request.setAttribute("messages1", "注册成功，请登录");
          RequestDispatcher rd = request.getRequestDispatcher("registerresult.jsp");
          rd.forward(request, response);
        } else {
          System.out.println("注册失败,ID已经注册过了");
          request.setAttribute("messages1", result);
          RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
          rd.forward(request, response);
        }
      } else {
        System.out.println("注册时ID输入格式有误");
        request.setAttribute("messages1", "登陆ID不对，只能输入英文字母或数字组合");
        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
        rd.forward(request, response);
      }
    } else {
      System.out.println("注册时两次输入的密码不一致");
      request.setAttribute("messages1", "两次输入的密码不一致");
      RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
      rd.forward(request, response);
    }
  }
}
