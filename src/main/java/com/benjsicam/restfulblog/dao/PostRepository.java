package com.benjsicam.restfulblog.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.benjsicam.restfulblog.domain.Author;
import com.benjsicam.restfulblog.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {	
	@Query
	List<Post> findByAuthor(Author author);
	
	@Query
	List<Post> findByDate(Date date);
	
	@Query("SELECT post.id, post.date, post.content FROM Post post JOIN post.categories category WHERE category.id=?1")
	List<Post> findPostsByCategoryId(Long id);
	
	@Query("SELECT post.author FROM Post post WHERE post.id=?1")
	Author findPostAuthor(Long id);
}
