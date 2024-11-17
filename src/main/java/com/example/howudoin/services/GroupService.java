package com.example.howudoin.services;

import com.example.howudoin.models.Group;
import com.example.howudoin.models.GroupMessage;
import com.example.howudoin.repositories.GroupMessageRepository;
import com.example.howudoin.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupMessageRepository groupMessageRepository;

    // Create a new group
    public Group createGroup(String name, List<String> members) {
        Group group = new Group(name, members);
        return groupRepository.save(group);
    }

    // Add a member to a group
    public Group addMember(String groupId, String memberId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));
        group.getMembers().add(memberId);
        return groupRepository.save(group);
    }

    // Send a message to a group
    public GroupMessage sendMessage(String groupId, String senderId, String content) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));

        GroupMessage message = new GroupMessage(groupId, senderId, content);
        return groupMessageRepository.save(message);
    }

    // Get all messages for a group
    public List<GroupMessage> getMessages(String groupId) {
        return groupMessageRepository.findByGroupId(groupId);
    }

    // Get members of a group
    public List<String> getMembers(String groupId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));
        return group.getMembers();
    }
}
