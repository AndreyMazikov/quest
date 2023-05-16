package com.andymazik.module3projects;

import java.io.*;
import java.util.Collection;

import com.andymazik.module3projects.entity.User;
import com.andymazik.module3projects.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "UsersServlet", value = "/users")
public class UsersServlet extends HttpServlet {
    private final UserService userService = UserService.USER_SERVICE;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Collection<User> users = userService.getAll();
        request.setAttribute("users", users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/users.jsp");
        requestDispatcher.forward(request, response);
    }
}