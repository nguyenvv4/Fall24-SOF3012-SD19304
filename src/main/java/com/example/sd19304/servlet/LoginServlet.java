package com.example.sd19304.servlet;

import com.example.sd19304.model.User;
import com.example.sd19304.repository.UserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    UserRepository userRepository = new UserRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        User user = userRepository.getByEmail(email);
        if (user == null) {
            request.setAttribute("error", "email khong chinh xac");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else if (!user.getPassword().equals(pass)) {
            request.setAttribute("error", "password khong chinh xac");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.getRequestDispatcher("login-thanh-cong.jsp").forward(request, response);
        }

    }
}
