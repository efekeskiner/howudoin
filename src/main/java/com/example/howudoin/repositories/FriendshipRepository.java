package com.example.howudoin.repositories;

import com.example.howudoin.models.Friendship;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FriendshipRepository extends MongoRepository<Friendship, String> {
    List<Friendship> findByRecipientIdAndStatus(String recipientId, String status);
}
