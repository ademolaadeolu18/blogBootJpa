package com.service;

import java.util.List;
import java.util.Optional;

import com.model.Blog;

public interface BlogService {
	public Blog saveBlog(Blog blog);
	public List<Blog>getAllBlogs();
	public Optional getBlogById(int id);
	public Blog deleteBlog(int id);
	public Blog updateBlog(Blog blog, int blogid);

}
