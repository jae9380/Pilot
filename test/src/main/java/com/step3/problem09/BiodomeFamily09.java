package com.step3.problem09;

import com.step3.problem09.service.Caffe;

import static com.step3.problem09.entity.menu.MenuType.*;

public class BiodomeFamily09 {
    private static Caffe caffe;
    public static void main(String[] args) {
        caffe = new Caffe();

//        커피 등록
        caffe.addNewMenu(COFFEE, "블랜드", "4000", "일반", "톨");
        caffe.addNewMenu(COFFEE, "다크", "4500", "일반", "톨");
        caffe.addNewMenu(COFFEE, "디카페인", "4200", "일반", "톨");
        System.out.println();
//        음료 등록
        caffe.addNewMenu(DRINK, "캐모마일", "3000", "톨");
        caffe.addNewMenu(DRINK, "오렌지", "3500", "톨");
        caffe.addNewMenu(DRINK, "물", "1000", "톨");
        System.out.println();
//        샌드위치 등록
        caffe.addNewMenu(SANDWICH, "야채 샌드위치", "5000", "야채", "7");
        caffe.addNewMenu(SANDWICH, "햄 샌드위치", "6000", "햄", "-8");
        caffe.addNewMenu(SANDWICH, "치즈 샌드위치", "5500", "치즈", "14");
        System.out.println();

//        전체 메뉴 조회
        caffe.getMenuList();
        System.out.println();

//        메뉴 주문
//        주문 고객 제이미, 블랜드 2잔, 야채 샌드위치 1개
        caffe.createdNewOrder("제이미", new String[][]{{"블랜드", "2"},{"야채 샌드위치", "1"}});
//        주문 고객 레냐, 캐모마일 1잔
        caffe.createdNewOrder("레냐", new String[][]{{"캐모마일", "1"}});
//        유통기한 지난 샌드위치 주문 실패 시나리오
        caffe.createdNewOrder("제이스", new String[][]{{"햄 샌드위치","1"}});

//      전체 주문 리스트
        caffe.getOrderList();


    }
}
