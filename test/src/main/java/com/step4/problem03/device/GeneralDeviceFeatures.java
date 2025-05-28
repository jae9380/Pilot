package com.step4.problem03.device;

public interface GeneralDeviceFeatures {
/*
    Device 인터페이스가 모든 기기에 activateFeature()를 강제하고 있다.
    그러면 해당 기능이 필요없는 일반 전자 기기에서 강제로 구현하게 된다.

    이를 해결하기 위해서 스마트 기기에만 구현하기 위해 SmartDeviceFeatures로 분리.
*/
    void powerOn();
    void powerOff();
    String getDeviceName();
}