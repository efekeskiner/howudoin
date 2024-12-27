/*package com.example.howudoin.controllers;

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
}*/
/*
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
        friendship.setStatus("PENDING"); // Set initial status to PENDING
        friendshipService.sendFriendRequest(friendship);
        return ResponseEntity.ok("Friend request sent!");
    }

    // Accept a friend request
    @PostMapping("/accept/{requestId}")
    public ResponseEntity<String> acceptFriendRequest(@PathVariable String requestId) {
        friendshipService.updateFriendRequestStatus(requestId, "ACCEPTED");
        return ResponseEntity.ok("Friend request accepted!");
    }

    // Reject a friend request
    @PostMapping("/reject/{requestId}")
    public ResponseEntity<String> rejectFriendRequest(@PathVariable String requestId) {
        friendshipService.updateFriendRequestStatus(requestId, "REJECTED");
        return ResponseEntity.ok("Friend request rejected!");
    }

}*/
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
        friendship.setStatus("PENDING"); // Set initial status to PENDING
        friendshipService.sendFriendRequest(friendship);
        return ResponseEntity.ok("Friend request sent!");
    }

    // Accept a friend request
    @PostMapping("/accept/{requestId}")
    public ResponseEntity<String> acceptFriendRequest(@PathVariable String requestId) {
        friendshipService.updateFriendRequestStatus(requestId, "ACCEPTED");
        return ResponseEntity.ok("Friend request accepted!");
    }

    // Reject a friend request
    @PostMapping("/reject/{requestId}")
    public ResponseEntity<String> rejectFriendRequest(@PathVariable String requestId) {
        friendshipService.updateFriendRequestStatus(requestId, "REJECTED");
        return ResponseEntity.ok("Friend request rejected!");
    }

    // Retrieve all pending friend requests for a user
    @GetMapping("/pending/{userId}")
    public List<Friendship> getPendingFriendRequests(@PathVariable String userId) {
        return friendshipService.getFriendRequestsByStatus(userId, "PENDING");
    }

    // Retrieve all friends (accepted friendships) for a user
    @GetMapping("/accepted/{userId}")
    public List<Friendship> getAcceptedFriendships(@PathVariable String userId) {
        return friendshipService.getFriendRequestsByStatus(userId, "ACCEPTED");
    }

    // Retrieve all rejected friend requests for a user
    @GetMapping("/rejected/{userId}")
    public List<Friendship> getRejectedFriendRequests(@PathVariable String userId) {
        return friendshipService.getFriendRequestsByStatus(userId, "REJECTED");
    }
}
