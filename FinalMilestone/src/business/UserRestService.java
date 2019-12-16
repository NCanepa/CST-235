package business;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.User;

/**
 * 
 * @author noah canepa
 * a rest service that shows the user in a json format
 *
 */
@RequestScoped
@Path("users")
public class UserRestService {
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User saveUser(User user){
		//typically calls a business service to save a user
		System.out.println("Hello " + user.getFirstName() + " " + user.getLastName());
		return user;
	}
}
