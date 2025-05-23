package com.step3.problem07.song;

public class Song {
    private final String title;
    private final int playTime;
    private final String songWriter;

    public Song(String title, int playTime, String songWriter) {
        this.title = title;
        this.playTime = playTime;
        this.songWriter = songWriter;
    }

    public Song(String[] info) {
        this.title = info[0];
        this.playTime = Integer.parseInt(info[1]);
        this.songWriter = info[2];
    }

    public String getTitle() {
        return title;
    }
}
