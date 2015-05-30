package be.mylabs.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.mylabs2.entities.Book;

@Stateless
public class BookEJB /* implements BookEJBLocal */{
	@PersistenceContext(unitName = "myLabs2EE")
	private EntityManager em;

	public Book findBookById(Long id) {
		return em.find(Book.class, id);
	}

	public Book createBook(Book book) {
		em.persist(book);
		return book;
	}

	public Book modifyBook(Book book) {
		em.merge(book);
		return book;
	}

	public List<Book> findAllBooks() {
		Query createNamedQuery = em.createNamedQuery("Book.findAllBooks");
		return createNamedQuery.getResultList();
	}
}
