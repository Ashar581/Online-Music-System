package org.ashar.Controller;

import org.ashar.Entity.Music;
import org.ashar.Service.MusicService;
import org.ashar.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/music")
@MultipartConfig
public class MusicServlet extends HttpServlet {
    private MusicService musicService;
    @Override
    public void init() throws ServletException{
        musicService = new MusicService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String musicId = req.getParameter("id");

        // Fetch the Music entity from the database
        Music music = musicService.getMusic(Long.parseLong(musicId));

        if (music != null) {
            resp.setContentType("audio/mp3");
            resp.setContentLength(music.getMusicFile().length);
            resp.getOutputStream().write(music.getMusicFile());

        } else {
            req.setAttribute("errorMessage","Wrong email/password.");
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("isAdmin")==null || ((int)(req.getSession().getAttribute("isAdmin"))==0)){
            req.setAttribute("errorMessage","Only Admins are allowed to upload music.");
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }
        String artist = req.getParameter("artist");
        String title = req.getParameter("title");
        String genre = req.getParameter("genre");
        Part musicFile = req.getPart("music_file");

        Music musicToBeAdded = new Music();
        musicToBeAdded.setMusicFile(musicFile.getInputStream().readAllBytes());
        musicToBeAdded.setTitle(title);
        musicToBeAdded.setArtist(artist);
        musicToBeAdded.setGenre(genre);

        try{
            musicService.addMusic(musicToBeAdded);
        }catch (Exception e){
            req.setAttribute("errorMessage",e.getMessage());
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }
        req.getRequestDispatcher("/admin.jsp").forward(req,resp);
    }
}
