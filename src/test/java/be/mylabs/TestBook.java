package be.mylabs;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import be.mylabs2.entities.Book;

public class TestBook {
	private static EntityManagerFactory emf;

	private static EntityManager em;

	private static EntityTransaction tx;

	@BeforeClass
	public static void initEntityManager() throws Exception {
		emf = Persistence.createEntityManagerFactory("myLabs2Test");
		em = emf.createEntityManager();
	}

	@AfterClass
	public static void closeEntityManager() throws SQLException {
		em.close();
		emf.close();
	}

	@Before
	public void initTransaction() {
		tx = em.getTransaction();
	}

	@Test
	public void createBook() throws Exception {
		// Création d’une instance de Livre
		Book book = new Book();
		book.setTitle("The Hitchhiker’s Guide to the Galaxy");
		book.setPrice(12.5F);
		book.setDescription("Comédie de science fiction");
		book.setIsbn("1-84023-742-2");
		book.setNbOfPages(354);
		// book.setIllustration(false);
		// Stocke le livre dans la base de données
		tx.begin();
		em.persist(book);
		tx.commit();
		// Asser("ID ne doit pas être null", book.getId());
		// Récupère tous les livres de la base de données
		List<Book> books = em.createNamedQuery("Book.findAllBooks").getResultList();
		Assert.assertNotNull(books);
		Book updateBook = books.get(0);
		updateBook.setTitle("Try to update");
		tx.begin();
		em.persist(updateBook);
		tx.commit();
		books = em.createNamedQuery("Book.findAllBooks").getResultList();
		Assert.assertEquals("Try to update", books.get(0).getTitle());
	}
}
