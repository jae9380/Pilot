package com.step03.problem08.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {

    public static String formatDateToKorean(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        return date.format(formatter);
    }
    public static LocalDateTime formatDateToLocalDateTime(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        LocalDate localDate = LocalDate.parse(dateStr, formatter);
        return localDate.atStartOfDay();
    }
}
