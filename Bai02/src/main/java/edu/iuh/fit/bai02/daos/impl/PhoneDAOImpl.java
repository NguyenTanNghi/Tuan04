package edu.iuh.fit.bai02.daos.impl;

import edu.iuh.fit.bai02.daos.PhoneDAO;
import edu.iuh.fit.bai02.etities.Phone;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAOImpl implements PhoneDAO {

    private final DataSource datasource;

    public PhoneDAOImpl(DataSource dataSource) {
        this.datasource = dataSource;
    }

    @Override
    public List<Phone> findAll() {
        String sql = "select id, name, price, image from phone";

        List<Phone> list = new ArrayList<>();
        try (
                Connection con = (Connection) this.datasource.getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                String image = rs.getString("image");
                list.add(new Phone(id, name, price, image));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Phone getById(int id) {
        String sql = "SELECT id, name, price, image FROM phone WHERE id=?";
        Phone p = null;
        try (
                Connection con = (Connection) this.datasource.getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    String image = rs.getString("image");
                    p = new Phone(id, name, price, image);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void addPhone(Phone phone) {
        String sql = "INSERT INTO product (name, price, image) VALUES (?,?,?)";
        try (
                Connection con = (Connection) this.datasource.getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ) {
            ps.setString(1, phone.getName());
            ps.setDouble(2, phone.getPrice());
            ps.setString(3, phone.getImage());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
