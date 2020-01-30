package com.example.demo;

import java.util.Set;

/**
 * @author Petr Janik 485122
 * @since 31/07/2019
 */
public interface IPostService {
    boolean delete(Long id);
    Set<Post> all();
}
