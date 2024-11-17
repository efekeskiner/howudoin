package com.example.howudoin.controllers;

import com.example.howudoin.models.Friendship;
import com.example.howudoin.services.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendShipController {

    @Autowired
    private FriendshipService friendshipService;

    // Send a friend request
    @PostMapping("/request")
    public ResponseEntity<String> sendFriendRequest(@RequestBody Friendship friendship) {
        friendshipService.sendFriendRequest(friendship);
        return ResponseEntity.ok("Friend request sent!");
    }

    // Respond to a friend request
    @PostMapping("/respond")
    public ResponseEntity<String> respondToFriendRequest(@RequestBody Friendship friendship) {
        friendshipService.updateFriendRequestStatus(friendship.getId(), friendship.getStatus());
        return ResponseEntity.ok("Friend request " + friendship.getStatus().toLowerCase() + "!");
    }

    // Get a user's friends
    @GetMapping("/{userId}")
    public List<Friendship> getFriends(@PathVariable String userId) {
        return friendshipService.getAcceptedFriendships(userId);
    }
}
