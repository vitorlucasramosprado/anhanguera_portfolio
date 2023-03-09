package com.anhanguera.pw.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anhanguera.pw.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
