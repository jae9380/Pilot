package com.step4.problem03.device;

public interface SmartDeviceFeatures extends GeneralDeviceFeatures {
//    기존 인터페이스에서 스마트 기기에서 지원하는 기능을 분리
    void activateFeature();
}
