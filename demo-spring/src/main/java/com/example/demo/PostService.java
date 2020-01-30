package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Petr Janik 485122
 * @since 31/07/2019
 */
@Service
public class PostService implements IPostService {
    private final AtomicLong counter = new AtomicLong();

    private final Set<Post> posts = new HashSet<>(Arrays.asList(new Post(counter.incrementAndGet(), "Post one"),
            new Post(counter.incrementAndGet(), "Post two"), new Post(counter.incrementAndGet(), "Post three"),
            new Post(counter.incrementAndGet(), "Post four")));


    public boolean delete(Long id) {
        boolean isRemoved = this.posts.removeIf(post -> post.getId().equals(id));
        return isRemoved;
    }

    public Set<Post> all() {
        return this.posts;
    }
}
