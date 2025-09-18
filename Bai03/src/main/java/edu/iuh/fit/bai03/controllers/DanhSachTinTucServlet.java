package edu.iuh.fit.bai03.controllers;

import edu.iuh.fit.bai03.daos.DanhMucDAO;
import edu.iuh.fit.bai03.daos.TinTucDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/danh-sach-tin-tuc")
public class DanhSachTinTucServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DanhMucDAO dmDAO = new DanhMucDAO();
        TinTucDAO ttDAO = new TinTucDAO();

        // Lấy danh sách danh mục để đổ vào dropdown
        request.setAttribute("listDM", dmDAO.getAllDanhMuc());

        String maDM = request.getParameter("maDM");
        if (maDM != null && !maDM.isEmpty()) {
            request.setAttribute("listTT", ttDAO.getTinTucByDanhMuc(maDM));
            request.setAttribute("selectedDM", maDM);
        }

        request.getRequestDispatcher("views/DanhSachTinTuc.jsp").forward(request, response);
    }
}