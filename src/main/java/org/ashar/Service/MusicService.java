package org.ashar.Service;

import org.ashar.DAO.MusicDao;
import org.ashar.Entity.Music;

import java.util.List;

public class MusicService {
    private MusicDao musicDao = new MusicDao();

    public boolean addMusic(Music music){
        if (music.getMusicFile()==null || music.getArtist()==null
                || music.getArtist().isBlank() || music.getTitle()==null || music.getTitle().isBlank()){
            throw new RuntimeException("Please fill all the details.");
        }
        if (music.getGenre()==null) music.setGenre("");
        if (musicDao.addMusic(music)!=null) {
            return true;
        }
        return false;
    }
    public List<Music> getAllMusic(){
        return musicDao.get();
    }
    public Music getMusic(Long id){
        return musicDao.get(id);
    }
}
