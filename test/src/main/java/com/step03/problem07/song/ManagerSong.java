package com.step03.problem07.song;

import com.step03.problem07.song.type.GenreType;

public class ManagerSong extends Song{
    private GenreType genreType;
    public ManagerSong(String title, int playTime, String songWriter, String genreType) {
        super(title, playTime, songWriter);
        this.genreType = GenreType.fromKoreanName(genreType);
    }

    public ManagerSong(String[] info) {
        super(info);
        this.genreType = GenreType.fromKoreanName(info[3]);
    }

    public GenreType getGenreType() {
        return genreType;
    }
}
