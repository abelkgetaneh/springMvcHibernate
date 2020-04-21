package com.abelkbde.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abelkbde.springmvc.model.Book;
import com.abelkbde.springmvc.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	// Get all the books
	@GetMapping("/api/book")
	public ResponseEntity<List<Book>> findAllBooks() {
		List<Book> listOfBooks = bookService.findAllBooks();
		return ResponseEntity.ok().body(listOfBooks);

	}

	// Save a Book
	@PostMapping("/api/book")
	public ResponseEntity<?> saveBook(@RequestBody Book book) {
		bookService.saveBook(book);
		return ResponseEntity.ok().body("Book created with id: " + book.getId());

	}

	// Get a Book
	@GetMapping("/api/book/{id}")
	public ResponseEntity<Book> findBook(@PathVariable("id") int id) {
		Book book = bookService.findBook(id);
		return ResponseEntity.ok().body(book);

	}

	// Update a Book
	@PutMapping("/api/book/{id}")
	public ResponseEntity<?> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
		bookService.updateBook(book, id);
		return ResponseEntity.ok().body("Book has been updated with id: " + book.getId());

	}

	// Save a Book
	@DeleteMapping("/api/book/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable("id") int id) {
		bookService.deleteBook(id);
		return ResponseEntity.ok().body("Book has been deleted.");

	}
}
