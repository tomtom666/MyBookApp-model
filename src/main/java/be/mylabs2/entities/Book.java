package be.mylabs2.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Book
 */
@Entity
@NamedQuery(name = "Book.findAllBooks", query = "Select b from Book b")
@SequenceGenerator(name = "seq_book", initialValue = 1, allocationSize = 100, sequenceName = "Book_seq")
public class Book implements Serializable {

	private Long id;

	private String description;

	private String title;

	private Float price;

	private String isbn;

	private Integer nbOfPages;

	private boolean illustration;

	private byte[] content;

	private Date creationDate;

	private Date releaseDate;

	private static final long serialVersionUID = 1L;

	public Book() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_book")
	/* By default it's the GenerationType.auto that is used. The db choose the best way. With Derby it's the GenerationType.TABLE that is used. Derby stored the sequence in the table sequence (should exist before so relaunch the db schema generation one you add @GeneratedValue */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "BOOK_TITLE", unique = true, updatable = false, nullable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getNbOfPages() {
		return nbOfPages;
	}

	public void setNbOfPages(Integer nbOfPages) {
		this.nbOfPages = nbOfPages;
	}

	@Basic(optional = true)
	/* If illustration is null in db the loading is ignored. Great for primitive value */
	public boolean getIllustration() {
		return illustration;
	}

	public void setIllustration(boolean illustration) {
		this.illustration = illustration;
	}

	@Basic(fetch = FetchType.LAZY)
	@Lob
	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Temporal(TemporalType.DATE)
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

}
