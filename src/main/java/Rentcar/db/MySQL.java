package Rentcar.db;

import Rentcar.resources.Order;
import Rentcar.resources.User;

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
            String query = "SELECT cars from cars where category like '" + category + "'" + "AND cars.cars not in (select orders.car from orders)";

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


    public void insertOrder(Order order) {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, userName, password);

            String query = "INSERT INTO orders(fname,lname,email,PickPlace,DeliveryPlace,IDCN,contactNum,Car,PickDate,PickTime,DelivDate,DelivTime,Notes) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, order.firstname);
            ps.setString(2, order.lastname);
            ps.setString(3, order.email);
            ps.setString(4, order.pickPlace);
            ps.setString(5, order.deliverPlace);
            ps.setString(6, order.idCardNumber);
            ps.setString(7, order.number);
            ps.setString(8, order.choosenCar);
            ps.setString(9, order.pickdate);
            ps.setString(10, order.picktime);
            ps.setString(11, order.deliverdate);
            ps.setString(12, order.delivertime);
            ps.setString(13, order.notes);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public List<String> getPrice(String car) throws SQLException {
        List<String> list = new ArrayList<String>();
        try {
            Class.forName(driver).newInstance();

            conn = DriverManager.getConnection(url, userName, password);
            String query = "SELECT price from cars where Cars like '" + car + "%" + "%" + "'";
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
            String query = "SELECT perWeekPrice from cars where Cars like '" + car + "%" + "%" + "'";
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
            String query = "SELECT perWeekendPrice from cars where Cars like '" + car + "%" + "%" + "'";
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

    public User getUser(String username, String password) {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, userName, this.password);

            String query = "SELECT * from admin where login like ? and password like ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getString("FName"), rs.getString("LName"), rs.getString("login"), rs.getString("email"));
                query = "UPDATE tokens SET token=? WHERE idu=?";
                ps = conn.prepareStatement(query);
                ps.setString(1, user.getToken());
                ps.setInt(2, rs.getInt("AdminID"));

                ps.executeUpdate();
                System.out.println(ps);
                return user;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<String> getAll(String cars) throws SQLException {
        List<String> list = new ArrayList<String>();
        try {
            Class.forName(driver).newInstance();

            conn = DriverManager.getConnection(url, userName, password);
            String query = "SELECT * FROM ORDERS";

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String pdate = rs.getString(2);
                String pctime = rs.getString(3);
                String ddate = rs.getString(4);
                String dtime = rs.getString(5);
                String pplace = rs.getString(6);
                String dplace = rs.getString(7);
                String fname = rs.getString(8);
                String lname = rs.getString(9);
                String mail = rs.getString(10);
                String connum = rs.getString(11);
                String idcn = rs.getString(12);
                String car = rs.getString(13);
                String notes = rs.getString(14);
                list.add("<table>");
                for(int i=0;i<id.length();i++) {

                    list.add("<tr>");
                    list.add("   ");
                    list.add("<td>"+id+"</td>");
                    list.add("   ");
                    list.add("<td>"+pdate+"</td>");
                    list.add("   ");
                    list.add("<td>"+pctime+"</td>");
                    list.add("   ");
                    list.add("<td>"+ddate+"</td>");
                    list.add("   ");
                    list.add("<td>"+dtime+"</td>");
                    list.add("   ");
                    list.add("<td>"+pplace+"</td>");
                    list.add("   ");
                    list.add("<td>"+dplace+"</td>");
                    list.add("   ");
                    list.add("<td>"+fname+"</td>");
                    list.add("   ");
                    list.add("<td>"+lname+"</td>");
                    list.add("   ");
                    list.add("<td>"+mail+"</td>");
                    list.add("   ");
                    list.add("<td>"+connum+"</td>");
                    list.add("   ");
                    list.add("<td>"+idcn+"</td>");
                    list.add("   ");
                    list.add("<td>"+car+"</td>");
                    list.add("   ");
                    list.add("<td>"+notes+"</td>");
                    list.add("   ");
                    list.add("</tr>");


                }
                list.add("</table>");
            }
            }catch(Exception e){
                e.printStackTrace();
            }
            return list;
        }
    }
