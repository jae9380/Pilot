package com.step05.problem03;

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
