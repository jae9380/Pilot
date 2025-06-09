package com.step5.problem04;

import javax.swing.*;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EnvironmentManager {

    private final EnvironmentFileRepository efr;
    public EnvironmentManager() {
        efr = new EnvironmentFileRepository();
        System.out.println("환경 정보 관리 시스템에 오신 것을 환영합니다.");
    }

/*
 문제 점 발경
 .txt 파일에 데이터를 저장할 깨 콤마(,)를 사용하여 데이터를 한 줄로 저장하게 된다.
 하지만 만약 데이터 중 특정 요소에 콤마(,)를 포함하고 있을 경우, 데이터가 짤리게 되는 문제가 발생된다.

 임시 해결 방안
 입력된 데이터의 특정 요소에서 콤마(,)를 포함하고 있을 경우 "|"으로 대체하여 저장
*/
    public void register(String temperature, String humidity, String oxygenLevel, String location) {
        if (!validationEnvironmentDate(temperature, humidity, oxygenLevel, location)) {
            System.out.println("[EnvironmentManager] 데이터 저장을 실패 했습니다. 처음부터 다시 시작하세요.");
            return;
        }

        EnvironmentData ed = new EnvironmentData(temperature, humidity, oxygenLevel, location.replaceAll(",","|"));

        try {
            efr.save(ed);
        } catch (IOException e) {
            System.out.println("[EnvironmentManager] 데이터를 저장하는 과정 중 문제가 발생하였습니다.\n"+e.getMessage());
        }
    }

    public void showAllData() {
        for (EnvironmentData data : getAllData()) {
            data.displayInfo();
        }
    }

    public void sortByDate() {
        List<EnvironmentData> list = getAllData();

        Collections.sort(list);
        for (EnvironmentData data : list) {
            data.displayInfo_2();
        }
    }

    private List<EnvironmentData> getAllData() {
        try {
            return efr.loadAll();
        } catch (IOException e) {
            System.out.println("[EnvironmentManager] 데이터를 읽어오는 중 문제가 발생 했습니다.\n"+e.getMessage());
            return null;
        }
    }
//        입력된 데이터 유효한 형태인지 검증
    private boolean validationEnvironmentDate(String... elements) {
        try {
            for (int i = 0; i < 2; i++) {
                Double.parseDouble(elements[i]);
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("[EnvironmentManager] 입력된 값의 형태가 옳바르지 않습니다.");
            return false;
        }
    }
}
