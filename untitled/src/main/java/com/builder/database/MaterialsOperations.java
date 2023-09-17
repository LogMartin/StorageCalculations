package com.builder.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class MaterialsOperations implements DatabaseOperations {

    static void create(Projects project) {
        try (Connection con = DBConnect.getConnection();) {
            HashMap <String,Integer> map = project.getMaterials();
            for (var entry : map.entrySet()) {
                PreparedStatement ps = con.prepareStatement("Insert INTO \"Materials\" (project, part, quantity) VALUES (?,?,?)");
                ps.setString(1, project.getName());
                ps.setString(2, entry.getKey());
                ps.setInt(3, entry.getValue());
                ps.executeUpdate();
            }
        } catch (SQLException e) {e.printStackTrace();}
    }


    static void update(Projects project){
        MaterialsOperations.delete(project);
        MaterialsOperations.create(project);
    }
    static boolean exists(Projects project){
        try (Connection con = DBConnect.getConnection();) {
            PreparedStatement ps = con.prepareStatement("SELECT EXISTS(SELECT 1 FROM \"Materials\" WHERE project = \'" + project.getName() + "\')");
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getBoolean(1);

        } catch (SQLException e) {e.printStackTrace();}
        return false;
    }
    static void read(Projects project){
        try (Connection con = DBConnect.getConnection();) {
            //project.resetMaterials();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM \"Materials\" WHERE project=\'"+project.getName()+"\'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                project.addMaterial(rs.getString(2),rs.getInt(3));
            }
        } catch (SQLException e) {e.printStackTrace();}
    }

    static void delete(Projects project){
        try (Connection con = DBConnect.getConnection();) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM \"Materials\" WHERE project=\'"+project.getName()+"\'");
            ps.executeUpdate();
        } catch (SQLException e) {e.printStackTrace();}
    }

    public static void main(String args[]){
        Projects project = new Projects("TI-50",150);
        for(int i=0; i<10; i++){
            project.addMaterial("TI-"+Integer.toString(i*10),i);
        }
        create(project);
        read(project);
        update(project);
        exists(project);
        delete(project);

    }
}
