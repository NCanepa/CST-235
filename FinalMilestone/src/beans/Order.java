//Noah Canepa
package beans;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * this class is used to implement a Order for the Jello store
 * @author noah canepa
 *
 */
@ManagedBean
public class Order {
	//data validation for all the User Credentials, min and max number of Characters
	int orderNo = 0;
	@NotNull(message = "Please enter a Flavor. This is a required field.")
	String jelloFlavor = "";
	@NotNull(message = "Please enter a Size. This is a required field.")
	@Size(min=1, max=2)
	String jelloSize = "";
	@NotNull(message = "Please enter a Price. This is a required field.")
	@DecimalMin("0.00")
	float price = 0;
	@NotNull(message = "Please enter a Quantity. This is a required field.")
	@Min(1)
	int quantity = 0;
	
	//default constructor
	public Order() {}
	
	//sets Order to whatever the variables are set to
	/**
	 * constructor for Orders with specified orderNo, jelloFlavor, jelloSize, price, and quantity.
	 * @param orderNo the order number
	 * @param jelloFlavor the flavor of the jello
	 * @param jelloSize the size ranging from XS (extra small), to XL (extra large)
	 * @param price the price of the jello
	 * @param quantity the amount of jello
	 */
	public Order(int orderNo, String jelloFlavor, String jelloSize, float price, int quantity) {
		this.orderNo = orderNo;
		this.jelloFlavor = jelloFlavor;
		this.jelloSize = jelloSize;
		this.price = price;
		this.quantity = quantity;
	}
	
	//getters and setters
	public String getJelloSize() {
		return jelloSize;
	}

	public void setJelloSize(String jelloSize) {
		this.jelloSize = jelloSize;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getJelloFlavor() {
		return jelloFlavor;
	}

	public void setJelloFlavor(String jelloFlavor) {
		this.jelloFlavor = jelloFlavor;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}