//package com.step3.problem03.entity.type;
//
//public enum DigestionType {
//    HERBIVORE("초식"),
//    CARNIVORE("육식"),
//    OMNIVORE("잡식"),
//    UNKNOWN("알 수 없음");
//
//    private final String koreanName;  // 한글 출력을 위함
//
//    DigestionType(String koreanName) {
//        this.koreanName = koreanName;
//    }
//
//    public String getKoreanName() {
//        return koreanName;
//    }
//
//    public static DigestionType fromKoreanName(String korean) { // 객체 생성 시 input에 해당하는 타입 반환을 위한 메서드
//        for (DigestionType type : DigestionType.values()) {
//            if (type.getKoreanName().equals(korean)) {
//                return type;
//            }
//        }
//        throw new IllegalArgumentException("지원하지 않는 소화 방식: " + korean);
//    }
//}
//
