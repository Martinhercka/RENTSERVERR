package Rentcar.resources;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Credentials
{
    @JsonProperty("username")
    public String username;

    @JsonProperty("password")
    public String password;

    @JsonProperty("token")
    public String token;


    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }


}
