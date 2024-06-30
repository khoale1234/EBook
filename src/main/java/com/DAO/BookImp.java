package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Book_dtls;
import com.mysql.cj.protocol.Resultset;

public class BookImp implements BookDAO {
	private Connection connection;
	
	public BookImp(Connection connection) {
		super();
		this.connection = connection;
	}

	 public boolean AddBook(Book_dtls b) {
	        boolean created = false;
	        PreparedStatement ps = null;
	        
	        try {
	        	String sql = "INSERT INTO bookdtls (bookname, author, price, bookCategory, status, photo,email) VALUES (?, ?, ?, ?, ?, ?, ?)";
	            ps = connection.prepareStatement(sql);
	            ps.setString(1, b.getBookName());
	            ps.setString(2, b.getAuthor());
	            ps.setString(3, b.getPrice());
	            ps.setString(4, b.getBookCategory());
	            ps.setString(5, b.getStatus());
	            ps.setString(6, b.getPhotoName());
	            ps.setString(7, b.getEmail());
	            
	            int i = ps.executeUpdate();
	            if (i == 1) {
	                created = true;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close PreparedStatement in finally block to ensure it's always closed
	            if (ps != null) {
	                try {
	                    ps.close();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        return created;
	    }

	@Override
	public List<Book_dtls> getAllBook() {
		List<Book_dtls> list=new ArrayList<Book_dtls>();
		Book_dtls b=null;
		try {
			String sql="Select * from bookdtls";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				b=new Book_dtls();
				b.setBookID(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
//				System.out.println(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Book_dtls getBookbyId(int id) {
		Book_dtls b=null;
		try {
			String sql="select * from bookdtls where bookId=?";
			PreparedStatement ps= connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				b= new Book_dtls();
				b.setBookID(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEmail(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean UpdateEditBook(Book_dtls b) {
		boolean update=false;
		try {
			String sql="update bookdtls set bookname=?, author=?, price=?, status=? where bookId=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1,b.getBookName());
			ps.setString(2,b.getAuthor());
			ps.setString(3,b.getPrice());
			ps.setString(4,b.getStatus());
			ps.setInt(5, b.getBookID());
			int i=ps.executeUpdate();
			if(i==1) {
				update=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return update;
	}

	@Override
	public boolean DeleteBook(int id) {
		boolean update=false;
		try {
			String sql="Delete from bookdtls where bookId=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i==1) {
				update=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return update;
	}

	@Override
	public List<Book_dtls> getNewBook() {
		List<Book_dtls> list= new ArrayList<Book_dtls>();
		Book_dtls b=null;
		try {
			String sql="Select * from bookdtls where bookCategory=? and status=? order by bookId DESC";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, "New Book");
			ps.setString(2, "Active");
			ResultSet rs=ps.executeQuery();
			int i=1;
			while(rs.next()&& i<=4) {
				b=new Book_dtls();
				b.setBookID(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Book_dtls> getRecentBook() {
		List<Book_dtls> list= new ArrayList<Book_dtls>();
		Book_dtls b=null;
		try {
			String sql="Select * from bookdtls where status=? order by bookId DESC";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, "Active");
			ResultSet rs=ps.executeQuery();
			int i=1;
			while(rs.next()&& i<=4) {
				b=new Book_dtls();
				b.setBookID(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Book_dtls> getOldBook() {
		List<Book_dtls> list= new ArrayList<Book_dtls>();
		Book_dtls b=null;
		try {
			String sql="Select * from bookdtls where bookCategory=? and status=? order by bookId DESC";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, "Old Book");
			ps.setString(2, "Active");
			ResultSet rs=ps.executeQuery();
			int i=1;
			while(rs.next()&& i<=4) {
				b=new Book_dtls();
				b.setBookID(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Book_dtls> getAllRecentBook() {
		List<Book_dtls> list= new ArrayList<Book_dtls>();
		Book_dtls b=null;
		try {
			String sql="Select * from bookdtls where status=? order by bookId DESC";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, "Active");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				b=new Book_dtls();
				b.setBookID(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Book_dtls> getAllNewBook() {
		List<Book_dtls> list= new ArrayList<Book_dtls>();
		Book_dtls b=null;
		try {
			String sql="Select * from bookdtls where bookCategory=? and status=? order by bookId DESC";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, "New Book");
			ps.setString(2, "Active");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				b=new Book_dtls();
				b.setBookID(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Book_dtls> getAllOldBook() {
		List<Book_dtls> list= new ArrayList<Book_dtls>();
		Book_dtls b=null;
		try {
			String sql="Select * from bookdtls where bookCategory=? and status=? order by bookId DESC";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, "Old Book");
			ps.setString(2, "Active");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				b=new Book_dtls();
				b.setBookID(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Book_dtls> getBookByOld(String email, String category) {
		List<Book_dtls> list= new ArrayList<Book_dtls>();
		Book_dtls b=null;
		try {
			String sql="select * from bookdtls where bookCategory=? and email=?";
			PreparedStatement ps= connection.prepareStatement(sql);
			ps.setString(1, category);
			ps.setString(2, email);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				b=new Book_dtls();
				b.setBookID(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean oldBookDelete(String email, String category,int bid) {
		boolean f=false;
		try {
			String sql="delete from bookdtls where bookCategory=? and email=? and bookId=?";
			PreparedStatement ps= connection.prepareStatement(sql);
			ps.setString(1, category);
			ps.setString(2, email);
			ps.setInt(3, bid);
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public List<Book_dtls> getBookSearch(String search) {
		
		List<Book_dtls> list= new ArrayList<Book_dtls>();
		Book_dtls b=null;
		try {
			String sql="select * from bookdtls where bookname like ? or author like ? or bookCategory like ? and status=?";
			PreparedStatement ps= connection.prepareStatement(sql);
			ps.setString(1,"%"+search+"%");
			ps.setString(2,"%"+search+"%");
			ps.setString(3,"%"+search+"%");
			ps.setString(4,"Active");
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				b=new Book_dtls();
				b.setBookID(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
