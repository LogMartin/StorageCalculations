package com.builder.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ProjectsOperations implements DatabaseOperations{

    static void create(Projects project) {
        try (Connection con = DBConnect.getConnection();) {

            PreparedStatement ps = con.prepareStatement("INSERT INTO \"Projects\" (project, installLength) VALUES (?,?)");
            ps.setString(1,project.getName());
            ps.setInt(2,project.getInstallLength());
            ps.executeUpdate();

            HashMap<String, Integer> map = project.getMaterials();


        } catch (SQLException e) { e.printStackTrace(); }
    }


    static void update(Projects project){
        try (Connection con = DBConnect.getConnection();) {
            PreparedStatement ps = con.prepareStatement("UPDATE \"Parts\" SET volume=?, size=?, leadtime=? WHERE psp_num=\'" + project.getName() + "\'");
            MaterialsOperations.update(project);
        } catch (SQLException e){ e.printStackTrace(); }
    }


    static boolean exists(Projects project){
        try (Connection con = DBConnect.getConnection();) { //Sets up connection to database
            PreparedStatement ps = con.prepareStatement(
                    "SELECT EXISTS(SELECT 1 FROM \"Projects\" WHERE project=\'" + project.getName() + "\')");
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getBoolean(1);

        } catch (SQLException e) {e.printStackTrace();}
        return false;
    }

    static void read(Projects project){
        try (Connection con = DBConnect.getConnection();) {
            MaterialsOperations.update(project);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM \"Projects\" WHERE project=\'"+project.getName()+"\'");
            ResultSet rs = ps.executeQuery();
            int i =0;
            rs.next();
            project.setInstallLength(rs.getInt(2));
        } catch (SQLException e) {e.printStackTrace();}
    }
    static void delete(Projects project){
        if (MaterialsOperations.exists(project)) {
            MaterialsOperations.delete(project);
        }
        try (Connection con = DBConnect.getConnection();) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM \"Projects\" WHERE project=\'"+project.getName()+"\'");
            ps.executeUpdate();
        } catch (SQLException e) {e.printStackTrace();}
    }



    public static void main(String args[]){
        Projects project = new Projects("TI-20",150);
        for(int i=0; i<10; i++){
            project.addMaterial("PSP12345"+Integer.toString(i),i);
        }
        create(project);
        read(project);
        update(project);
        exists(project);
        delete(project);

    }

}
