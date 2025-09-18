package edu.iuh.fit.bai02.controllers;

import edu.iuh.fit.bai02.daos.PhoneDAO;
import edu.iuh.fit.bai02.daos.impl.PhoneDAOImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "productController", urlPatterns = "/phones")
public class PhoneController extends HttpServlet {
    @Resource(name = "jdbc/shopphone")
    private DataSource dataSource;

    private PhoneDAO phoneDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.phoneDAO = new PhoneDAOImpl(this.dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("phones", phoneDAO.findAll());
        req.getRequestDispatcher("views/phones/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
