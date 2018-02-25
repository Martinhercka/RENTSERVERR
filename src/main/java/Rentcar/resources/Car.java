package Rentcar.resources;



import Rentcar.db.MySQL;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Path("/rent")
public class Car
{

    @GET
    @Path("/car/{cars}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCars(@PathParam("cars")String cars) throws SQLException
    {
        System.out.println(cars);
        List <String> list = new MySQL().getCars(cars);


        boolean b = false;

        String result = "getCars({\"cars\":[";
        for (String temp : list) {
            if (b == true) {
                result += ',';
            } else
                b = true;
            result += "\"" + temp + "\"";

        }
        result += "]})";
        return result;


    }
















}
