package com.wang.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wang.model.Article;
import com.wang.model.ArticlePK;
import com.wang.repository.ArticleRepository;
import com.wang.repository.UserRepository;

/**
 * Created by hppc on 2017/1/25.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
  @Autowired
  ArticleRepository articleRepository;
  @Autowired
  UserRepository userRepository;

  public List<Article> searcharticle(String title, String id) {
    List<Article> articles = new ArrayList<Article>();
    if (id == null) {
      if (title != null && title != "") {
        articles = articleRepository.findByTitleOrder(title);   //根据题目搜索文章，并向前台传一个list
      } else {
      }
    } else {                         //前端可以输入文章标题和用户ID来查找文章，但是一次只能提交一个表单，所以用if else语句操作
      articles = articleRepository.findByIdOrder(id);
    }
    for (Article article : articles) {
      article.setName(userRepository.findById(article.getApk().getId()).getName());  //根据article作者id查找对应的name
    }
    return articles;
  }

  /*public List<Article> getrandarticle(){ 随机查找文章

  }*/
  public String addarticle(String id, String title, String content, int privatesee) {
    if (title != null && title != "") {
      Article article = new Article();
      ArticlePK apk = new ArticlePK();
      apk.setId(id);
      apk.setTitle(title);
      article.setApk(apk);
      article.setContent(content);
      article.setPrivatesee(privatesee);
      articleRepository.save(article);
      return "添加成功";
    } else {
      return "文章标题不能为空";
    }
  }

  public List<Article> allarticlesByid(String id) {
    return articleRepository.findByIdOrder(id);
  }

  public Article findArticleByCid(int cid) {
    return articleRepository.findByCid(cid);
  }

  public String updatearticlebycid(String content, int privatesee, int cid) {
    if (articleRepository.updatearticlebycid(content, privatesee, cid) == 1) {
      return "修改成功";
    } else {
      return "修改失败";
    }
  }

  public String deletearticlebycid(int cid) {
    if (articleRepository.deleteByCid(cid) == 1) {
      return "删除成功";
    } else {
      return "删除失败";
    }
  }

  public List<Article> recentArticle() {
    List<Article> articles = new ArrayList<Article>();
    Sort sort = new Sort(Sort.Direction.DESC, "time");
    Pageable pageable = new PageRequest(0, 3, sort);  //页数从0开始
    Page<Article> articles1 = articleRepository.findAll(pageable);  //近期的文章
    for (Article article : articles1) {
      if (article.getPrivatesee() != 1) {
        article.setName(userRepository.findById(article.getApk().getId()).getName());  //根据article作者id查找对应的name
        articles.add(article);
      }
    }
    return articles;
  }
}
