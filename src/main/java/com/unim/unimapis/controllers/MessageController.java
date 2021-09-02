package com.unim.unimapis.controllers;

import com.unim.unimapis.dtos.message.MessageDto;
import com.unim.unimapis.services.MessageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@RequestMapping("/chat")
public class MessageController {

  MessageService messageService;

  @MessageMapping("/{receiverId}")
  public void sendMessage(@DestinationVariable Integer receiverId, MessageDto dto) {
    messageService.sendMessage(receiverId, dto);
  }
}
