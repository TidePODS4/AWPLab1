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
        req.setAttribute("users", UserTable.getAllUsers());
        req.getRequestDispatcher("views/admin-panel.jsp")
            .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String method = req.getParameter("_method");
        if (method != null && method.equals("put")) {
            doPut(req, resp);
            return;
        } else if (method != null && method.equals("delete")) {
            doDelete(req, resp);
            return;
        }
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        var admin = req.getParameter("admin");
        boolean isAdmin = "on".equals(admin);

        User user = new User(login, password, isAdmin);

        try {
            UserTable.addUser(user);
            req.setAttribute("newUserLogin", user.getLogin());
        } catch (UserAlreadyExistsException e) {
            req.setAttribute("isExists", true);
        } finally {
            resp.sendRedirect("/admin-panel");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        var admin = req.getParameter("admin");
        boolean isAdmin = "on".equals(admin);

        User user = new User(login, password, isAdmin);

        UserTable.update(user);

        resp.sendRedirect("/admin-panel");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        UserTable.deleteByLogin(login);

        resp.sendRedirect("/admin-panel");
    }
}
