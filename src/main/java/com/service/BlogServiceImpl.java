package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AppDao;

import com.model.Blog;


@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private AppDao appDao;
	ArrayList<Blog> al = new ArrayList<Blog>();
	@Override
	public Blog saveBlog(Blog blog) {
		appDao.save(blog);
		return blog;
	}

	@Override
	public List<Blog> getAllBlogs() {
		List<Blog> al = (List<Blog>) appDao.findAll();
		return al;
	}

	@Override
	public Optional getBlogById(int id) {
		Optional<Blog> op = appDao.findById(id);
		if(op.isPresent()) {
			return op;
			}
				
		
		return null;
	}

	@Override
	public Blog deleteBlog(int id) {
		Optional<Blog> op = appDao.findById(id);
		if(op.isPresent()) {
			appDao.deleteById(id);
			}
		
		return null;
	}

	@Override
	public Blog updateBlog(Blog blog, int blogid) {
		Optional<Blog> op = appDao.findById(blogid);
		if(op.isPresent()) {
			appDao.deleteById(blogid);
			appDao.save(blog);
				
			}
		return null;
	}

}
