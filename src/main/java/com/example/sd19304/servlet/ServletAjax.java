package com.example.sd19304.servlet;

import com.example.sd19304.model.SanPham;
import com.example.sd19304.model.User;
import com.example.sd19304.repository.SanPhamRepository;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletAjax", value = "/api/ajax")
public class ServletAjax extends HttpServlet {
    SanPhamRepository sanPhamRepository = new SanPhamRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        SanPham sanPham = sanPhamRepository.getDetail(id);
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(sanPham);
        // Đặt kiểu dữ liệu trả về là JSON
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        // Gửi dữ liệu JSON về client
        out.print(jsonResponse);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
