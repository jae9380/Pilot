package com.step5.problem03;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Journal {
    private String fileName;
    private String content;
    public Journal(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
