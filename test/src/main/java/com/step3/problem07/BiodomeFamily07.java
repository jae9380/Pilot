package com.step3.problem07;

import com.step3.problem07.song.AnimalSong;
import com.step3.problem07.song.ManagerSong;
import com.step3.problem07.song.Song;
import com.step3.problem07.song.type.AnimalType;
import com.step3.problem07.song.type.GenreType;

public class BiodomeFamily07 {
//        "초원을 그리며,2,레이나,사슴" "영웅 호테,1,돈키,당나귀" "과자를 줄게,3,제롬,코끼리" "화양연화,2,장양림,재즈" "시간의 수평선,4,하윤,팝"
    public static void main(String[] args) {
        Song song;

        MusicLibrary musicLibrary = new MusicLibrary();
        Player player = new Player();

        for (String arg : args) {
            String[] info = arg.split(",");
            if (AnimalType.animalTypeAnyMatches(info[3])){
                song = new AnimalSong(info);
            } else if (GenreType.genreTypenyMatches(info[3])) {
                song =  new ManagerSong(info);
            }else song = null;
//            song = new Song(arg.split(","));

            musicLibrary.addSong(song);
        }

        player.play(musicLibrary.searchByTitle("화양연화"));
        player.setVolume(30);

        player.play(musicLibrary.searchByTitle("과자를 줄게"));
        musicLibrary.removeSongByTitle("시간의 수평선");

    }
}
