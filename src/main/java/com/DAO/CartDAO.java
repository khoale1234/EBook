package com.DAO;
import java.util.List;

import com.entity.Book_dtls;
import com.entity.Cart;
public interface CartDAO {
	public boolean CartAdd(Cart c);
	public List<Cart> getBookByUser(int userid);
	public boolean deleteBook(int bid,int uid, int cid);
}
