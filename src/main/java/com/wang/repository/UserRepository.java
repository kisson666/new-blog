package com.wang.repository;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.wang.model.User;

/**
 * Created by hppc on 2017/1/25.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
  User findByName(String name);

  User findById(String id);

  @Transactional
  @Modifying
  @Query("update User user set user.time=?1 where user.id=?2")
  int updatetime(Timestamp time, String id);

  //List<User> findBy  随机查找
  @Transactional
  @Modifying
  @Query("update User user set user.name=?1 where user.id=?2")
  int updatename(String name, String id);

  @Transactional
  @Modifying
  @Query("update User user set user.password=?1 where user.password=?2")
  int updatepassword(String newpassword, String oldpassword);

  // String findPasswordById(String id);  这样写不行
  @Transactional
  //必须要事务
  int deleteByid(String id);
}
