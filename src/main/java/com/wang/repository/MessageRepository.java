package com.wang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.wang.model.Message;

/**
 * Created by hppc on 2017/1/25.
 */
public interface MessageRepository extends JpaRepository<Message, Integer> {
  // List<Message> findByCid(int cid);
  //List<Message> findById(String id);
  @Transactional
  int deleteByMid(int mid);

  @Modifying
  @Query("select message from Message message where message.cid=?1 order by message.time desc")
    //以下两个方法替代了上面注释掉的 因为这个可以排序
  List<Message> findByCidOrder(int cid);

  @Modifying
  @Query("select message from Message message where message.id=?1 order by message.time desc")
  List<Message> findByIdOrder(String id);

  @Modifying
  @Query("select message from Message message where message.articleauthorid=?1 and message.isreadmessage='未读' order by message.time desc")
  List<Message> findnotReadMessage(String articleauthorid);

  @Transactional
  @Modifying
  @Query("update Message message set message.isreadmessage='已读' where message.mid=?1")
  int updateFromNotReadByMid(int mid);
}
