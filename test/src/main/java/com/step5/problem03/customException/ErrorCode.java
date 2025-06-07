package com.step5.problem03.customException;

public enum ErrorCode {
    NO_DATA_AVAILABLE_EXCEPTION("[NoDataAvailableException] 분석할 수 없습니다."),
    EMPTY_FILE_EXCEPTION("[EmptyFileException] 파일 내부 내용은 비어 있습니다."),
    EMPTY_FOLDER_EXCEPTION("[EmptyFolderException] 폴더 내부가 비어 있습니다."),
    INVALID_FOLDER_PATH_EXCEPTION("[InvalidFolderPathException] 폴더 경로가 유효하지 않습니다."),
    ILLEGAL_CONTENT_FORMAT_EXCEPTION("[IllegalContentFormatException] 연구일지 내용에 Name. 또는 ADR. 형식이 누락되었습니다.");
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
