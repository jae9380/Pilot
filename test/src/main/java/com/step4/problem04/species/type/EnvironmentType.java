//package com.step4.problem04.species.type;
//
//public enum EnvironmentType {
//    ACIDIC("산성"),
//    ALKALINE("염기성"),
//    NEUTRAL("중성");
//
//    private final String korean;
//
//    EnvironmentType(String korean) {
//        this.korean = korean;
//    }
//
//    public String toKorean() {
//        return korean;
//    }
//
//    public static EnvironmentType fromKorean(String korean) {
//        for (EnvironmentType type : EnvironmentType.values()) {
//            if (type.toKorean().equals(korean)) {
//                return type;
//            }
//        }
//        throw new IllegalArgumentException("일치하는 타입이 업습니다 : " + korean);
//    }
//}