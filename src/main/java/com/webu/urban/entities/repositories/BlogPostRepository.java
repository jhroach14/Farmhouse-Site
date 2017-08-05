package com.webu.urban.entities.repositories;

import com.webu.urban.entities.BlogPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends CrudRepository<BlogPost,Integer> {



}
