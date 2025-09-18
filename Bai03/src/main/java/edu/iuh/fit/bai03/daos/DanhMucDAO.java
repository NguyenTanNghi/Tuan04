package edu.iuh.fit.bai03.daos;

import edu.iuh.fit.bai03.DatabaseConnection;
import edu.iuh.fit.bai03.entities.DanhMuc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DanhMucDAO {
    public List<DanhMuc> getAllDanhMuc() {
        List<DanhMuc> danhMucList = new ArrayList<>();
        String sql = "SELECT * FROM DANHMUC";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                DanhMuc dm = new DanhMuc();
                dm.setMaDM(rs.getString("MADM"));
                dm.setTenDanhMuc(rs.getString("TENDANHMUC"));
                // set các thuộc tính khác nếu cần
                danhMucList.add(dm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhMucList;
    }
}
