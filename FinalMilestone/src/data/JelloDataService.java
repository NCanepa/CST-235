package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.Order;
import beans.User;


@Stateless
@Local(DataAccessInterface.class)
@LocalBean
/**
 * this class is used for data methods that will make changes to the database
 * @author noah canepa
 *
 */
public class JelloDataService implements DataAccessInterface<Order> {
	//parameters used to connect to the database
	String url = "jdbc:mysql://localhost:3306/milestone";
	String username = "root";
	String password = "root";
	
	/*
     * Default constructor. 
     */
    public JelloDataService() {}
    
    /*
     * CRUD methods
     */
	@Override
	/*
	 * connects to the table Order from the database then retrieves every value
	 */
	public List<Order> findAll() {
		String sql = "SELECT * FROM milestone.ORDER";
    	Connection conn = null;
    	List<Order> orders = new ArrayList<Order>();
    	try {
    		//Connect to the Database
    		try {
    			conn = DriverManager.getConnection(url, username, password);
    			System.out.println("Success");
    		}
    		catch(SQLException e) {
    			System.out.println("Failure");
    		}
    		
    		//Execute SQL Query
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
    		//while there is still items add them to orders
    		while(rs.next()) {
    			orders.add(new Order(rs.getInt("ORDERNUMBER"),
    					rs.getString("JELLOFLAVOR"),
    					rs.getString("JELLOSIZE"),
    					rs.getFloat("PRICE"),
    					rs.getInt("QUANTITY")));
    		}
    		rs.close();
    	}
    	catch (SQLException e){
    		e.printStackTrace();
    	}
    	finally {
    		if(conn != null){
    			try {
    				conn.close();
    			}
    			catch(SQLException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    	return orders;
    }

	@Override
	public Order findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * connects to the database, then inserts the given values into the ORDER table
	 */
	@Override
	public boolean create(Order order) {
		Connection conn = null;
		String sql = String.format("INSERT INTO milestone.ORDER(JELLOFLAVOR, JELLOSIZE, PRICE, QUANTITY)VALUES('%s', '%s', %f, %d)",
									order.getJelloFlavor(),
									order.getJelloSize(),
									order.getPrice(),
									order.getQuantity());
			
	    try {
	    	//Connect to the Database
	    	conn = DriverManager.getConnection(url, username, password);
	    		
	    	//Execute SQL Query
	    	Statement stmt = conn.createStatement();
	    	//Really should check the return value from executeUpdate()
	    	stmt.executeUpdate(sql);
	    }
	    catch (SQLException e){
	    	e.printStackTrace();
	    }
	    finally {
	    	if(conn != null){
	    		try {
	    			conn.close();
	    		}
	    		catch(SQLException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    }
			return true;
	}
	
	/*
	 * connects to the database, then inserts the given values into the USER table
	 */
	@Override
	public boolean createUser(User user) {
		Connection conn = null;
		String sql = String.format("INSERT INTO milestone.USERS(FIRSTNAME, LASTNAME, EMAIL, PHONE, USERNAME, PASSWORD)VALUES('%s', '%s', '%s', '%s','%s','%s')",
									user.getFirstName(),
									user.getLastName(),
									user.getEmail(),
									user.getPhoneNumber(),
									user.getUsername(),
									user.getPassword());
			
	    try {
	    	//Connect to the Database
	    	conn = DriverManager.getConnection(url, username, password);
	    		
	    	//Execute SQL Query
	    	Statement stmt = conn.createStatement();
	    	//Really should check the return value from executeUpdate()
	    	stmt.executeUpdate(sql);
	    }
	    catch (SQLException e){
	    	e.printStackTrace();
	    }
	    finally {
	    	if(conn != null){
	    		try {
	    			conn.close();
	    		}
	    		catch(SQLException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    }
			return true;
	}
	
	@Override
	public boolean updateOrder(Order t) {
		Connection conn = null;
    	PreparedStatement stmt = null;
    	
    	try {
    		//Connect to the Database
	    	conn = DriverManager.getConnection(url, username, password);
	    		
	    	//Execute SQL Query
	    	//Statement stmt = conn.createStatement();
	    	stmt = conn.prepareStatement("UPDATE milestone.ORDER set JelloFlavor = ?, JelloSize = ?, Price = ?, Quantity = ? where OrderNumber = ?");
	    	
	    	
        	stmt.setString(1, t.getJelloFlavor());
        	stmt.setString(2, t.getJelloSize());
        	stmt.setDouble(3, t.getPrice());
        	stmt.setInt(4, t.getQuantity());
        	stmt.setInt(5, t.getOrderNo());
	    	//Really should check the return value from executeUpdate()
	    	stmt.executeUpdate();
	    }
	    catch (SQLException e){
	    	e.printStackTrace();
	    }
    	finally {
	    	if(conn != null){
	    		try {
	    			conn.close();
	    		}
	    		catch(SQLException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    }
		return true;
	}

	/*
	 * connects to the database and deletes the selected Order based on the order number
	 */
	@Override
	public boolean delete(int x) {
		Connection conn = null;
		String sql ="DELETE FROM milestone.ORDER WHERE ORDERNUMBER = " + x;
	
			
	    try {
	    	//Connect to the Database
	    	conn = DriverManager.getConnection(url, username, password);
	    		
	    	//Execute SQL Query
	    	Statement stmt = conn.createStatement();
	    	//Really should check the return value from executeUpdate()
	    	stmt.executeUpdate(sql);
	    }
	    catch (SQLException e){
	    	e.printStackTrace();
	    }
	    finally {
	    	if(conn != null){
	    		try {
	    			conn.close();
	    		}
	    		catch(SQLException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    }
			return true;
	}
}
