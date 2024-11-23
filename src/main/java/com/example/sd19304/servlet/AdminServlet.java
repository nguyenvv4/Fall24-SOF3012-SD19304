package com.example.sd19304.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminServlet", value = {"/admin/hien-thi",
        "/admin/thong-ke",
        "/admin/them-nhan-vien"
})
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri= request.getRequestURI();
        if (uri.contains("/admin/hien-thi")){
            request.setAttribute("message","Day la trang admin hien thi");
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
        }else if (uri.contains("/admin/thong-ke")){
            request.setAttribute("message","Day la trang admin thong ke");
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
        } else if (uri.contains("/admin/them-nhan-vien")) {
            request.setAttribute("message","Day la trang admin them nhan vien");
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
