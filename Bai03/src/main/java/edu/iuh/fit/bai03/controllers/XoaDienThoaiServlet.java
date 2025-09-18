package edu.iuh.fit.bai03.controllers;

import edu.iuh.fit.bai03.daos.DienThoaiDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/xoa-dien-thoai")
public class XoaDienThoaiServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maDT = request.getParameter("maDT");
        if (maDT != null) {
            DienThoaiDAO dtDAO = new DienThoaiDAO();
            dtDAO.deleteDienThoai(maDT);
        }
        response.sendRedirect("quan-ly");
    }
}