package com.step03.problem07;

import com.step03.problem07.song.AnimalSong;
import com.step03.problem07.song.ManagerSong;
import com.step03.problem07.song.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MusicLibrary {
    private List<Song> playList = new ArrayList<>();

    public void addSong(Song song) {
        playList.forEach(song1 -> {
            if (song1.getTitle().equals(song.getTitle()))
                throw new IllegalArgumentException("이미 존재하는 제목입니다: "+ song.getTitle());
        });
        playList.add(song);
        System.out.printf("[MusicLibary] 새로운 노래 \"%1$s\" 추가되었습니다. \n", song.getTitle());
    }

    public void removeSongByTitle(String title) {
        if (!playList.removeIf(song -> song.getTitle().equals(title)))
            throw new IllegalArgumentException(" 존재하지 않는 제목입니다: "+ title);

        System.out.printf("[MusicLibary] \"%1$s\"제목의 노래를 제거 했습니다.\n", title);


    }

    public List<Song> getByAnimalOrHuman(boolean isItAnimalSong, boolean isItHumanSong) {
        return playList.stream()
                .filter(song -> (isItAnimalSong && song instanceof AnimalSong) ||
                        (isItHumanSong && song instanceof ManagerSong))
                .collect(Collectors.toList());
    }

    public List<Song> searchByAnimal(String koreanName) {
        return playList.stream()
                .filter(song -> song instanceof AnimalSong)
                .map(song -> (AnimalSong) song)
                .filter(song -> song.getAnimalType().getKoreanName().equals(koreanName))
                .collect(Collectors.toList());
    }

    public List<Song> searchByGenre(String koreanName) {
        return playList.stream()
                .filter(song -> song instanceof ManagerSong)
                .map(song -> (ManagerSong) song)
                .filter(song -> song.getGenreType().getKoreanName().equals(koreanName))
                .collect(Collectors.toList());
    }

    public Song searchByTitle(String title) {
        return playList.stream()
                .filter(song -> song.getTitle().equals(title))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("제목에 해당하는 노래가 없습니다: " + title));
    }
}
