package Rentcar.resources;

import com.fasterxml.jackson.annotation.JsonProperty;



public class Order
{





    @JsonProperty("pickplace")
    public String pickPlace;
    @JsonProperty("deliverplace")
    public String deliverPlace;
    @JsonProperty("firstname")
    public String firstname;
    @JsonProperty("lastname")
    public String lastname;
    @JsonProperty("email")
    public String email;
    @JsonProperty("number")
    public String number;
    @JsonProperty("idcardnumber")
    public String idCardNumber;
    @JsonProperty("notes")
    public String notes;
    @JsonProperty("choosenCar")
    public String choosenCar;
    @JsonProperty("pickdate")
    public String pickdate;
    @JsonProperty("picktime")
    public String picktime;
    @JsonProperty("deliverdate")
    public String deliverdate;
    @JsonProperty("delivertime")
    public String delivertime;




}
