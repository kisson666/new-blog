package com.wang.admincontroller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wang.model.Article;
import com.wang.model.Message;
import com.wang.model.User;
import com.wang.repository.ArticleRepository;
import com.wang.service.AdminService;
import com.wang.service.ArticleService;
import com.wang.service.MessageService;

/**
 * Created by hppc on 2017/1/25.
 */
@Controller
@RequestMapping("/view")
public class AdminController {
  @Autowired
  AdminService adminService;  //这里会自动去找实现类
  @Autowired
  ArticleService articleService;
  @Autowired
  MessageService messageService;

  @Autowired
  HttpSession session;

  @Autowired
  ArticleRepository articleRepository;


  @RequestMapping("/sercharticles")
  public ModelAndView searcharticles(/*@RequestParam String title, @RequestParam String id*/    //这样写的前提是表单中必须要有 title和id这两个对象
                                                                                                HttpServletRequest request) {
    System.out.println("根据题目关键字或用户ID搜索文章");
    String title = request.getParameter("title");                                                 //否则还得这样写
    String id = request.getParameter("id");
    System.out.println(title + "title是");
    System.out.println(id + "id是");
    List<Article> articles = articleService.searcharticle(title, id);
    List<Article> articles1 = new ArrayList<Article>();
    for (Article article : articles) {
      if (article.getPrivatesee() != 1) {
        articles1.add(article);    //把自己可见的筛出去
      }
    }
    ModelAndView mav = new ModelAndView();
    mav.setViewName("sercharticles");
    mav.addObject("articles", articles1);
    return mav;
  }

  /* @RequestMapping("/getranduser")
   public ModelAndView getranduser(){
       System.out.println("用户请求得到推荐用户");
       ModelAndView mav=new ModelAndView();
       mav.setViewName("receiveranduser");
       List<User> user=new List<User>() {
       }
   }*/
   /*@RequestMapping("/getrandarticle")
    public ModelAndView getrandarticle(){
       System.out.println("用户请求得到推荐文章");
       ModelAndView mav=new ModelAndView();
       mav.setViewName("receiverandarticle");

   }*/
  @RequestMapping("/serchuser")
  public ModelAndView serchuer(@RequestParam String id) {
    System.out.println("用户请求得到其他用户的资料");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("userdetail");
    mav.addObject("user", adminService.getuser(id));
    return mav;
  }

  @RequestMapping(value = "/changemydata", method = RequestMethod.POST)
  public ModelAndView changemydata(@RequestParam String name, @RequestParam String id,
                                   HttpServletRequest request, HttpServletResponse response) throws Exception {
    //用户修改资料 目前只有昵称可修改，以后有时间 可以做头像 个签之类的资料
    System.out.println("用户请求修改资料");
    System.out.println("新名字：" + name);
    String result = adminService.updatename(name, id);
    if (result.equals("修改成功")) {
      HttpSession session = request.getSession();      //若修改成功，则更新session中user 的name
      User user = (User) session.getAttribute("user");
      user.setName(name);
      session.setAttribute("user", user);
    }
    ModelAndView mav = new ModelAndView();
    mav.addObject("result", result);
    mav.setViewName("changemydataresult");
    return mav;
  }

  @RequestMapping(value = "/changemypassword", method = RequestMethod.POST)
  public ModelAndView changemypassword(@RequestParam String oldpassword, @RequestParam String newpassword1, @RequestParam String newpassowrd2,
                                       HttpServletRequest request, HttpServletResponse response) throws Exception {
    System.out.println("用户请求修改密码");
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("user");  //
    ModelAndView mav = new ModelAndView();
    String result = adminService.updatepassword(newpassword1, newpassowrd2, oldpassword, user.id);//先根据ID查找密码，与输入的原密码对比，若相同就可以修改
    if (result.equals("修改成功")) {
      user.setPassword(newpassword1);
    }
    mav.addObject("result", result);
    mav.setViewName("changepasswordresult");
    return mav;
  }

  @RequestMapping(value = "/deletemyaccount", method = RequestMethod.POST)
  public ModelAndView deletemyaccount(@RequestParam String id, @RequestParam String password, HttpServletRequest request) {
    System.out.println("用户请求删除账号");
    String result = adminService.deleteaccount(id, password);
    if (result.equals("删除成功")) {
      HttpSession session = request.getSession();//删除成功了就从session中去除
      session.removeAttribute("user");
    }
    ModelAndView mav = new ModelAndView();
    mav.addObject("result", result);
    mav.setViewName("deleteaccountresult");
    return mav;
  }

  @RequestMapping(value = "addarticle", method = RequestMethod.POST)
  public ModelAndView addarticle(@RequestParam String content, @RequestParam String title, @RequestParam int privatesee,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
    System.out.println("用户写新文章");
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("user");   //获取session的user.id  也就是文章的作者
    String id = user.getId();
    if (adminService.checkUnique(title, id).isEmpty() == false) {
      System.out.println("");
      Date date = new Date();
      SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
      String time = formatter.format(date);
      title = title + "---" + time;
    }
    System.out.println(title);
    String result = articleService.addarticle(id, title, content, privatesee);
    System.out.println("完了完了完了");
    ModelAndView mav = new ModelAndView();
    mav.addObject("result", result);
    mav.setViewName("writearticleresult");
    return mav;
  }

  @RequestMapping(value = "/myblogarticlestitle", method = RequestMethod.POST)  //根据ID查看所有文章
  public ModelAndView myblogarticlestitle(@RequestParam String id) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("articles", articleService.allarticlesByid(id));
    mav.setViewName("myblogarticlestitle");
    return mav;
  }

  @RequestMapping(value = "/myblogmyallmessage", method = RequestMethod.POST)//查看自己写的所有留言
  public ModelAndView myblogmyallmessage(@RequestParam String id) {
    List<Message> messages = messageService.allmessagesfrommyself(id);
    ModelAndView mav = new ModelAndView();
    mav.addObject("messages", messages);
    mav.setViewName("myblogmyallmessage");
    return mav;
  }

  @RequestMapping(value = "/myblogarticlescontent", method = RequestMethod.POST)
  public ModelAndView myblogarticlescontent(@RequestParam int cid) {
    System.out.println("根据cid返回文章和文章的留言"); //cid是文章表的唯一约束
    ModelAndView mav = new ModelAndView();
    mav.addObject("content", articleService.findArticleByCid(cid).content);
    mav.addObject("messages", messageService.allmessagebycid(cid));
    mav.addObject("cid", cid);
    mav.setViewName("myblogarticlescontent");
    return mav;
  }

  @RequestMapping("/myblogdeletemessage")
  public ModelAndView myblogdeletemessage(@RequestParam int mid) {
    String result = messageService.deletemessageBymid(mid);
    ModelAndView mav = new ModelAndView();
    mav.addObject("result", result);
    mav.setViewName("myblogdeletemessageresult");
    return mav;
  }

  @RequestMapping(value = "/addmessage", method = RequestMethod.POST)
  public ModelAndView addmessage(@RequestParam String content, @RequestParam int cid, HttpServletRequest request) throws Exception {
    System.out.println("添加留言");
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("user");  //从session中获取当前用户的id，并作为留言作者的id
    String id = user.getId();//从session获取id
    String result = messageService.addmessage(content, id, cid);
    ModelAndView mav = new ModelAndView();
    mav.addObject("result", result);  //返回执行结果
    mav.setViewName("addmessageresult");
    return mav;
  }

  @RequestMapping("/articleandmessage")
  public ModelAndView articleandmessage(@RequestParam int cid) {
    ModelAndView mav = new ModelAndView();
    Article article = articleService.findArticleByCid(cid);
    mav.addObject("content", article.getContent());
    mav.addObject("privatesee", article.getPrivatesee());
    mav.addObject("messages", messageService.allmessagebycid(cid));
    mav.addObject("cid", cid);
    mav.setViewName("articleandmessage");
    return mav;
  }

  @RequestMapping(value = "/getaarticleinarticle", method = RequestMethod.POST)
  public ModelAndView getaarticleinarticle(@RequestParam int cid) {//修改文章
    Article article = articleService.findArticleByCid(cid);
    ModelAndView mav = new ModelAndView();
    mav.addObject("article", article);
    mav.setViewName("rewritearticle");
    return mav;
  }

  @RequestMapping(value = "/rewritearticle", method = RequestMethod.POST)
  public ModelAndView rewritearticle(@RequestParam String content, @RequestParam int cid, @RequestParam int privatesee
      , HttpServletRequest request, HttpServletResponse response) throws Exception {
    System.out.println("用户请求修改文章,返回文章修改的结果");
       /*response.setContentType("text/html;charset=UTF-8");
       request.setCharacterEncoding("UTF-8");    //设置编码不然会乱码*/ //事实证明在web.xml文件中配置字符过滤之后就不需要了
    String result = articleService.updatearticlebycid(content, privatesee, cid);
    ModelAndView mav = new ModelAndView();
    mav.addObject("result", result);
    mav.setViewName("rewritearticleresult");
    return mav;
  }

  @RequestMapping(value = "/myblogdeletearticle", method = RequestMethod.POST)
  public ModelAndView myblogdeletearticle(@RequestParam int cid) {
    System.out.println("根据cid删除用户文章");
    String result = articleService.deletearticlebycid(cid);
    ModelAndView mav = new ModelAndView();
    mav.addObject("result", result);
    mav.setViewName("myblogdeletearticleresult");
    return mav;
  }

  @RequestMapping("/isreadmessage")
  public ModelAndView isreadmessage(@RequestParam String articleauthorid) {
    System.out.println("用户查看是否有新消息");
    ModelAndView mav = new ModelAndView();
    List<Message> messages = messageService.getnotreadmessages(articleauthorid);
    System.out.println(messages);
    mav.addObject("messages", messages);
    mav.setViewName("isreadmessage");
    session.removeAttribute("isReadMessage");  //进了这个controller说明查看了未读消息 就把session里面的标志有未读消息的标志清掉
    return mav;
  }
//    @RequestMapping("/recentArticle")
//    public void test() {
//        Sort sort = new Sort(Sort.Direction.DESC,"time");
//        Pageable pageable = new PageRequest(0,5,sort);
//        Page<Article> articles = articleRepository.findAll(pageable);
//        for (Article article : articles) {
//            System.out.println(article.getTime());
//        }
//    }
}
