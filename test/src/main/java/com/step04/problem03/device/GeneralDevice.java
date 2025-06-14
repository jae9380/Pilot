package com.step04.problem03.device;

public class GeneralDevice implements GeneralDeviceFeatures {
    private DeviceDetails details;

    public GeneralDevice(String model) {
        this.details = new DeviceDetails(model, false, "");
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
    public String getDeviceName() {
        return details.getModel();
    }
}
