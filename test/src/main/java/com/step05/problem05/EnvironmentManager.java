//package com.step05.problem05;
//
//
//
//import java.io.IOException;
//import java.util.Collections;
//import java.util.List;
//
//public class EnvironmentManager {
//
//    private final EnvironmentFileRepository efr;
//    public EnvironmentManager() {
//        efr = new EnvironmentFileRepository();
//        System.out.println("환경 정보 관리 시스템에 오신 것을 환영합니다.");
//    }
//
//    public void register(String temperature, String humidity, String oxygenLevel, String location) {
//        if (!validationEnvironmentDate(temperature, humidity, oxygenLevel, location)) {
//            System.out.println("[EnvironmentManager] 데이터 저장을 실패 했습니다. 처음부터 다시 시작하세요.");
//            return;
//        }
//
//        EnvironmentData ed = new EnvironmentData(temperature, humidity, oxygenLevel, location.replaceAll(",","|"));
//
//        try {
//            efr.save(ed);
//        } catch (IOException e) {
//            System.out.println("[EnvironmentManager] 데이터를 저장하는 과정 중 문제가 발생하였습니다.\n"+e.getMessage());
//        }
//    }
//
//    public void showAllData() {
//        int count = 0;
//        List<EnvironmentData> list = getAllData();
//
//        if (list == null) return;
//
//        for (EnvironmentData data : list) {
//            System.out.print(++count+". ");
//            data.displayInfo();
//        }
//    }
//
//    public void sortByDate() {
//        List<EnvironmentData> list = getAllData();
//
//        if (list == null) return;
//
//        Collections.sort(list);
//        for (EnvironmentData data : list) {
//            data.displayInfo_3();
//        }
//    }
//
//
//    private List<EnvironmentData> getAllData() {
//        try {
//            List<EnvironmentData> list =  efr.loadAll();
//
//            if (list.isEmpty()) throw new NullPointerException();
//            return list;
//        } catch (IOException e) {
//            System.out.println("[EnvironmentManager] 데이터를 읽어오는 중 문제가 발생 했습니다.\n"+e.getMessage());
//            return null;
//        } catch (NullPointerException e) {
//            System.out.println("[EnvironmentManager] 저장된 데이터가 없습니다.");
//            return null;
//        }
//    }
////        입력된 데이터 유효한 형태인지 검증
//    private boolean validationEnvironmentDate(String... elements) {
//        try {
//            for (int i = 0; i < 2; i++) {
//                Double.parseDouble(elements[i]);
//            }
//            return true;
//        } catch (NumberFormatException e) {
//            System.out.println("[EnvironmentManager] 입력된 값의 형태가 옳바르지 않습니다.");
//            return false;
//        }
//    }
//}
