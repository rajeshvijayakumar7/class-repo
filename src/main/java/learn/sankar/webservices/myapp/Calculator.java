package learn.sankar.webservices.myapp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/calculator")
public class Calculator {
	
	
	@Path("/square/{number}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String squares(@PathParam("number")Integer number){
		Integer squares = number*number;
		return squares.toString();
	}

}
