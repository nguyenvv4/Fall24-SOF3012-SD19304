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
        "/add"
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
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String id = request.getParameter("id");
            String fullname = request.getParameter("fullname");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            Boolean admin = Boolean.valueOf(request.getParameter("admin"));
            User user = new User(id, password, fullname, email, admin);
            userRepository.add(user);
            response.sendRedirect("/home");
        }

    }
}
