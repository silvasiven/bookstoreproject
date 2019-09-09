package hh.swd20.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; 
	private String title;
	private String author;
	private int isbn;
	private int year;
	private int price;
	
	
	public Book() {
		super();
		this.id = null;
		this.title = null;
		this.author = null;
		this.isbn = 0;
		this.year = 0;
		this.price = 0;
	}


	public Book(Long id, String title, String author, int isbn, int year, int price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
		this.price = price;
	}


	public Book(String title, String author, int isbn, int year, int price) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
		this.price = price;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public Long getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}


	public String getAuthor() {
		return author;
	}


	public int getIsbn() {
		return isbn;
	}


	public int getYear() {
		return year;
	}


	public int getPrice() {
		return price;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", year=" + year
				+ ", price=" + price + "]";
	}
	
}



	