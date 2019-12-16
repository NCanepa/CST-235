//Noah Canepa
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
/**
 * creates an array list of orders
 * has get orders and set orders and an example of what an order would look like
 * @author noah canepa
 *
 */
@ManagedBean
@ViewScoped
public class Jello {
	List <Order> orders = new ArrayList<Order>();

	/*creates a dummy list of orders
	 * has since become absolete since orders are recieved from the database
	 * prefer to keep this hear so I can have an example to look at
	 */
	public Jello() {
//		 orders.add(new Order(0, "Strawberry", "S", (float)1.00, 1));
	 }
	//getter and setter for Order array list
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}