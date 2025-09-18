package edu.iuh.fit.bai03.controllers;

import edu.iuh.fit.bai03.daos.DienThoaiDAO;
import edu.iuh.fit.bai03.entities.DienThoai;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/quan-ly")
public class QuanLyFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DienThoaiDAO dtDAO = new DienThoaiDAO();
        List<DienThoai> listAllDT = dtDAO.getAllDienThoai();
        request.setAttribute("listAllDT", listAllDT);
        request.getRequestDispatcher("views/QuanLyForm.jsp").forward(request, response);
    }
}