package com.example.Diary.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UPLOAD_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "파일 업로드에 실패하였습니다, 관리자에게 문의해 주세요.")
    ;

    private final HttpStatus status;
    private final String message;
}
