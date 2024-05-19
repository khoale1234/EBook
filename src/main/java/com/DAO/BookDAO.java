package com.DAO;

import java.util.List;

import com.entity.Book_dtls;

public interface BookDAO {
public boolean AddBook(Book_dtls b);
public List<Book_dtls> getAllBook();
public Book_dtls getBookbyId(int id);
public boolean UpdateEditBook(Book_dtls b);
public boolean DeleteBook(int id);
public List<Book_dtls> getNewBook();
public List<Book_dtls> getRecentBook();
public List<Book_dtls> getOldBook();
public List<Book_dtls> getAllRecentBook();
public List<Book_dtls> getAllNewBook();
public List<Book_dtls> getAllOldBook();
public List<Book_dtls> getBookByOld(String email, String category);
public boolean oldBookDelete(String email, String category,int bid);
public List<Book_dtls> getBookSearch(String search);
}
