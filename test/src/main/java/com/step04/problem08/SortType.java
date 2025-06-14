package com.step04.problem08;

public enum SortType {
    TITLE("제목"),              // 기본 정렬 (compareTo)
    AUTHOR("저자"),             // 저자 기준
    PUBLISHED_DATE("출판일"),     // 출판일 기준
    AVAILABILITY("대출 가능"),       // 대출 가능 여부
    LAST_BORROWED_DATE("최근 대출일");  // 최근 대출일 기준 (최신순)

    SortType(String korean) {
        this.korean = korean;
    }

    private final String korean;

    public String getKorean() {
        return korean;
    }
}
