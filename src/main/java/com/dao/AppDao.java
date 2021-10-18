package com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Blog;
@Repository
public interface AppDao extends CrudRepository<Blog, Integer> {

}
