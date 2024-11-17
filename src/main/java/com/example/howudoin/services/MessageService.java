package com.example.howudoin.services;

import com.example.howudoin.models.Message;
import com.example.howudoin.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    // Send a message
    public Message sendMessage(Message message) {
        message.setTimestamp(new Date());
        return messageRepository.save(message);
    }

    // Retrieve chat history
    public List<Message> getChatHistory(String senderId, String recipientId) {
        return messageRepository.findBySenderIdAndRecipientId(senderId, recipientId);
    }
}
