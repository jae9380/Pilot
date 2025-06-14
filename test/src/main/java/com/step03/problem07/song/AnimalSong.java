package com.step03.problem07.song;

import com.step03.problem07.song.type.AnimalType;

public class AnimalSong extends Song{
    private AnimalType animalType;

    public AnimalSong(String title, int playTime, String songWriter, String animalType) {
        super(title, playTime, songWriter);
        this.animalType = AnimalType.fromKoreanName(animalType);
    }

    public AnimalSong(String[] info) {
        super(info);
        this.animalType = AnimalType.fromKoreanName(info[3]);
    }

    public AnimalType getAnimalType() {
        return animalType;
    }
}
