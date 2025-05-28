//package com.step4.problem04.species.type;
//
//public enum MetabolismType {
//    RESPIRATION("호흡"),
//    PHOTOSYNTHESIS("광합성"),
//    FERMENTATION("발효");
//
//    private final String korean;
//
//    MetabolismType(String korean) {
//        this.korean = korean;
//    }
//
//    public String toKorean() {
//        return korean;
//    }
//
//    public static MetabolismType fromKorean(String korean) {
//        for (MetabolismType type : MetabolismType.values()) {
//            if (type.toKorean().equals(korean)) {
//                return type;
//            }
//        }
//        throw new IllegalArgumentException("일치하는 타입이 업습니다 : " + korean);
//    }
//}
