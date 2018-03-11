package Rentcar.db;

import Rentcar.resources.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQL {

    private Connection conn;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/car_rent";
    private String userName = "root";
    String password = "";


    public List<String> getCars(String category) throws SQLException {
        List<String> list = new ArrayList<String>();
        try {
            Class.forName(driver).newInstance();

            conn = DriverManager.getConnection(url, userName, password);
            String query = "SELECT cars from cars where category like '" + category + "'";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String cat = rs.getString("cars");

                list.add(cat);


                System.out.println(cat);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }


        return list;

    }



    public  void insertOrder(Order order) {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, userName, password);

            String query = "INSERT INTO orders(fname,lname,email,PickPlace,DeliveryPlace,IDCN,contactNum,Car,PickDate,PickTime,DelivDate,DelivTime,Notes) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1,order.firstname);
            ps.setString(2,order.lastname);
            ps.setString(3,order.email);
            ps.setString(4,order.pickPlace);
            ps.setString(5,order.deliverPlace);
            ps.setString(6,order.idCardNumber);
            ps.setString(7,order.number);
            ps.setString(8,order.choosenCar);
            ps.setString(9,order.pickdate);
            ps.setString(10,order.picktime);
            ps.setString(11,order.deliverdate);
            ps.setString(12,order.delivertime);
            ps.setString(13,order.notes);

            ps.executeUpdate();

            }catch(Exception e){
            e.printStackTrace();
        }

    }




    public List<String> getPrice(String car) throws SQLException {
        List<String> list = new ArrayList<String>();
        try {
            Class.forName(driver).newInstance();

            conn = DriverManager.getConnection(url, userName, password);
            String query = "SELECT price from cars where Cars like '" +car+"%"+"%"+ "'";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String cat = rs.getString("price");

                list.add(cat);


                System.out.println(cat);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }


        return list;

    }


    public List<String> getWeekPrice(String car) throws SQLException {
        List<String> list = new ArrayList<String>();
        try {
            Class.forName(driver).newInstance();

            conn = DriverManager.getConnection(url, userName, password);
            String query = "SELECT perWeekPrice from cars where Cars like '" +car+"%"+"%"+ "'";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String cat = rs.getString("perweekprice");

                list.add(cat);


                System.out.println(cat);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }


        return list;

    }

    public List<String> getWeekendPrice(String car) throws SQLException {
        List<String> list = new ArrayList<String>();
        try {
            Class.forName(driver).newInstance();

            conn = DriverManager.getConnection(url, userName, password);
            String query = "SELECT perWeekendPrice from cars where Cars like '" +car+"%"+"%"+ "'";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String cat = rs.getString("perweekendprice");

                list.add(cat);


                System.out.println(cat);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }


        return list;

    }



}