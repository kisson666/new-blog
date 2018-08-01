package com.wang.service;

import java.util.List;

import com.wang.model.Message;

/**
 * Created by hppc on 2017/1/25.
 */
public interface MessageService {
  List<Message> getnotreadmessages(String articleauthorid);

  List<Message> allmessagesfrommyself(String id);

  List<Message> allmessagebycid(int cid);

  String deletemessageBymid(int mid);

  String addmessage(String content, String id, int cid);

}
