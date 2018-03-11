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


    @GET
    @Path("/price/{cars}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPrice(@PathParam("cars")String cars) throws SQLException
    {
        System.out.println(cars);
        List <String> list = new MySQL().getPrice(cars);


        boolean b = false;

        String result = "getPrice({\"price\":[";
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





    @GET
    @Path("/perweekprice/{cars}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getWeekPrice(@PathParam("cars")String cars) throws SQLException
    {
        System.out.println(cars);
        List <String> list = new MySQL().getWeekPrice(cars);


        boolean b = false;

        String result = "getWeekPrice({\"PerWeekPrice\":[";
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



    @GET
    @Path("/perweekendprice/{cars}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getWeekendPrice(@PathParam("cars")String cars) throws SQLException
    {
        System.out.println(cars);
        List <String> list = new MySQL().getWeekendPrice(cars);


        boolean b = false;

        String result = "getWeekendPrice({\"PerWeekendPrice\":[";
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
