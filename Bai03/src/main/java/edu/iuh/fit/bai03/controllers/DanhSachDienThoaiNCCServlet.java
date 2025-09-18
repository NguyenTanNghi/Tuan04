package edu.iuh.fit.bai03.controllers;

import edu.iuh.fit.bai03.daos.DienThoaiDAO;
import edu.iuh.fit.bai03.daos.NhaCungCapDAO;
import edu.iuh.fit.bai03.entities.DienThoai;
import edu.iuh.fit.bai03.entities.NhaCungCap;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/danh-sach-ncc")
public class DanhSachDienThoaiNCCServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhaCungCapDAO nccDAO = new NhaCungCapDAO();
        DienThoaiDAO dtDAO = new DienThoaiDAO();
        List<NhaCungCap> listNCC = nccDAO.getAllNhaCungCap();

        String maNCC = request.getParameter("maNCC");
        List<DienThoai> listDT = null;

        if (maNCC != null && !maNCC.isEmpty()) {
            listDT = dtDAO.getDienThoaiByNCC(maNCC);
        } else {
            listDT = dtDAO.getAllDienThoai();
        }

        request.setAttribute("listNCC", listNCC);
        request.setAttribute("listDT", listDT);
        request.setAttribute("selectedNCC", maNCC);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/DanhSachDienThoaiNCC.jsp");
        dispatcher.forward(request, response);
    }
}