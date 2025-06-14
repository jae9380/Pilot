package com.step04.problem03;

import com.step04.problem03.device.GeneralDeviceFeatures;
import com.step04.problem03.device.SmartDeviceFeatures;

import java.util.ArrayList;
import java.util.List;

public class DeviceController {
    private List<GeneralDeviceFeatures> registeredDevices = new ArrayList<>();

    // 단일 기기 등록 및 제거
    public void registerDevice(GeneralDeviceFeatures device) {
        registeredDevices.add(device);
        System.out.printf("컨트롤러에 기기가 등록되었습니다. %s\n", device.getDeviceName());
    }

    public void removeDevice(GeneralDeviceFeatures device) {
        registeredDevices.remove(device);
        System.out.println("기기가 제거되었습니다.");
    }

    // 단일 기기 조작
    public void powerOnDevice(GeneralDeviceFeatures device) {
        device.powerOn();
    }

    public void activateSmartFeature(GeneralDeviceFeatures device) {
        if (device instanceof SmartDeviceFeatures smartDevice) {
            smartDevice.activateFeature();
        } else {
            System.out.println("이 기기는 스마트 기능이 없습니다.");
        }
    }

    public void controlDevice(GeneralDeviceFeatures device) {
        powerOnDevice(device);
        activateSmartFeature(device);
    }

    // 전체 기기 통합 제어
    public void controlAllDevice() {
        for (GeneralDeviceFeatures device : registeredDevices) {
            powerOnDevice(device);
            activateSmartFeature(device);
        }
    }

    public void powerOffAllDevices(GeneralDeviceFeatures... devices) {
        for (GeneralDeviceFeatures device : devices) {
            device.powerOff();
        }
    }
}
