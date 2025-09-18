package edu.iuh.fit.bai03.controllers;
import edu.iuh.fit.bai03.daos.TinTucDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/xoa-tin-tuc")
public class XoaTinTucServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maTT = request.getParameter("maTT");
        if (maTT != null) {
            TinTucDAO ttDAO = new TinTucDAO();
            ttDAO.deleteTinTuc(maTT);
        }
        response.sendRedirect(request.getContextPath() + "/quan-ly");
    }
}