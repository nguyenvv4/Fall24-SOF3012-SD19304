package com.example.sd19304.servlet;

import com.example.sd19304.model.User;
import com.example.sd19304.repository.UserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = {"/UserServlet",
        "/home",
        "/add",
        "/detail",
        "/delete",
        "/update",
})
public class UserServlet extends HttpServlet {

    UserRepository userRepository = new UserRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/home")) {
            List<User> list = userRepository.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/user.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            User user = userRepository.getById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            User user = userRepository.getById(id);
            if (user != null) {
                userRepository.delete(user);
            } else {
                System.out.println("Khong tim thay");
            }
            response.sendRedirect("/home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String fullname = request.getParameter("fullname");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            Boolean admin = Boolean.valueOf(request.getParameter("admin"));
            User user = new User(password, fullname, email, admin);
            userRepository.saveOrUpdate(user);
            response.sendRedirect("/home");
        } else if (uri.contains("/update")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String fullname = request.getParameter("fullname");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            Boolean admin = Boolean.valueOf(request.getParameter("admin"));
            User user = new User(id, password, fullname, email, admin);
            userRepository.saveOrUpdate(user);
            response.sendRedirect("/home");
        }

    }
}
