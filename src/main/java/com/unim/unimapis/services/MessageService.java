package com.unim.unimapis.services;

import com.unim.unimapis.dtos.message.MessageDto;

public interface MessageService {
  void sendMessage(Integer receiverId, MessageDto messageDto);
}
