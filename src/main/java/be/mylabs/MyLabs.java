package be.mylabs;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import be.mylabs2.entities.Address;
import be.mylabs2.entities.Book;
import be.mylabs2.entities.Customer;
import be.mylabs2.entities.NewsID;
import be.mylabs2.entities.NewsWithEmbeddableID;
import be.mylabs2.entities.NewsWithIdClass;

public class MyLabs {

	private static String[] names = { "GoodWay", "Balloc", "Barak", "Poutine" };

	private static String[] firstnames = { "Mike", "John", "Piet", "Tom" };

	private static String[] langs = { "en", "fr", "de", "es" };

	private static int index = 0;

	public static void main(String[] args) {
		List<Customer> customers = createMyCustomers();
		List<Book> books = createMyBooks();
		List<Address> addresses = createMyAdresses();
		List<NewsWithEmbeddableID> newsList = createMyNewsWithEmbeddable();
		List<NewsWithIdClass> newsWithIdClasses = createNewsWithIdClass();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myLabs2SE");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		for (Customer customer : customers) {
			entityManager.persist(customer);
		}
		for (Address address : addresses) {
			entityManager.persist(address);
		}
		for (Book book : books) {
			entityManager.persist(book);
		}
		for (NewsWithEmbeddableID news : newsList) {
			entityManager.persist(news);
		}
		for (NewsWithIdClass news : newsWithIdClasses) {
			entityManager.persist(news);
		}
		transaction.commit();
		Query createNamedQuery = entityManager.createNamedQuery("Customer.findAll");
		List<Customer> resultList = createNamedQuery.getResultList();
		for (Customer customer2 : resultList) {
			System.err.println("Customer : " + customer2.getFirstname() + " " + customer2.getLastname());
		}
		entityManager.close();
		entityManagerFactory.close();

	}

	private static List<NewsWithIdClass> createNewsWithIdClass() {
		List<NewsWithIdClass> newsList = new ArrayList<NewsWithIdClass>();
		NewsWithIdClass newsWithIdClass = new NewsWithIdClass();
		newsWithIdClass.setContent("This is a real interesting news2");
		newsWithIdClass.setLang(langs[index]);
		newsWithIdClass.setTitle("Intresting2");
		newsList.add(newsWithIdClass);

		return newsList;
	}

	private static List<NewsWithEmbeddableID> createMyNewsWithEmbeddable() {
		List<NewsWithEmbeddableID> newsList = new ArrayList<NewsWithEmbeddableID>();

		NewsWithEmbeddableID news = new NewsWithEmbeddableID();
		NewsID newsID = new NewsID();
		newsID.setLang(langs[index]);
		newsID.setTitle("Intresting");
		news.setId(newsID);
		news.setContent("This is a real interesting news");
		newsList.add(news);

		return newsList;
	}

	private static List<Address> createMyAdresses() {
		List<Address> addresses = new ArrayList<Address>();
		Address address = new Address();
		address.setStreet("Guillaume Van Haelen");
		address.setNumber(46);
		address.setCity("Bruxelles");
		address.setCountry("Belgique");

		addresses.add(address);

		return addresses;
	}

	private static List<Book> createMyBooks() {
		List<Book> books = new ArrayList<Book>();
		Book book = new Book();
		book.setTitle("The java EE cookbook");
		book.setDescription("This is a good book");
		book.setIsbn("#AZE1852557541");
		book.setNbOfPages(360);
		book.setPrice(30.25f);
		books.add(book);

		return books;
	}

	private static List<Customer> createMyCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		int i = 0;
		for (String name : names) {
			for (String firstname : firstnames) {
				Customer customer = new Customer();
				// customer.setCustid(i);
				customer.setLastname(name);
				customer.setFirstname(firstname);
				customers.add(customer);
				i++;
			}
		}

		return customers;
	}

}
