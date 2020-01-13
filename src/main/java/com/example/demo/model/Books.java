package com.example.demo.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int bookID;
	private String title;

	@ManyToMany
	@JoinTable(
			name = "books_authors",
			joinColumns = @JoinColumn(name = "book_id"),
			inverseJoinColumns = @JoinColumn(name = "author_id"))
	private List<Authors> authors;

	@ManyToOne
	@JoinColumn(name="publisher_id")
	private Publishers publisher;

	private String isbn;
	private String genre;
	private int year;
	private double price;
	private int stock;

	public Publishers getPublisher() {
		return publisher;
	}

	public void setPublisher(Publishers publisher) {
		this.publisher = publisher;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Books books = (Books) o;
		return bookID == books.bookID &&
				year == books.year &&
				Double.compare(books.price, price) == 0 &&
				stock == books.stock &&
				Objects.equals(title, books.title) &&
				Objects.equals(authors, books.authors) &&
				Objects.equals(publisher, books.publisher) &&
				Objects.equals(isbn, books.isbn) &&
				Objects.equals(genre, books.genre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookID, title, authors, publisher, isbn, genre, year, price, stock);
	}
/*
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Books books = (Books) o;
		return year == books.year &&
				title.equals(books.title) &&
				Objects.equals(isbn, books.isbn) &&
				Objects.equals(genre, books.genre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, isbn, genre, year);
	}*/

	public List<Authors> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Authors> authors) {
		this.authors = authors;
	}



}