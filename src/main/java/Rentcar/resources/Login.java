package Rentcar.resources;

import Rentcar.db.MySQL;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/auth")
public class Login
{

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkCredentials(Credentials credential){
        System.out.println(credential.getUsername());
        MySQL mySQL = new MySQL();
        User user=mySQL.getUser(credential.username, credential.password);
        if(user==null){
            return Response.status(Response.Status.UNAUTHORIZED).build();

        }
        else{
            String result;
            result="{\"firstname\":\""+user.getFirstname()+"\" , ";
            result+="\"lastname\":\""+user.getLastname()+"\" , ";
            result+="\"email\":\""+user.getEmail()+"\" , ";
            result+="\"login\":\""+user.getLogin()+"\" , ";
            result+="\"token\":\""+user.getToken()+"\"}";
            return Response.ok(result,MediaType.APPLICATION_JSON_TYPE).build();
        }

    }





}
