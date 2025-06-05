package com.step5.problem02.customException;

public class EmptyFileException extends Exception{
    private static final long serialVersionUID = 1L;

    public EmptyFileException() {
        super("[EmptyFileException] 파일 내부 내용은 비어 있습니다.");
    }
}
