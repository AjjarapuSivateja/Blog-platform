package com.sivateja.blog.services;

import com.sivateja.blog.domain.CreatePostRequest;
import com.sivateja.blog.domain.entities.Post;
import com.sivateja.blog.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAllPosts(UUID categoryId, UUID tagId);

    List<Post> getDraftPosts(User user);
    Post createPost(User user, CreatePostRequest createPostRequest);


}
