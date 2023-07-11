/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author admin
 */

import Context.DBContext;
import Model.Feedback;
import Model.FeedbackDashboard;
import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class FeedbackDAO {
    public ArrayList<Feedback> getProductFeedback(int productID) {
        ArrayList<Feedback> listFeedback = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM `feedback` WHERE product_ID = " + productID + " and Status = 1;";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Feedback f = new Feedback();
                    f.setFeedbackId(rs.getInt(1));
                    f.setUserId(rs.getInt(2));
                    f.setProductId(rs.getInt(3));
                    f.setCreateDate(rs.getDate(4));
                    f.setContent(rs.getString(5));
                    f.setImage(rs.getString(6));
                    f.setRating(rs.getDouble(7));
                    f.setStatus(rs.getBoolean(8));
                    listFeedback.add(f);
                }
                rs.close();
                st.close();
                con.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listFeedback;
    }

    public Map<Integer, Integer> getStarByProductID(ArrayList<Product> productList) {
        Map<Integer, Integer> listStar = new HashMap<>();
        DBContext db = new DBContext();
        int productID;
        double rating;
        try {
            Connection con = db.getConnection();
            if (con != null) {
                String sql = "SELECT Product_ID, AVG(Rating) AS average_rating FROM `feedback` WHERE Product_ID = ? and `status` = 1;";
                PreparedStatement st = con.prepareStatement(sql);
                for (Product product : productList) {
                    st.setInt(1, product.getProductID());
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        productID = rs.getInt("Product_ID");
                        rating = rs.getDouble("average_rating");
                        listStar.put(productID, (int) rating);
                    }
                    rs.close();
                }
                st.close();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listStar;
    }

    public Integer getStarByProductID(int productID) {
        DBContext db = new DBContext();
        double rating;
        try {
            Connection con = db.getConnection();
            if (con != null) {
                String sql = "SELECT Product_ID, AVG(Rating) AS average_rating FROM `feedback` WHERE `Product_ID` = ? and `status` = 1;";
                PreparedStatement st = con.prepareStatement(sql);
                st.setInt(1, productID);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    rating = rs.getDouble("average_rating");
                    return (int)rating;
                }
                rs.close();
                st.close();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public Integer getTotalFeedback(int productID) {
        DBContext db = new DBContext();
        int totalFeedback;
        try {
            Connection con = db.getConnection();
            if (con != null) {
                String sql = "SELECT Count(*) as totalFeedback FROM `feedback` WHERE `Product_ID` = ? and `status` = 1;";
                PreparedStatement st = con.prepareStatement(sql);
                st.setInt(1, productID);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    totalFeedback = rs.getInt("totalFeedback");
                    return totalFeedback;
                }
                rs.close();
                st.close();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public ArrayList<Feedback> getFeedback() {
        ArrayList<Feedback> listFeedback = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "select * from `feedback`;";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Feedback f = new Feedback();
                    f.setFeedbackId(rs.getInt(1));
                    f.setUserId(rs.getInt(2));
                    f.setProductId(rs.getInt(3));
                    f.setCreateDate(rs.getDate(4));
                    f.setContent(rs.getString(5));
                    f.setImage(rs.getString(6));
                    f.setRating(rs.getDouble(7));
                    f.setStatus(rs.getBoolean(8));
                    listFeedback.add(f);
                }
                rs.close();
                st.close();
                con.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listFeedback;
    }
    
    
//    public ArrayList<Feedback> getFeedbackByStatus0() {
//        ArrayList<Feedback> listFeedback = new ArrayList<>();
//        try {
//            DBContext db = new DBContext();
//            Connection con = db.getConnection();
//            if (con != null) {
//                Statement st = con.createStatement();
//                String sql = "select * from `feedback` where status = 0;";
//                ResultSet rs = st.executeQuery(sql);
//                while (rs.next()) {
//                    Feedback f = new Feedback();
//                    f.setFeedbackId(rs.getInt(1));
//                    f.setUserId(rs.getInt(2));
//                    f.setProductId(rs.getInt(3));
//                    f.setCreateDate(rs.getDate(4));
//                    f.setContent(rs.getString(5));
//                    f.setImage(rs.getString(6));
//                    f.setRating(rs.getDouble(7));
//                    f.setStatus(rs.getBoolean(8));
//                    listFeedback.add(f);
//                }
//                rs.close();
//                st.close();
//                con.close();
//            }
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return listFeedback;
//    }
//    
//    
//    
//    public ArrayList<Feedback> getFeedbackByStatus1() {
//        ArrayList<Feedback> listFeedback = new ArrayList<>();
//        try {
//            DBContext db = new DBContext();
//            Connection con = db.getConnection();
//            if (con != null) {
//                Statement st = con.createStatement();
//                String sql = "select * from `feedback` where status = 1;";
//                ResultSet rs = st.executeQuery(sql);
//                while (rs.next()) {
//                    Feedback f = new Feedback();
//                    f.setFeedbackId(rs.getInt(1));
//                    f.setUserId(rs.getInt(2));
//                    f.setProductId(rs.getInt(3));
//                    f.setCreateDate(rs.getDate(4));
//                    f.setContent(rs.getString(5));
//                    f.setImage(rs.getString(6));
//                    f.setRating(rs.getDouble(7));
//                    f.setStatus(rs.getBoolean(8));
//                    listFeedback.add(f);
//                }
//                rs.close();
//                st.close();
//                con.close();
//            }
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return listFeedback;
//    }
    
    //get details for feedback onclick with id
    public Feedback getFeedbackDetails(String feedbackId) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "select * from `feedback` where `Feedback_ID` =" +feedbackId+";";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Feedback f = new Feedback();
                    f.setFeedbackId(rs.getInt(1));
                    f.setUserId(rs.getInt(2));
                    f.setProductId(rs.getInt(3));
                    f.setCreateDate(rs.getDate(4));
                    f.setContent(rs.getString(5));
                    f.setImage(rs.getString(6));
                    f.setRating(rs.getDouble(7));
                    f.setStatus(rs.getBoolean(8));
                    
                    return f;
                }
                rs.close();
                st.close();
                con.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    //get feedback details via Feedback_ID
    public ArrayList<Feedback> getFeedbackWithId(String feedbackId) {
        ArrayList<Feedback> listFeedback = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "select * from `feedback` where `Feedback_ID` = " +feedbackId+ ";";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Feedback f = new Feedback();
                    f.setFeedbackId(rs.getInt(1));
                    f.setUserId(rs.getInt(2));
                    f.setProductId(rs.getInt(3));
                    f.setCreateDate(rs.getDate(4));
                    f.setContent(rs.getString(5));
                    f.setImage(rs.getString(6));
                    f.setRating(rs.getDouble(7));
                    f.setStatus(rs.getBoolean(8));
                    listFeedback.add(f);
                }
                rs.close();
                st.close();
                con.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listFeedback;
    }
    
    //for dashboard info
    public ArrayList<FeedbackDashboard> getFeedbackDashboardInfo() {
        ArrayList<FeedbackDashboard> listFeedback = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                FeedbackDashboard f = new FeedbackDashboard();
                String sql = "select count(Feedback_ID) from `feedback`;";               
                String sql2 = "select count(status) from `feedback` where status =0;";               
                String sql3 = "select count(User_ID) from `user` where Role_ID =1;";              
                String sql4 = "select avg(Rating) from `feedback`;";
                
                
                ResultSet rs = st.executeQuery(sql);
                rs.next();
                f.setTotalFeedback(rs.getInt(1));
                
                rs = st.executeQuery(sql2);
                rs.next();
                f.setNotResolve(rs.getInt(1));
                
                rs = st.executeQuery(sql3);
                rs.next();
                f.setTotalCustomer(rs.getInt(1));
                
                rs = st.executeQuery(sql4);
                rs.next();
                f.setAverageRating(Math.round(rs.getDouble(1)*100.0)/100.0);
                
                
                        
                
                listFeedback.add(f);
                   
                    
                rs.close();
                st.close();
                con.close();


            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listFeedback;
    }
    public Map<Integer, String> getUserNameByID(ArrayList<Feedback> listFeedback) {
        Map<Integer, String> listUserName = new HashMap<>();
        DBContext db = new DBContext();
        String userName;
        int userID;
        try {
            Connection con = db.getConnection();
            if (con != null) {
                String sql = "Select * FROM `user` WHERE `User_ID` = ?;";
                PreparedStatement st = con.prepareStatement(sql);
                for (Feedback feedback : listFeedback) {
                    st.setInt(1, feedback.getUserId());
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        userID = rs.getInt("User_ID");
                        userName = rs.getString("Fullname");
                        listUserName.put(userID, userName);
                    }
                    rs.close();
                }
                st.close();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listUserName;
    }
    
    public Map<Integer, String> getProductNameByID(ArrayList<Feedback> listFeedback) {
        Map<Integer, String> listProductName = new HashMap<>();
        DBContext db = new DBContext();
        String productName;
        int productID;
        try {
            Connection con = db.getConnection();
            if (con != null) {
                String sql = "Select * FROM `product` WHERE `Product_ID` = ?;";
                PreparedStatement st = con.prepareStatement(sql);
                for (Feedback feedback : listFeedback) {
                    st.setInt(1, feedback.getProductId());
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        productID = rs.getInt("Product_ID");
                        productName = rs.getString("Product_Name");
                        listProductName.put(productID, productName);
                    }
                    rs.close();
                }
                st.close();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listProductName;
    }
    
    public Map<Integer, Integer> getStarByFeedbackID(ArrayList<Feedback> listFeedback) {
        Map<Integer, Integer> listStar = new HashMap<>();
        DBContext db = new DBContext();
        int feedbackID;
        double rating;
        try {
            Connection con = db.getConnection();
            if (con != null) {
                String sql = "SELECT *FROM `feedback` WHERE `feedback_id` = ?;";
                PreparedStatement st = con.prepareStatement(sql);
                for (Feedback feedback : listFeedback) {
                    st.setInt(1, feedback.getFeedbackId());
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        feedbackID = rs.getInt("Feedback_ID");
                        rating = rs.getDouble("Rating");
                        listStar.put(feedbackID, (int) rating);
                    }
                    rs.close();
                }
                st.close();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listStar;
    }
    
    public int updateStatusFeedback(int id, int i) {
        int row = 0;
        try {
            String sql = "UPDATE `feedback`\n"
                    + "   SET `status` = ?\n"
                    + " WHERE `feedback_ID` = ?";
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, i);
            st.setInt(2, id);
            row = st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            row = -1;
        }
        return row;
    }
    
    public int createFeedback(int userID, int productID, String content, String image, double rating) {
        int row = 0;
        String sql = "INSERT INTO `feedback` \n"
                + "values (?,?,?,?,?,?,?,'1')";
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setNull(1, Types.INTEGER);
            st.setInt(2, userID);
            st.setInt(3, productID);
            st.setDate(4, new java.sql.Date(System.currentTimeMillis()));
            st.setString(5, content);
            st.setString(6, image);
            st.setDouble(7, rating);
            row = st.executeUpdate();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            row = -1;
        }
        return row;
    }
}
