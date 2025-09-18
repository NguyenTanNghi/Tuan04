package edu.iuh.fit.bai03.daos;

import edu.iuh.fit.bai03.DatabaseConnection;
import edu.iuh.fit.bai03.entities.DienThoai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DienThoaiDAO {

    // Lấy danh sách tất cả điện thoại (cho trang quản lý)
    public List<DienThoai> getAllDienThoai() {
        List<DienThoai> list = new ArrayList<>();
        String sql = "SELECT MADT, TENDT, NAMSANXUAT, CAUHINH, MANCC, HINHANH FROM DIENTHOAI";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DienThoai dt = new DienThoai(
                        rs.getString("MADT"),
                        rs.getString("TENDT"),
                        rs.getInt("NAMSANXUAT"),
                        rs.getString("CAUHINH"),
                        rs.getString("MANCC"),
                        rs.getString("HINHANH")
                );
                list.add(dt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, rs);
        }
        return list;
    }

    // Lấy danh sách điện thoại theo mã nhà cung cấp
    public List<DienThoai> getDienThoaiByNCC(String maNCC) {
        List<DienThoai> list = new ArrayList<>();
        String sql = "SELECT MADT, TENDT, NAMSANXUAT, CAUHINH, MANCC, HINHANH FROM DIENTHOAI WHERE MANCC = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maNCC);
            rs = ps.executeQuery();
            while (rs.next()) {
                DienThoai dt = new DienThoai(
                        rs.getString("MADT"),
                        rs.getString("TENDT"),
                        rs.getInt("NAMSANXUAT"),
                        rs.getString("CAUHINH"),
                        rs.getString("MANCC"),
                        rs.getString("HINHANH")
                );
                list.add(dt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, rs);
        }
        return list;
    }

    // Thêm một điện thoại mới vào cơ sở dữ liệu
    public void addDienThoai(DienThoai dt) {
        String sql = "INSERT INTO DIENTHOAI (MADT, TENDT, NAMSANXUAT, CAUHINH, MANCC, HINHANH) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, dt.getMaDT());
            ps.setString(2, dt.getTenDT());
            ps.setInt(3, dt.getNamSanXuat());
            ps.setString(4, dt.getCauHinh());
            ps.setString(5, dt.getMaNCC());
            ps.setString(6, dt.getHinhAnh());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, null);
        }
    }

    // Xóa một điện thoại khỏi cơ sở dữ liệu dựa trên mã ĐT
    public void deleteDienThoai(String maDT) {
        String sql = "DELETE FROM DIENTHOAI WHERE MADT = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maDT);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, null);
        }
    }

    // Phương thức trợ giúp để đóng tài nguyên
    private void closeResources(Connection conn, PreparedStatement ps, ResultSet rs) {
        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
}