package com.wang.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.wang.model.Article;
import com.wang.model.ArticlePK;

/**
 * Created by hppc on 2017/1/25.
 */
public interface ArticleRepository extends JpaRepository<Article, ArticlePK> {
  //List<Article> findByApkTitle(String title);
  //List<Article> findByApkId(String id);
  Article findByCid(int cid);

  @Transactional
  @Modifying
  //自定义的jpql语句可以用@Query写，但是必须使用@Modifying修饰，以通知 SpringData， 这是一个 UPDATE 或 DELETE 操作
  @Query("update Article article set article.content=?1,article.privatesee=?2 where article.cid=?3")
  int updatearticlebycid(String content, int privatesee, int cid);

  @Transactional
  int deleteByCid(int cid);

  @Modifying
  @Query("select article from Article article where article.apk.id=?1 order by article.time desc ")
  List<Article> findByIdOrder(String id);

  @Modifying
  @Query("select article from Article article where article.apk.title like %?1% order by article.time desc ")
  List<Article> findByTitleOrder(String title);

  @Modifying
  @Query("select article from Article article where article.apk.title=?1 and article.apk.id=?2")
  List<Article> checkUnique(String title, String id);    //modifying只能返回int或者list？？？


  Page<Article> findAll(Pageable pageable);
}
