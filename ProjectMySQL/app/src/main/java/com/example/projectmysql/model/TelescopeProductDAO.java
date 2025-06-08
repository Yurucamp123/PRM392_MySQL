package com.example.projectmysql.model;

import com.example.projectmysql.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TelescopeProductDAO {
    public ArrayList<TelescopeProduct> getAll() {
        ArrayList<TelescopeProduct> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM telescope_products";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(resultToProduct(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public TelescopeProduct getById(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM telescope_products WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return resultToProduct(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insert(TelescopeProduct p) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO telescope_products (product_name, model, original_price, discounted_price, tube_length_cm, focal_length_mm, weight_kg, aperture_mm, eyepieces, additional_info) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            fillStatement(p, stmt);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(TelescopeProduct p) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE telescope_products SET product_name = ?, model = ?, original_price = ?, discounted_price = ?, tube_length_cm = ?, focal_length_mm = ?, weight_kg = ?, aperture_mm = ?, eyepieces = ?, additional_info = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            fillStatement(p, stmt);
            stmt.setInt(11, p.id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM telescope_products WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillStatement(TelescopeProduct p, PreparedStatement stmt) throws SQLException {
        stmt.setString(1, p.productName);
        stmt.setString(2, p.model);
        stmt.setInt(3, p.originalPrice);
        stmt.setInt(4, p.discountedPrice);
        stmt.setFloat(5, p.tubeLengthCm);
        stmt.setInt(6, p.focalLengthMm);
        stmt.setFloat(7, p.weightKg);
        stmt.setInt(8, p.apertureMm);
        stmt.setString(9, p.eyepieces);
        stmt.setString(10, p.additionalInfo);
    }

    private TelescopeProduct resultToProduct(ResultSet rs) throws SQLException {
        return new TelescopeProduct(
                rs.getInt("id"),
                rs.getString("product_name"),
                rs.getString("model"),
                rs.getInt("original_price"),
                rs.getInt("discounted_price"),
                rs.getFloat("tube_length_cm"),
                rs.getInt("focal_length_mm"),
                rs.getFloat("weight_kg"),
                rs.getInt("aperture_mm"),
                rs.getString("eyepieces"),
                rs.getString("additional_info")
        );
    }
}