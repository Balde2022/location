package com.ocprojecttree.location.Repository.Message;

import com.ocprojecttree.location.Models.Message.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {
}
