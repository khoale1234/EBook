package com.entity;

public class Book_dtls {
	private int bookID;
	private String bookName;
	private String author;
	private String Price;
	private String bookCategory;
	private String status;
	private String photoName;
	private String email;
	
	public Book_dtls() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book_dtls(String bookName, String author, String price, String bookCategory, String status,
			String photoName, String email) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.Price = price;
		this.bookCategory = bookCategory;
		this.status = status;
		this.photoName = photoName;
		this.email = email;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Book_dtls [bookID=" + bookID + ", bookName=" + bookName + ", author=" + author + ", Price=" + Price
				+ ", bookCategory=" + bookCategory + ", status=" + status + ", photoName=" + photoName + ", email="
				+ email + "]";
	}
	
}
