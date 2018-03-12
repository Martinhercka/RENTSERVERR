package Rentcar.resources;

import Rentcar.db.MySQL;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/information")
public class Order2 {
    @POST
    @Path("/new")
    @Produces(MediaType.APPLICATION_JSON)
    public String insertInfo(Order order) {

        MySQL mysql = new MySQL();
        mysql.insertOrder(order);


        return "{}";

    }
}
