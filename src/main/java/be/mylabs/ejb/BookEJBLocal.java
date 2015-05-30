package be.mylabs.ejb;

import javax.ejb.Local;

import be.mylabs2.entities.Book;

@Local
public interface BookEJBLocal {
	public Book findBookById(Long id);

	public Book createBook(Book book);
}
