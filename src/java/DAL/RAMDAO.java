/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Context.DBContext;
import Model.RAM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zarius
 */
public class RAMDAO {

    public RAM getRAMByID(int ramID) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM `ram` where `RAM_ID` = " + ramID + ";";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    RAM ram = new RAM();
                    ram.setRamID(rs.getInt(1));
                    ram.setRamName(rs.getString(2));
                    ram.setPrice(rs.getInt(3));
                    ram.setStatus(rs.getBoolean(4));
                    return ram;
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

    public List<RAM> getAllRAMActive() {
        List<RAM> rams = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                String sql = "SELECT * FROM `ram` where `status` = 1";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    RAM ram = new RAM();
                    ram.setRamID(rs.getInt(1));
                    ram.setRamName(rs.getString(2));
                    ram.setPrice(rs.getInt(3));
                    ram.setStatus(rs.getBoolean(4));
                    rams.add(ram);
                }
                rs.close();
                ps.close();
                con.close();
            }
            return rams;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<RAM> getAllRAM() {
        ArrayList<RAM> listRAM = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM `ram`";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    RAM ram = new RAM();
                    ram.setRamID(rs.getInt(1));
                    ram.setRamName(rs.getString(2));
                    ram.setPrice(rs.getInt(3));
                    ram.setStatus(rs.getBoolean(4));
                    listRAM.add(ram);
                }
                rs.close();
                st.close();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listRAM;
    }
}
