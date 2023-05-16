package com.andymazik.module3projects;

import com.andymazik.module3projects.entity.User;
import com.andymazik.module3projects.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@SuppressWarnings("RedundantThrows")
@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    UserService userService = UserService.USER_SERVICE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parameterId = request.getParameter("id");
        if (Objects.nonNull(parameterId)) {
            long id = Long.parseLong(parameterId);
            Optional<User> optionalUser = userService.get(id);

            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                request.setAttribute("user", user);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/user.jsp");
                requestDispatcher.forward(request, response);
            }
        }
        response.sendRedirect("users");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
