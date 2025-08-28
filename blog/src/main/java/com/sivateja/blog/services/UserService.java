package com.sivateja.blog.services;

import com.sivateja.blog.domain.entities.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);
}
