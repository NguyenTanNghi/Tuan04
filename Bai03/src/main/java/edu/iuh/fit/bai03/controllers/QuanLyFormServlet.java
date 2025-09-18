package edu.iuh.fit.bai03.controllers;
import edu.iuh.fit.bai03.daos.DanhMucDAO;
import edu.iuh.fit.bai03.daos.TinTucDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/quan-ly")
public class QuanLyFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TinTucDAO ttDAO = new TinTucDAO();
        request.setAttribute("listAllTT", ttDAO.getAllTinTuc());
        request.getRequestDispatcher("views/QuanLyForm.jsp").forward(request, response);
    }
}