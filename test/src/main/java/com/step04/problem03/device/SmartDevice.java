package com.step04.problem03.device;

public class SmartDevice implements SmartDeviceFeatures {
    private DeviceDetails details;
    private String features;

    public SmartDevice(String model, String features) {
        this.details = new DeviceDetails(model, true, features);
        this.features = features;
    }

    @Override
    public void powerOn() {
        System.out.printf("%s 전원을 켰습니다.\n", details.getModel());
    }

    @Override
    public void powerOff() {
        System.out.printf("%s 전원을 종료 했습니다.\n", details.getModel());
    }

    @Override
    public void activateFeature() {
        System.out.println(features + "을 실행합니다.");
    }

    @Override
    public String getDeviceName() {
        return details.getModel();
    }
}
