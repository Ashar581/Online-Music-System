package org.ashar.Controller;

import org.ashar.Entity.Music;
import org.ashar.Main;
import org.ashar.Service.MusicService;
import org.ashar.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;
    private MusicService musicService;
    @Override
    public void init(){
        userService = new UserService();
        musicService = new MusicService();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username;
        String password;
        if (req.getSession().getAttribute("username")!=null && req.getSession().getAttribute("password")!=null){
            username = req.getSession().getAttribute("username").toString();
            password = req.getSession().getAttribute("password").toString();
        }
        else {
            username = req.getParameter("email");
            password = req.getParameter("password");
        }
        try {
            if (userService.login(username, password)) {
                req.getSession().setAttribute("username",username);
                req.getSession().setAttribute("password",password);
                req.getSession().setAttribute("isAdmin",userService.getUser(username).getIsAdmin());
                //get all the music list
                List<Music> musicList = musicService.getAllMusic();
                req.setAttribute("username",username);
                req.setAttribute("musicList", musicList);
                req.getRequestDispatcher("/music.jsp").forward(req,resp);
            } else {
                req.setAttribute("errorMessage","Wrong email/password.");
                req.getRequestDispatcher("/error.jsp").forward(req,resp);
            }
        }catch (RuntimeException e){
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
