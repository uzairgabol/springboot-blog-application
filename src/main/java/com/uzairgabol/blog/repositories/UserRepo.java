package com.uzairgabol.blog.repositories;

import com.uzairgabol.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
