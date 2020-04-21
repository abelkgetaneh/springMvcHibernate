package com.abelkbde.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abelkbde.springmvc.dao.BookDao;
import com.abelkbde.springmvc.model.Book;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	@Override
	@Transactional
	public int saveBook(Book book) {
		 bookDao.saveBook(book);
		 return book.getId();
		 
	}

	@Override
	@Transactional
	public List<Book> findAllBooks() {
		return bookDao.findAllBooks();
	}

	@Override
	@Transactional
	public void deleteBook(int id) {
		bookDao.deleteBook(id);
		
	}

	@Override
	@Transactional
	public Book findBook(int id) {
		return bookDao.findBook(id);
	}

	@Override
	@Transactional
	public void updateBook(Book book, int id) {
		bookDao.updateBook(book, id);
		
	}

}
