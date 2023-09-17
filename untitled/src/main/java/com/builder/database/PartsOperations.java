package com.builder.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PartsOperations implements DatabaseOperations{


    static void create(Parts part){
        try (Connection con = DBConnect.getConnection();) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO \"Parts\" (psp_num, volume, size, leadTime) VALUES (?,?,?,?)");
            ps.setString(1, part.getPsp_num());
            ps.setDouble(2, part.getVolume());
            ps.setString(3, part.getSize());
            ps.setInt(4, part.getLeadTime());
            ps.executeUpdate();
            //System.out.println("hello");

        } catch (SQLException e) {e.printStackTrace();}
    }


    static void update(Parts part){
        try (Connection con = DBConnect.getConnection();) {
            PreparedStatement ps = con.prepareStatement("UPDATE \"Parts\" SET volume=?, size=?, leadtime=? WHERE psp_num=\'" + part.getPsp_num() + "\'");

            ps.setDouble(1, part.getVolume());
            ps.setString(2, part.getSize());
            ps.setInt(3, part.getLeadTime());
            ps.executeUpdate();

        } catch (SQLException e) { e.printStackTrace(); }
    }

    static boolean exists(Parts part){
        try (Connection con = DBConnect.getConnection();) {
            PreparedStatement ps = con.prepareStatement("SELECT EXISTS(SELECT 1 FROM \"Parts\" WHERE psp_num = \'" + part.getPsp_num() + "\')");
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getBoolean(1);

        } catch (SQLException e) {e.printStackTrace();}
        return false;
    }

    static void read(Parts part){
        try (Connection con = DBConnect.getConnection();) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM \"Parts\" WHERE psp_num=\'"+part.getPsp_num()+"\'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                part.setSize(rs.getString(2));
                part.setVolume(rs.getDouble(3));
            }
        } catch (SQLException e) {e.printStackTrace();}
    }

    static void delete(Parts part){
        try (Connection con = DBConnect.getConnection();) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM \"Parts\" WHERE psp_num = \'" + part.getPsp_num() + "\'");
            ps.executeUpdate();
        } catch (SQLException e) {e.printStackTrace();}
    }


    public static void main(String args[]){
        Parts p = new Parts("PSP123456","Small Box",150);
        create(p);
        update(p);
        read(p);
        exists(p);
        delete(p);
    }
}
