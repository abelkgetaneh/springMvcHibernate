package com.abelkbde.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abelkbde.springmvc.model.Book;

@Repository
public class BookDaoImpl implements BookDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int saveBook(Book book) {
		sessionFactory.getCurrentSession().save(book);
		return book.getId();
		
	}

	@Override
	public List<Book> findAllBooks() {
		
		List<Book> books = sessionFactory.getCurrentSession().createQuery("from Book").list();
		
		return books;
		
	}

	@Override
	public void deleteBook(int id) {
		Session session = sessionFactory.getCurrentSession();
		Book theBook = session.byId(Book.class).load(id);
		session.delete(theBook);
		
	}

	@Override
	public Book findBook(int id) {
		return sessionFactory.getCurrentSession().get(Book.class, id);
	}

	@Override
	public void updateBook(Book book, int id) {
		Session session = sessionFactory.getCurrentSession();
		Book theBook = session.byId(Book.class).load(id);
		theBook.setId(book.getId());
		theBook.setAuthor(book.getAuthor());
		theBook.setTitle(book.getTitle());
		theBook.setYear(book.getYear());
		theBook.setPrice(book.getPrice());
		theBook.setPublisher(book.getPublisher());
		session.flush();
	}

}
