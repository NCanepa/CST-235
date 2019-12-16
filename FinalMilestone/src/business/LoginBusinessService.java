package business;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import beans.Order;
import beans.User;
import data.DataAccessInterface;

/**
 * 
 * @author noah canepa
 * Session Bean implementation class LoginBusinessService
 * test() method shows when this user logs in
 * get Orders() returns a list of orders
 * createOrder(Order order); add a new order to the database
 * createUser(User User) adds a user to the database
 * deleteOrder(int x) deletes the order from the database based on the id
 * updateOrder(Order order) updates a specified order in the database
 */
@Stateless
@Local(LoginBusinessInterface.class)
@Alternative
public class LoginBusinessService implements LoginBusinessInterface {
	@Inject
	DataAccessInterface<Order> orderDataService;
	
	public LoginBusinessService() {}
	
	//when the user either signs in or registers a message is displayed in the console
    public void test() {
        System.out.println("User Successfully logged in");
    }
    
    //gets all the orders from the database
    public List<Order> getOrders() {
		return orderDataService.findAll();
	}
    //creates an order and adds it to the database
    public boolean createOrder(Order order) {
    	orderDataService.create(order);
		return true;
	}
    
    //deletes an Order From the database
    public boolean deleteOrder(int x) {
    	orderDataService.delete(x);
		return true;
	}
    
    //creates a user and adds them to the database
    @Override
	public boolean createUser(User user) {
		orderDataService.createUser(user);
		return true;
	}
    
	@Override
	public void setOrders(List<Order> orders) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateOrder(Order order) {
		orderDataService.updateOrder(order);
		return false;
	}
}