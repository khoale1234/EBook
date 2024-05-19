package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Book_Order;

public class BookOrderImp implements BookOrderDAO{
	private Connection connection;

	public BookOrderImp(Connection connection) {
		super();
		this.connection = connection;
	}
	@Override
	public boolean saveOrder(List<Book_Order> blist) {
		boolean f=false;
		try {
			String sql = "INSERT INTO `order` (orderid, user_name, email, address, phone, book_name, author, price, payment) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			connection.setAutoCommit(false);
			PreparedStatement ps= connection.prepareStatement(sql);
			for(Book_Order b:blist) {
				ps.setString(1, b.getOrderid());
				ps.setString(2,b.getUserName() );
				ps.setString(3,b.getEmail() );
				ps.setString(4,b.getFullAddress() );
				ps.setString(5,b.getPhone_no() );
				ps.setString(6,b.getBookName() );
				ps.setString(7,b.getAuthor() );
				ps.setString(8,b.getPrice() );
				ps.setString(9,b.getPaymentMethod() );
				ps.addBatch();
			}
			int[] count=ps.executeBatch();
			connection.commit();
			f=true;
			connection.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	@Override
	public List<Book_Order> getBook(String email) {
		List<Book_Order> list= new ArrayList<Book_Order>();
		Book_Order o= null;
		try {
			String sql = "SELECT * FROM `order` WHERE email=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				o= new Book_Order();
				o.setId(rs.getInt(1));
				o.setOrderid(rs.getString(2));
				o.setUserName(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setFullAddress(rs.getString(5));
				o.setPhone_no(rs.getString(6));
				o.setBookName(rs.getString(7));
				o.setAuthor(rs.getString(8));
				o.setPrice(rs.getString(9));
				o.setPaymentMethod(rs.getString(10));
				list.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Book_Order> getAllOrder() {
		List<Book_Order> list= new ArrayList<Book_Order>();
		Book_Order o= null;
		try {
			String sql = "SELECT * FROM `order`";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				o= new Book_Order();
				o.setId(rs.getInt(1));
				o.setOrderid(rs.getString(2));
				o.setUserName(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setFullAddress(rs.getString(5));
				o.setPhone_no(rs.getString(6));
				o.setBookName(rs.getString(7));
				o.setAuthor(rs.getString(8));
				o.setPrice(rs.getString(9));
				o.setPaymentMethod(rs.getString(10));
				list.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
