package com.step03.problem07.song.type;

public enum AnimalType {
    DEER("사슴"),
    DONKEY("당나귀"),
    ELEPHANT("코끼리"),
    TIGER("호랑이"),
    PENGUIN("펭귄"),
    MONKEY("원숭이");


    private final String koreanName;  // 한글 출력을 위함

    AnimalType(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }

    public static AnimalType fromKoreanName(String korean) {
        for (AnimalType type : AnimalType.values()) {
            if (type.getKoreanName().equals(korean)) {
                return type;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 동물 입니다.: " + korean);
    }

    public static boolean animalTypeAnyMatches(String str) {
        for (AnimalType type : AnimalType.values()) {
            if (type.getKoreanName().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
