package org.ashar.Entity;

public class Music {
    private Long music_id;
    private String title;
    private String artist;
    private String genre;
    private byte [] audio_file;

    public Music(){}
    public Music(Long music_id, String title, String artist, String genre, byte[] musicFile) {
        this.music_id = music_id;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.audio_file = musicFile;
    }

    public Long getMusic_id() {
        return music_id;
    }

    public void setMusic_id(Long music_id) {
        this.music_id = music_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public byte[] getMusicFile() {
        return audio_file;
    }

    public void setMusicFile(byte[] musicFile) {
        this.audio_file = musicFile;
    }
}
