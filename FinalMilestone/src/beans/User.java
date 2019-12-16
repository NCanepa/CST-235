//Noah Canepa
package beans;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * used to Implement a user Object
 * @author noah canepa
 * @param firstName the first name of this user
 * @param LastName last name of this user
 * @param email this user's email
 * @param phoneNumber this user's phone number
 * @param username the username this user wishes to use
 * @param password the password this user wishes to user
 */
@ManagedBean
public class User {
	//data validation for all the User Credentials, min and max number of Characters
	@NotNull(message = "Please enter a First Name. This is a required field.")
	@Size(min=2, max=15)
	private String firstName;
	@NotNull(message = "Please enter a Last Name. This is a required field.")
	@Size(min=2, max=15)
	private String lastName;
	@NotNull(message = "Please enter a Email. This is a required field.")
	@Size(min=4, max=50)
	private String email;
	@NotNull(message = "Please enter a Phone Number. This is a required field.")
	@Size(min=5, max=15)
	private String phoneNumber;
	@NotNull(message = "Please enter a Username. This is a required field.")
	@Size(min=4, max=15)
	private String username;
	@NotNull(message = "Please enter a Password. This is a required field.")
	@Size(min=4, max=15)
	private String password;
	
	//getters and setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		firstName = "Michael";
		lastName = "Meyers";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}