package com.awp.lab1.servlet;

import com.awp.lab1.database.UserTable;
import com.awp.lab1.entity.User;
import com.awp.lab1.exception.UserAlreadyExistsException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminPanelServlet", value = "/admin-panel")
public class AdminPanelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/add-user.jsp")
            .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        boolean isAdmin = Boolean.parseBoolean(req.getParameter("isAdmin"));

        User user = new User(login, password, isAdmin);

        try {
            UserTable.addUser(user);
        } catch (UserAlreadyExistsException e) {
            req.setAttribute("isExists", true);
            req.getRequestDispatcher("views/admin-panel.jsp").forward(req, resp);
        }

        req.setAttribute("newUserLogin", user.getLogin());
        req.getRequestDispatcher("views/admin-panel.jsp").forward(req, resp);
    }
}
