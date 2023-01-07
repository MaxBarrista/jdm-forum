package com.barrista.jdm.forum.repo;

import com.barrista.jdm.forum.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long>
{
}
