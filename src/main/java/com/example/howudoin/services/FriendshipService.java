/*package com.example.howudoin.services;

import com.example.howudoin.models.Friendship;
import com.example.howudoin.repositories.FriendshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FriendshipService {

    @Autowired
    private FriendshipRepository friendshipRepository;

    // Send a friend request
    public void sendFriendRequest(Friendship friendship) {
        friendshipRepository.save(friendship);
    }

    // Update the status of a friend request (ACCEPTED/REJECTED)
    public void updateFriendRequestStatus(String requestId, String status) {
        Optional<Friendship> friendshipOptional = friendshipRepository.findById(requestId);
        if (friendshipOptional.isPresent()) {
            Friendship friendship = friendshipOptional.get();
            friendship.setStatus(status); // Update the status
            friendshipRepository.save(friendship); // Save updated friendship
        } else {
            throw new IllegalArgumentException("Friend request not found with ID: " + requestId);
        }
    }

}*/
package com.example.howudoin.services;

import com.example.howudoin.models.Friendship;
import com.example.howudoin.repositories.FriendshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FriendshipService {

    @Autowired
    private FriendshipRepository friendshipRepository;

    // Send a friend request
    public void sendFriendRequest(Friendship friendship) {
        friendshipRepository.save(friendship);
    }

    // Update the status of a friend request (ACCEPTED/REJECTED)
    public void updateFriendRequestStatus(String requestId, String status) {
        Optional<Friendship> friendshipOptional = friendshipRepository.findById(requestId);
        if (friendshipOptional.isPresent()) {
            Friendship friendship = friendshipOptional.get();
            friendship.setStatus(status); // Update the status
            friendshipRepository.save(friendship); // Save updated friendship
        } else {
            throw new IllegalArgumentException("Friend request not found with ID: " + requestId);
        }
    }

    // Get friend requests by status (ACCEPTED, PENDING, REJECTED)
    public List<Friendship> getFriendRequestsByStatus(String userId, String status) {
        return friendshipRepository.findByUserIdAndStatus(userId, status);
    }

}
