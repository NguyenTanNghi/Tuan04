package edu.iuh.fit.bai03.daos;

import edu.iuh.fit.bai03.DatabaseConnection;
import edu.iuh.fit.bai03.entities.NhaCungCap;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAO {

    // Lấy danh sách tất cả các nhà cung cấp
    public List<NhaCungCap> getAllNhaCungCap() {
        List<NhaCungCap> list = new ArrayList<>();
        String sql = "SELECT MANCC, TENNHACC, DIACHI, SODIENTHOAI FROM NHACUNGCAP";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap(
                        rs.getString("MANCC"),
                        rs.getString("TENNHACC"),
                        rs.getString("DIACHI"),
                        rs.getString("SODIENTHOAI")
                );
                list.add(ncc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, rs);
        }
        return list;
    }

    // Tìm kiếm nhà cung cấp theo từ khóa
    public List<NhaCungCap> searchNhaCungCap(String keyword) {
        List<NhaCungCap> list = new ArrayList<>();
        String sql = "SELECT * FROM NHACUNGCAP WHERE MANCC LIKE ? OR TENNHACC LIKE ? OR DIACHI LIKE ? OR SODIENTHOAI LIKE ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement(sql);
            String searchKeyword = "%" + keyword + "%";
            ps.setString(1, searchKeyword);
            ps.setString(2, searchKeyword);
            ps.setString(3, searchKeyword);
            ps.setString(4, searchKeyword);

            rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap(
                        rs.getString("MANCC"),
                        rs.getString("TENNHACC"),
                        rs.getString("DIACHI"),
                        rs.getString("SODIENTHOAI")
                );
                list.add(ncc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, rs);
        }
        return list;
    }

    private void closeResources(Connection conn, PreparedStatement ps, ResultSet rs) {
        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
}