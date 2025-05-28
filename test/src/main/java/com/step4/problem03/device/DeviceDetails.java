package com.step4.problem03.device;

import java.util.Optional;

public class DeviceDetails {
/*
    해당 클래스 내부에서 객체의 정보 보관과 행동을 모두 책임지고 있다.
    그렇기 때문에 기기의 행동은 관리하지 않도록 분리 하였다.
*/
    private String model;
    private static final String BRAND = "DOMETech";

    public DeviceDetails(String model, boolean isItSmartDevice, String features) {
        this.model = model;
        System.out.printf("%1$s가 생성 되었습니다.\t %2$s, %3$s" + (isItSmartDevice ? ", %4$s\n" : "\n"), isItSmartDevice ? "스마트 기기" : "일반 기기", model, BRAND, features);
    }

    public void displayInfo() {
        System.out.printf("Model: %1$s \t\t Brand: %2$s \n", model, BRAND);
    }

    public String getModel() {
        return model;
    }
}

