package com.abelkbde.springmvc.service;

import java.util.List;

import com.abelkbde.springmvc.model.Book;

public interface BookService {

	int saveBook(Book book);
	
	List<Book> findAllBooks();
	
	void deleteBook(int id);
	
	Book findBook(int id);
	
	void updateBook(Book book, int id);
}
