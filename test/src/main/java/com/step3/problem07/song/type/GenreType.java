package com.step3.problem07.song.type;

public enum GenreType {
    JAZZ("재즈"),
    POP("팝"),
    CLASSICAL("클래식"),
    HIPHOP("힙합"),
    RNB("R&B");

    private final String koreanName;  // 한글 출력을 위함

    GenreType(String koreanName) {
        this.koreanName = koreanName;
    }
    public String getKoreanName() {
        return koreanName;
    }

    public static GenreType fromKoreanName(String korean) {
        for (GenreType type : GenreType.values()) {
            if (type.getKoreanName().equals(korean)) {
                return type;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 장르 입니다.: " + korean);
    }

    public static boolean genreTypenyMatches(String str) {
        for (GenreType type : GenreType.values()) {
            if (type.getKoreanName().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
