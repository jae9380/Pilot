package com.step05.problem01;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Journal {
    private String fileName;
    private String content;
    public Journal(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    public void displayContent() {
        System.out.println("→ " + fileName);
        System.out.println(content);
    }

//    문제 2번을 위한 메서드
    public void displayContent2() {
        System.out.println("→ " + getDate());
        System.out.println(content);
    }

    private String getDate()  {
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        해당 데이터는 사전에 JournalManager2.validateFileName() 에서 파일 이름에서 날짜 데이터 형식을 먼저 검증
//        그렇기 해당 예외는 발생 할 일이 없다고 판단. 자체적을 예외 발생에 대한 코드를 작성
        try {
            return outputDateFormat.format(
                    new SimpleDateFormat("yyyyMMddHHmm")
                            .parse(fileName.substring(0,12))
            );
        }catch (ParseException e) {
            return "";
        }
    }
}
