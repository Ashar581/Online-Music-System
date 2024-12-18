package org.ashar.DAO;

import org.ashar.Entity.Music;
import org.ashar.Util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusicDao {
    public Music addMusic(Music music){
        String query = "INSERT INTO Music (title,artist,genre,audio_file) values (?,?,?,?)";
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1,music.getTitle());
            statement.setString(2,music.getArtist());
            statement.setString(3,music.getGenre());
            statement.setBytes(4,music.getMusicFile());

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return music;
    }
    public List<Music> get(){
        String query = "SELECT * FROM Music";

        List<Music> musicList = new ArrayList<>();
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
               Music music = new Music();
               music.setTitle(resultSet.getString("title"));
               music.setMusic_id(resultSet.getLong("music_id"));
               music.setArtist(resultSet.getString("artist"));
               music.setGenre(resultSet.getString("genre"));
               music.setMusicFile(resultSet.getBytes("audio_file"));

               musicList.add(music);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return musicList;
    }
    public Music get(Long id){
        String query = "SELECT * FROM Music WHERE music_id = ?";

        Music music = new Music();
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();;
            while (resultSet.next()){
                music.setTitle(resultSet.getString("title"));
                music.setMusic_id(resultSet.getLong("music_id"));
                music.setArtist(resultSet.getString("artist"));
                music.setGenre(resultSet.getString("genre"));
                music.setMusicFile(resultSet.getBytes("audio_file"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return music;
    }
    public void delete(Long id){
        String query = "DELETE FROM Music WHERE music_id = ?";
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setLong(1,id);

            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
