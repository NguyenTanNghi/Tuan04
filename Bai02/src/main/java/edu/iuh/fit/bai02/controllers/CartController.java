package edu.iuh.fit.bai02.controllers;

import edu.iuh.fit.bai02.daos.PhoneDAO;
import edu.iuh.fit.bai02.daos.impl.PhoneDAOImpl;
import edu.iuh.fit.bai02.etities.PhoneCart;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "cartController", urlPatterns = {"/cart", "/cart*"})
public class CartController extends HttpServlet {
    @Resource(name = "jdbc/shopphone")
    private DataSource dataSource;

    private PhoneDAO phoneDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.phoneDAO = new PhoneDAOImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";

        switch(action) {
            case "buy":
                handleAddToCart(req, resp);
                break;
            case "remove":
                handleRemoveFromCart(req, resp);
                break;
            default:
                handleShowCart(req, resp);
                break;
        }
    }

    private void handleShowCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/cart/index.jsp").forward(req, resp);
    }

    private void handleAddToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<PhoneCart> cart = null;

        if (session.getAttribute("cart") == null) {
            cart = new ArrayList<>();
        } else {
            cart = (List<PhoneCart>) session.getAttribute("cart");
        }

        int index = findProductIndex(Integer.parseInt(req.getParameter("id")), cart);
        if (index == -1) {
            cart.add(new PhoneCart(phoneDAO.getById(Integer.parseInt(req.getParameter("id"))), 1));
        } else {
            int quantity = cart.get(index).getQuantity() + 1;
            cart.get(index).setQuantity(quantity);
        }
        session.setAttribute("cart", cart);

        resp.sendRedirect("cart");
    }
    private void handleRemoveFromCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<PhoneCart> cart = (List<PhoneCart>) session.getAttribute("cart");
        int index = findProductIndex(Integer.parseInt(req.getParameter("id")), cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        resp.sendRedirect("cart");
    }

    private int findProductIndex(int id, List<PhoneCart> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getPhone().getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
