package com.example.howudoin.controllers;

import com.example.howudoin.models.Group;
import com.example.howudoin.models.GroupMessage;
import com.example.howudoin.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    // Create a new group
    @PostMapping("/create")
    public ResponseEntity<Group> createGroup(@RequestParam String name, @RequestBody List<String> members) {
        return ResponseEntity.ok(groupService.createGroup(name, members));
    }

    // Add a new member to an existing group
    @PostMapping("/{groupId}/add-member")
    public ResponseEntity<Group> addMember(@PathVariable String groupId, @RequestParam String memberId) {
        return ResponseEntity.ok(groupService.addMember(groupId, memberId));
    }

    // Send a message to a group
    @PostMapping("/{groupId}/send")
    public ResponseEntity<GroupMessage> sendMessage(@PathVariable String groupId, @RequestParam String senderId, @RequestBody String content) {
        return ResponseEntity.ok(groupService.sendMessage(groupId, senderId, content));
    }

    // Get all messages for a group
    @GetMapping("/{groupId}/messages")
    public ResponseEntity<List<GroupMessage>> getMessages(@PathVariable String groupId) {
        return ResponseEntity.ok(groupService.getMessages(groupId));
    }

    // Get all members of a group
    @GetMapping("/{groupId}/members")
    public ResponseEntity<List<String>> getMembers(@PathVariable String groupId) {
        return ResponseEntity.ok(groupService.getMembers(groupId));
    }
}
