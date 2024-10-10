package com.messenger.api.controller;

import com.messenger.api.models.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


@Controller
public class MessageController {
    private final SimpMessagingTemplate messagingTemplate;

    public MessageController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/messages/{conversationId}")
    public void SendMessage(Message message, @DestinationVariable("conversationId") String conversationId) throws Exception {
//        Thread.sleep(1000);
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        var response = new HashMap<String, Object>();

        response.put("ConversationId", conversationId);
        response.put("Message", new Message(message.getFrom(), message.getText(), time));
        messagingTemplate.convertAndSend("/topic/messages/" + conversationId, response);
    }
}
