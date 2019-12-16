package data;

import java.sql.SQLException;
import java.util.List;

import beans.User;

/**
 * interface for dataAccess
 * creates method studs to be implemented in JelloDataService
 */
public interface DataAccessInterface <T>
{
	//finds all orders in the database
	public List<T> findAll();
	public T findById(int id);
	//creates an Order
	public boolean create(T t);
	//creates a User
	public boolean createUser(User user);
	public boolean updateOrder(T t);
	//deletes a Order from the database, based on the Order Number
	public boolean delete(int x);
}