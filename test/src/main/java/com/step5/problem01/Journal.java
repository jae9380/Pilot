package com.step5.problem01;

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
}
