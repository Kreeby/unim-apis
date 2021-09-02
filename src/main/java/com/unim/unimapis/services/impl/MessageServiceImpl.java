package com.unim.unimapis.services.impl;

import com.unim.unimapis.dtos.message.MessageDto;
import com.unim.unimapis.models.UserEntity;
import com.unim.unimapis.repository.UserRepository;
import com.unim.unimapis.services.MessageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

  UserRepository userRepository;
  SimpMessagingTemplate simpMessagingTemplate;

  @Override
  public void sendMessage(Integer receiverId, MessageDto messageDto) {
    UserEntity toUser = userRepository.findById(receiverId)
            .orElseThrow(() -> new NoSuchElementException("There is no user with id " + receiverId));
    simpMessagingTemplate.convertAndSend("/topic/messages/" + receiverId, messageDto);
  }
}
