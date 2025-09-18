package edu.iuh.fit.bai03.daos;
import edu.iuh.fit.bai03.DatabaseConnection;
import edu.iuh.fit.bai03.entities.TinTuc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TinTucDAO {

    // Lấy tin tức theo mã danh mục
    public List<TinTuc> getTinTucByDanhMuc(String maDM) {
        List<TinTuc> tinTucList = new ArrayList<>();
        String sql = "SELECT * FROM TINTUC WHERE MADM = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maDM);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    TinTuc tt = new TinTuc(
                            rs.getString("MATT"),
                            rs.getString("TIEUDE"),
                            rs.getString("NOIDUNGTT"),
                            rs.getString("LIENKET"),
                            rs.getString("MADM")
                    );
                    tinTucList.add(tt);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tinTucList;
    }

    // Lấy tất cả tin tức (dùng cho trang quản lý)
    public List<TinTuc> getAllTinTuc() {
        List<TinTuc> tinTucList = new ArrayList<>();
        String sql = "SELECT * FROM TINTUC";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                TinTuc tt = new TinTuc(
                        rs.getString("MATT"),
                        rs.getString("TIEUDE"),
                        rs.getString("NOIDUNGTT"),
                        rs.getString("LIENKET"),
                        rs.getString("MADM")
                );
                tinTucList.add(tt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tinTucList;
    }

    // Thêm một tin tức mới
    public void addTinTuc(TinTuc tinTuc) {
        String sql = "INSERT INTO TINTUC(MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tinTuc.getMaTT());
            ps.setString(2, tinTuc.getTieuDe());
            ps.setString(3, tinTuc.getNoiDungTT());
            ps.setString(4, tinTuc.getLienKet());
            ps.setString(5, tinTuc.getMaDM());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa một tin tức
    public void deleteTinTuc(String maTT) {
        String sql = "DELETE FROM TINTUC WHERE MATT = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maTT);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}