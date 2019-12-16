package business;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Order;
/**
 * uses rest services to return the orders created in a json format
 * @author noah canepa
 *
 */
@RequestScoped
@Path("/orders")
public class JelloRestService {
	@Inject
	LoginBusinessInterface service;
	
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Order> getOrderAsJson(){
		return service.getOrders();
	}
}
