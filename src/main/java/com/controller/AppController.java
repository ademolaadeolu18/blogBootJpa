package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Blog;

import com.service.BlogServiceImpl;

@RestController
@RequestMapping("/mainapp")

public class AppController {
	

	@Autowired
	private BlogServiceImpl service;
	
	
	@PostMapping("/save")
	public String savedBlog(@RequestBody Blog blog) {
		service.saveBlog(blog);
		return "blog saved";
	}
	
	@GetMapping("/getall")
	public List<Blog> getAll(){
		return service.getAllBlogs();
	}
	
	@GetMapping("/getbyid/{id}")
	public Optional getBlogById(@RequestBody Blog blog, @PathVariable("id") int id) {
		return service.getBlogById(id);
	}
	
	
	
	@DeleteMapping("/deleteblog/{id}")
	public String deleteBlog(@PathVariable("id")int id) {
		service.deleteBlog(id);
		return "user deleted";

}
	
	@PutMapping("/updateblog/{id}")
	public String updateUser(@RequestBody Blog blog,   @PathVariable("id")int id) {
		service.updateBlog(blog, id);
		
		return "blog updated";
	}
}
