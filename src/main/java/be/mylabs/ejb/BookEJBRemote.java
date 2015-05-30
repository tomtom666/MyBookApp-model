package be.mylabs.ejb;

import javax.ejb.Remote;

import be.mylabs2.entities.Book;

@Remote
public interface BookEJBRemote {
	public Book findBookById(Long id);

	public Book createBook(Book book);
}
