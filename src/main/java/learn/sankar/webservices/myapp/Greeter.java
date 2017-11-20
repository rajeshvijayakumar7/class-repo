package learn.sankar.webservices.myapp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/greeter")
public class Greeter {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String greet(){
		return "Hello Human!";
	}
	
	@GET
	@Path("/{person}")
	@Produces(MediaType.TEXT_PLAIN)
	public String greetPerson(@PathParam("person")String person){
		return "Hello "+person+"!";
	}
	

}
