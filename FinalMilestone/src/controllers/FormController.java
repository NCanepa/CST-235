//Noah Canepa
package controllers;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Order;
import beans.User;
import business.LoginBusinessInterface;
/**
 * 
 * @author noah canepa
 * mostly just redirects users from page to page
 * also has instances of implementing business logic when certain buttons are pressed
 * such as adding orders or users to the database
 *
 */
@ManagedBean
public class FormController {
	
	//injects the EJB for user login
	@Inject
	LoginBusinessInterface service;
	
	/**
	 * sign in and Register redirect
	 * @return Response.xhtml
	 */
	public String onSubmit() {
		service.test();
		//retrieves user values
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		//put user into Post request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		//show next page
		return "Response.xhtml";
	}
	
	
	/**
	 * goes to register page
	 * @return Register.xhtml
	 */
	public String onRegister() {
		//retrieves user values
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		//put user into Post request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		//show next page
		return "Register.xhtml";
	}
	
	/**
	 * used to create a new user
	 * @param user this is the user that has just had it's information filled out
	 * @return Finish.xhtml
	 */
	public String onFinish(User user) {
		service.createUser(user);
		//put user into Post request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		//show next page
		return "Finish.xhtml";
	}
	
	/**
	 * 
	 * @return DeleteProduct.xhtml
	 */
	public String onDeleteProduct() {
		//show next page
		return "DeleteProduct.xhtml";
	}
	
	/**
	 * 
	 * @param x the id number associated with the order to be deleted
	 * @return Response.xhtml
	 */
	public String onDelete(int x) {
		//deletes the selected ID from the database
		service.deleteOrder(x);
		//show next page
		return "Response.xhtml";
	}
	
	/**
	 * used for the current user to sign out of the program
	 * @return login-form.xhtml
	 */
	public String onLoginAgain() {
		//retrieves user values
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		//put user into Post request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		//show next page
		return "login-form.xhtml";
	}
	
	/**
	 * used to send user to Add product page
	 * @return AddProduct.xhmtl
	 */
	public String onAddProduct() {
		//show next page
		return "AddProduct.xhtml";
	}
	
	/**
	 * used to send user to Update Product Page
	 * @return UpdateProduct.xhtml
	 */
	public String onUpdateProduct() {
		//show next page
		return "UpdateProduct.xhtml";
	}
	
	/**
	 * sends user back to Response page
	 * @return Response.xhtml
	 */
	public String onReturnToOrders() {
		//retrieves user values
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		//put user into Post request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		//show next page
		return "Response.xhtml";
	}
	
	/**
	 *  gets information from user and uploads it to the database
	 * @param order the order to be created
	 * @return Response.xhtml
	 */
	public String onConfirmOrder(Order order) {
		//show adds order to database
		service.createOrder(order);
		//show next page
		return "Response.xhtml";
	}
	

	/**
	 * gets information from user to make a change to an order
	 * @param order the order to be changed
	 * @return Response.xhtml
	 */
	public String onConfirmUpdateOrder(Order order) {
		//changes order in database
		service.updateOrder(order);
		//show next page
		return "Response.xhtml";
	}
	
	/**
	 * used to use service logic in the class
	 * @return service
	 */
	public LoginBusinessInterface getService() {
		return service;
	}
}