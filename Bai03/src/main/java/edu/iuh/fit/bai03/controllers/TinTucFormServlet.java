package edu.iuh.fit.bai03.controllers;
import edu.iuh.fit.bai03.daos.DanhMucDAO;
import edu.iuh.fit.bai03.daos.TinTucDAO;
import edu.iuh.fit.bai03.entities.TinTuc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/them-tin-tuc")
public class TinTucFormServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DanhMucDAO dmDAO = new DanhMucDAO();
        request.setAttribute("listDM", dmDAO.getAllDanhMuc());
        request.getRequestDispatcher("views/TinTucForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Thiết lập encoding UTF-8 để xử lý tiếng Việt
        request.setCharacterEncoding("UTF-8");

        // Lấy dữ liệu từ form
        String maTT = request.getParameter("maTT");
        String tieuDe = request.getParameter("tieuDe");
        String lienKet = request.getParameter("lienKet");
        String noiDung = request.getParameter("noiDungTT");
        String maDM = request.getParameter("maDM");

        // Tạo đối tượng TinTuc từ dữ liệu nhận được
        TinTuc tinTuc = new TinTuc(maTT, tieuDe, noiDung, lienKet, maDM);

        // Gọi DAO để thêm vào cơ sở dữ liệu
        TinTucDAO tinTucDAO = new TinTucDAO();
        tinTucDAO.addTinTuc(tinTuc);

        // Chuyển hướng (redirect) về trang danh sách tin tức để tránh lỗi F5 (gửi lại form)
        // Đây là pattern Post-Redirect-Get (PRG)
        response.sendRedirect(request.getContextPath() + "/quan-ly");
    }
}