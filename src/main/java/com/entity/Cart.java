package com.entity;

public class Cart {
private int cid;
private int bid;
private int uid;
private String bookName;
private String author;
private Double price;
private Double total_price;
public Cart() {
	super();
	// TODO Auto-generated constructor stub
}
public Cart(int cid, int bid, int uid, String bookName, String author, Double price, Double total_price) {
	super();
	this.cid = cid;
	this.bid = bid;
	this.uid = uid;
	this.bookName = bookName;
	this.author = author;
	this.price = price;
	this.total_price = total_price;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public int getBid() {
	return bid;
}
public void setBid(int bid) {
	this.bid = bid;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
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
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public Double getTotal_price() {
	return total_price;
}
public void setTotal_price(Double total_price) {
	this.total_price = total_price;
}
@Override
public String toString() {
	return "Cart [cid=" + cid + ", bid=" + bid + ", uid=" + uid + ", bookName=" + bookName + ", author=" + author
			+ ", price=" + price + ", total_price=" + total_price + "]";
}

}
