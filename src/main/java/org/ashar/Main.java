package org.ashar;

import org.ashar.DAO.MusicDao;
import org.ashar.DAO.UserDao;
import org.ashar.Entity.Music;
import org.ashar.Entity.User;
import org.ashar.Service.UserService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        UserDao userDao = new UserDao();
//        System.out.println(userDao.getUser("hanzalashahab@gmail.com"));
//        userDao.deleteUser("hanzalashahab@gmail.com");
        User user = new User();
        user.setUsername("admin");
        user.setEmail("admin@gmail.com");
        user.setPassword("admin");

        UserService service = new UserService();
//        service.registerUser(user);
//        userDao.save(user);

//        File song = new File("C:/Users/Rohit/Downloads/Songs/Rooh Yo Yo Honey Singh 320 Kbps.mp3");
//        Music music = new Music();
//        music.setGenre("Pop");
//        music.setTitle("Rooh");
//        music.setArtist("Honey Sing");
//        music.setMusicFile(Files.readAllBytes(song.toPath()));

        MusicDao musicDao = new MusicDao();
        musicDao.delete(27L);
//        musicDao.addMusic(music);
//        System.out.println(musicDao.get().getFirst().getMusicFile());
    }
}