package org.ashar.Controller;

import org.ashar.Entity.User;
import org.ashar.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() {
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user=  new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        try{
            if (userService.registerUser(user)){
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
            }
            else{
                req.setAttribute("errorMessage", "The process was interrupted.");
                req.getRequestDispatcher("/error.jsp").forward(req, resp);
            }
        }catch (Exception e){
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }
}
