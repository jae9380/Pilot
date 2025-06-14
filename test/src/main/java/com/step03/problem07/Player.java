package com.step03.problem07;

import com.step03.problem07.song.AnimalSong;
import com.step03.problem07.song.Song;

public class Player {
    private static final int MAX_VOLUME_ANIMAL = 5;
    private static final int MAX_VOLUME_HUMAN = 50;
    private static final int MIN_VOLUME = 0;
    private Song song;
    private int volume;

    public void play(Song song) {
        this.song = song;

        if (song instanceof AnimalSong && volume > MAX_VOLUME_ANIMAL) {
            volume = MAX_VOLUME_ANIMAL;
            System.out.printf("[Player] 동물의 청각 보호를 위해 볼륨을 %d 으로 조정합니다.\n", volume);
        }
        System.out.printf("[Player] \"%1$s\" 제목의 노래를 재생합니다.\n", song.getTitle());
    }

    public void stop() {
        if (song == null) {
            System.out.println("[Player] 재생 중인 노래가 없습니다.");
        } else {
            System.out.printf("[Player] \"%s\" 제목의 노래 재생을 일시 정지합니다.\n", song.getTitle());
        }
    }

    public void setVolume(int volume) {
        int max = (song instanceof AnimalSong) ? MAX_VOLUME_ANIMAL : MAX_VOLUME_HUMAN;
        if (volume < MIN_VOLUME || volume > max) {
            System.out.printf("[Player] 볼륨은 0부터 %d 까지 설정할 수 있습니다.\n", max);
            return;
        }
        this.volume = volume;
        System.out.printf("[Player] 볼륨을 %d 으로 설정합니다.\n", volume);
    }
}
