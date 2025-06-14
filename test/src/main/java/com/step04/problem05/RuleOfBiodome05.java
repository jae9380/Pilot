package com.step04.problem05;

public class RuleOfBiodome05 {
    public static void main(String[] args) {

        PlantHashMap<String, String> plantMap = new PlantHashMap<>();

        // 식물 10개 저장
        plantMap.put("장미", "가시가 있고 향기가 좋다");
        plantMap.put("튤립", "봄에 피며 다양한 색을 가진다");
        plantMap.put("해바라기", "태양을 따라 움직인다");
        plantMap.put("선인장", "건조한 지역에서 잘 자란다");
        plantMap.put("연꽃", "물 위에서 자란다");
        plantMap.put("소나무", "사계절 푸르다");
        plantMap.put("대나무", "빠르게 자란다");
        plantMap.put("무궁화", "한국의 국화이다");
        plantMap.put("코스모스", "가을을 상징한다");
        plantMap.put("벚꽃", "봄에 꽃이 핀다");

        // 식물 조회
        plantMap.get("해바라기");
        plantMap.get("장미");

        // 식물 삭제
        plantMap.remove("소나무");
        plantMap.get("소나무"); // 삭제 후 조회 시도

        plantMap.getIndexAndDisplayInfo("선인장");
        plantMap.getIndexAndDisplayInfo("해바라기");
    }
}
