package com.abelkbde.springmvc.dao;

import java.util.List;

import com.abelkbde.springmvc.model.Book;

public interface BookDao {

	int saveBook(Book book);
	
	List<Book> findAllBooks();
	
	void deleteBook(int id);
	
	Book findBook(int id);
	
	void updateBook(Book book, int id);
}
