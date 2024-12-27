
/*
package com.example.howudoin.repositories;

import com.example.howudoin.models.Friendship;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface FriendshipRepository extends MongoRepository<Friendship, String> {

    @Query("{ $and: [ { 'status': ?0 }, { $or: [ { 'requesterId': ?1 }, { 'recipientId': ?1 } ] } ] }")
    List<Friendship> findByStatusAndUserId(String status, String userId);

    List<Friendship> findByRequesterId(String requesterId);

    List<Friendship> findByRecipientId(String recipientId);
}
*/

package com.example.howudoin.repositories;

import com.example.howudoin.models.Friendship;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface FriendshipRepository extends MongoRepository<Friendship, String> {

    @Query("{ $and: [ { 'status': ?1 }, { $or: [ { 'requesterId': ?0 }, { 'recipientId': ?0 } ] } ] }")
    List<Friendship> findByUserIdAndStatus(String userId, String status);

    // Optional: For individual user queries if needed
    List<Friendship> findByRequesterId(String requesterId);
    List<Friendship> findByRecipientId(String recipientId);
}

