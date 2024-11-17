package com.example.howudoin.services;

import com.example.howudoin.models.Friendship;
import com.example.howudoin.repositories.FriendshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendshipService {

    @Autowired
    private FriendshipRepository friendshipRepository;

    // Save a new friend request
    public Friendship sendFriendRequest(Friendship friendship) {
        friendship.setStatus("PENDING");
        return friendshipRepository.save(friendship);
    }

    // Update friend request status
    public Friendship updateFriendRequestStatus(String friendshipId, String status) {
        Friendship friendship = friendshipRepository.findById(friendshipId)
                .orElseThrow(() -> new RuntimeException("Friendship not found!"));
        friendship.setStatus(status);
        return friendshipRepository.save(friendship);
    }

    // Get friends list
    public List<Friendship> getAcceptedFriendships(String userId) {
        return friendshipRepository.findByRecipientIdAndStatus(userId, "ACCEPTED");
    }
}
