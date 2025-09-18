package edu.iuh.fit.bai03.controllers;

import edu.iuh.fit.bai03.daos.DienThoaiDAO;
import edu.iuh.fit.bai03.daos.NhaCungCapDAO;
import edu.iuh.fit.bai03.entities.DienThoai;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet("/them-dien-thoai")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50
)
public class DienThoaiFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhaCungCapDAO nccDAO = new NhaCungCapDAO();
        request.setAttribute("listNCC", nccDAO.getAllNhaCungCap());
        request.getRequestDispatcher("views/DienThoaiForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String maDT = request.getParameter("maDT");
        String tenDT = request.getParameter("tenDT");
        int namSanXuat = Integer.parseInt(request.getParameter("namSanXuat"));
        String cauHinh = request.getParameter("cauHinh");
        String maNCC = request.getParameter("maNCC");

        Part part = request.getPart("hinhAnh");
        String fileName = extractFileName(part);
        String savePath = getServletContext().getRealPath("/") + "images";

        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        part.write(savePath + File.separator + fileName);

        DienThoai dt = new DienThoai(maDT, tenDT, namSanXuat, cauHinh, maNCC, fileName);
        DienThoaiDAO dtDAO = new DienThoaiDAO();
        dtDAO.addDienThoai(dt);

        response.sendRedirect("danh-sach-ncc");
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}