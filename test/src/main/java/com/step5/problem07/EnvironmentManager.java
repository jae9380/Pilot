//package com.step5.problem07;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.NoSuchElementException;
//
//public class EnvironmentManager {
//    private final EnvironmentFileRepository efr;
//
//    public EnvironmentManager() {
//        this.efr = new EnvironmentFileRepository();
//    }
//
//    public void showDataByDateTime(String dateTime) {
//        if (!validationDateTime(dateTime)) return;
//
//        EnvironmentData data;
//        try {
//            data = getByDateTime(dateTime);
//        } catch (NoSuchElementException e) {
//            System.out.println(e.getMessage());
//            return;
//        } catch (RuntimeException e) {
//            System.out.println(e.getMessage());
//            return;
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//            return;
//        }
//        data.displayInfo();
//
//    }
//
//    private boolean validationDateTime(String dateTime) {
//        if (dateTime == null || !dateTime.matches("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}$")) {
//            System.out.println("날짜 입력이 틀렸습니다.\n\t날짜 입력은 yyyy-MM-dd HH:mm형태로 숫자만을 입력하세요.\n");
//            return false;
//        }else return true;
//    }
//
//    private EnvironmentData getByDateTime(String dateTime) throws IOException {
//        EnvironmentData data = efr.getByDateTime(dateTime);
//        if (data == null) throw new NoSuchElementException("→ 해당 날짜의 데이터는 존재하지 않습니다.");
//        return data;
//    }
//
//}
