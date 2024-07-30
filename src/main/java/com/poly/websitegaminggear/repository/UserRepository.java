package com.poly.websitegaminggear.repository;

import com.poly.websitegaminggear.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
