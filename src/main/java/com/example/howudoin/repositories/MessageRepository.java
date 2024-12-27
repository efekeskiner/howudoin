package com.example.howudoin.repositories;

import com.example.howudoin.models.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findBySenderIdAndRecipientId(String senderId, String recipientId);
}


