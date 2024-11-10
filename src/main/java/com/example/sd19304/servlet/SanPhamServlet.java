package com.example.sd19304.servlet;

import com.example.sd19304.model.SanPham;
import com.example.sd19304.repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SanPhamServlet", value = {"/SanPhamServlet",
        "/san-pham/hien-thi"
})
public class SanPhamServlet extends HttpServlet {
    SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // hien thi thong tin sau: id, ten san pham, ma san pham,
        // trang thai, ten danh muc cua san pham, ngay tao
        List<SanPham> list = sanPhamRepository.getListSp();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/san_pham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
