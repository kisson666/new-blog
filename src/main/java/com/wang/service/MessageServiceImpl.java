package com.wang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.model.Message;
import com.wang.repository.ArticleRepository;
import com.wang.repository.MessageRepository;
import com.wang.repository.UserRepository;

/**
 * Created by hppc on 2017/1/25.
 */
@Service
public class MessageServiceImpl implements MessageService {
  @Autowired
  MessageRepository messageRepository;
  @Autowired
  ArticleRepository articleRepository;
  @Autowired
  UserRepository userRepository;

  public List<Message> getnotreadmessages(String articleauthorid) {
    List<Message> messages = messageRepository.findnotReadMessage(articleauthorid);
    for (Message message : messages) {
      message.setArticletitle(articleRepository.findByCid(message.getCid()).getApk().getTitle());//根据cid查找文章的标题
      message.setArticleauthorname(userRepository.findById(message.getArticleauthorid()).getName());//根据文章作者id查找他的昵称
      message.setName(userRepository.findById(articleauthorid).getName());
      messageRepository.updateFromNotReadByMid(message.mid);
    }
    return messages;
  }

  public List<Message> allmessagesfrommyself(String id) {  //根据id返回所写的全部留言
    List<Message> messages = messageRepository.findByIdOrder(id);
    for (Message message : messages) {
      message.setArticleauthorid(articleRepository.findByCid(message.getCid()).getApk().getId());//根据留言中文章的唯一标识cid查找article表中的文章作者
      message.setArticletitle(articleRepository.findByCid(message.getCid()).getApk().getTitle());//根据cid查找文章的标题
      message.setArticleauthorname(userRepository.findById(message.getArticleauthorid()).getName());//根据文章作者id查找他的昵称
      message.setName(userRepository.findById(id).getName());
    }
    return messages;
  }

  public List<Message> allmessagebycid(int cid) { //得到谋篇文章的所有留言
    List<Message> messages = messageRepository.findByCidOrder(cid);
    for (Message message : messages) {
      message.setName(userRepository.findById(message.getId()).getName());
    }
    return messages;
  }

  public String deletemessageBymid(int mid) {
    int i = messageRepository.deleteByMid(mid);
    if (i == 1) {
      return "删除成功";
    } else {
      return "删除失败";
    }
  }

  public String addmessage(String content, String id, int cid) {
    //为某一篇文章增加留言，参数分别为 内容content 留言作者的id 数据库中文章的唯一约束cid
    Message message = new Message();
    message.setArticleauthorid(articleRepository.findByCid(cid).getApk().getId());//后来加的 目的是把article表中根据cid查找到的id赋值给message表中的articleauthorid
    message.setCid(cid);
    message.setContent(content);
    message.setId(id);
    if (content != null && content != "") {
      messageRepository.save(message);
      return "添加成功";
    } else {
      return "请输入留言内容再添加";
    }

  }

}
