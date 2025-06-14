package com.step04.problem03;

import com.step04.problem03.device.GeneralDevice;
import com.step04.problem03.device.GeneralDeviceFeatures;
import com.step04.problem03.device.SmartDevice;

public class RuleOfBiodome03 {
    public static void main(String[] args) {
/*
    기존 코드에서
    Device allPurposeDevice2 = new AllPurposeDevice("냉장고", null);
    controller.controlDevice(allPurposeDevice2);
    Device 내부 activateFeature()가 항상 호출되지만 일반 전자 기기인 냉장고는
    기능이 없으므로 null이 전달되고 실행 시 예외 발생 가능성 또는 의미 없는 출력이 된다.
    이는 LSP원칙에서 하위 타입은 상위 타입으로 교체를 하여도 문제가 없어야 한다는 부분을 위반한다고 판단이 된다.
*/

        GeneralDeviceFeatures allPurposeDevice1 = new GeneralDevice("도어 오프너");

        GeneralDeviceFeatures allPurposeDevice2 = new SmartDevice("자동 거울", "기분을 인식해 옷을 추천하는 기능");

        DeviceController controller = new DeviceController();
        controller.registerDevice(allPurposeDevice1);
        controller.registerDevice(allPurposeDevice2);

        controller.controlAllDevice();
        controller.powerOffAllDevices(allPurposeDevice1, allPurposeDevice2);
    }
}
