package learn.sankar.webservices.myapp;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import learn.sankar.webservices.database.EmployeeDatabase;
import learn.sankar.webservices.models.Employee;

@Path("/employees")
public class EmployeeResource {
	
	private static EmployeeDatabase empDB = new EmployeeDatabase();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployees(){
		return empDB.getAllEmployees();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{employeeId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Employee updateEmploye(@PathParam("employeeId")Long id, Employee e){
		e.setId(id);
		e = empDB.updateEmployee(e);
		return e;
	}
	
	
	@DELETE
	@Path("{employeeId}")
	public void deleteEmployee(@PathParam("employeeId")Long id){
		empDB.deleteEmployee(id);
	}
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee createEmployee(Employee e, @Context final HttpServletResponse response){
		e = empDB.createEmployee(e);
		response.setStatus(HttpServletResponse.SC_CREATED);
		try {
			response.flushBuffer();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}
	

}
