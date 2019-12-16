package business;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import beans.Order;
import beans.User;

@Local
/**
 * 
 * @author noah canepa
 * test() method shows when this user logs in
 * get Orders() returns a list of orders
 * createOrder(Order order); add a new order to the database
 * createUser(User User) adds a user to the database
 * deleteOrder(int x) deletes the order from the database based on the id
 * updateOrder(Order order) updates a specified order in the database
 *
 */
public interface LoginBusinessInterface {
	//displays when the user logs in
	public void test();
	//retrieves list of order
	public List<Order> getOrders();
	//adds a new order to the database
	public boolean createOrder(Order order);
	//adds a new user to the database
	public boolean createUser(User user);
	public void setOrders(List<Order> orders);
	//deletes a order from the database
	public boolean deleteOrder(int x);
	//updates an order in the database
	public boolean updateOrder(Order order);
}